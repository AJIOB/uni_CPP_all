package AJIOB.view.composites;

import AJIOB.exceptions.NoInitException;
import AJIOB.model.listeners.Listener;
import AJIOB.model.uni.people.Person;
import AJIOB.model.uni.people.Student;
import AJIOB.model.uni.teaching.Mark;
import AJIOB.view.MainShell;
import AJIOB.view.make.AddPersonShell;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.graphics.Point;

/**
 * Created by AJIOB on 08.03.2017.
 */
public class StudentsComposite extends Composite {
    private Table studTable = null;
    private Table gradeTable = null;
    private Label nameLabel = null;
    private Label gradeBookNumberLabel = null;

    public StudentsComposite(Composite parent, int style) {
        super(parent, style);

        init();
    }

    /**
     * Add all basic functional
     */
    private void init() {
        RowLayout layout = new RowLayout();
        layout.type = SWT.HORIZONTAL;
        layout.spacing = 10;
        layout.fill = true;
        layout.marginHeight = 10;
        layout.marginWidth = 10;
        setLayout(layout);

        makeStudPart(this);
        makeGradeBookPart(this);

        try {
            refreshGradeInfo(MainShell.getUniversity().getStudents().get(0));
        } catch (NoInitException e) {
            e.printStackTrace();
        }

        studTable.setSelection(0);
    }

    /**
     * Make composite with table with students
     *
     * @param parent Parent Composite class
     * @return Composite that made
     */
    private Composite makeStudPart(Composite parent) {
        Composite c = new Composite(parent, SWT.FILL);
        RowLayout layout = new RowLayout();
        layout.type = SWT.VERTICAL;
        layout.spacing = 10;
        layout.fill = true;
        c.setLayout(layout);

        Label label = new Label(c, SWT.LEFT);
        label.setText("Students");

        studTable = makeStudTable(c);

        Button btn = new Button(c, SWT.CENTER | SWT.PUSH);
        btn.setText("Add new one");
        btn.setLayoutData(new RowData(60, 30));
        btn.addListener(SWT.Selection, event -> {
            Person newPerson = AddPersonShell.run();

            try {
                MainShell.getUniversity().enrollStudent(newPerson);
            } catch (NoInitException e) {
                e.printStackTrace();
            } catch (NullPointerException e) {
            }
        });

        return c;
    }

    /**
     * Make and return table with students
     *
     * @param parent Parent Composite
     * @return Table that made
     */
    private Table makeStudTable(Composite parent) {
        final int sizeOfColumn = 120;

        Table table = new Table(parent, SWT.SINGLE | SWT.BORDER | SWT.FULL_SELECTION);
        table.setLayout(new FillLayout());

        TableColumn subject = new TableColumn(table, SWT.LEFT);
        subject.setText("Name");
        subject.setWidth(sizeOfColumn);

        TableColumn educator = new TableColumn(table, SWT.LEFT);
        educator.setText("Grade book number");
        educator.setWidth(sizeOfColumn);

        table.setHeaderVisible(true);

        try {
            for (Student s : MainShell.getUniversity().getStudents()) {
                TableItem tItem = new TableItem(table, SWT.LEFT);
                tItem.setText(new String[]{s.getName(), Integer.toString(s.getGradeBook().getGradeBookNumber())});
            }

            //add listener to changing array
            MainShell.getUniversity().addStudentListener(new Listener<Student>() {
                @Override
                public void SthIsChanged(int changedIndex, Student s) {
                    table.getItem(changedIndex).setText(
                            new String[]{s.getName(), Integer.toString(s.getGradeBook().getGradeBookNumber())}
                    );
                }

                @Override
                public void SthIsAdd(int newElemIndex, Student s) {
                    TableItem tItem = new TableItem(table, SWT.LEFT);
                    tItem.setText(new String[]{s.getName(), Integer.toString(s.getGradeBook().getGradeBookNumber())});
                }

                @Override
                public void SthIsRemoved(int oldElemIndex, Student oldElem) {
                    table.remove(oldElemIndex);
                }
            });

        } catch (NoInitException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
        }

        table.addListener(SWT.Selection, event -> {
            TableItem item = (TableItem) event.item;
            int index = table.indexOf(item);

            try {
                refreshGradeInfo(MainShell.getUniversity().getStudents().get(index));
            } catch (NoInitException e) {
            }
        });

        return table;
    }

    /**
     * Make composite with info about student's grade book
     *
     * @param parent Parent Composite
     * @return Composite that was made
     */
    private Composite makeGradeBookPart(Composite parent) {
        Composite c = new Composite(parent, SWT.FILL);
        RowLayout verticalLayout = new RowLayout();
        verticalLayout.type = SWT.VERTICAL;
        c.setLayout(verticalLayout);

        Label personLabel = new Label(c, SWT.CENTER);
        personLabel.setText("Person info");

        Composite cHeader = new Composite(c, SWT.FILL);
        GridLayout gridLayout = new GridLayout();
        gridLayout.numColumns = 2;
        cHeader.setLayout(gridLayout);

        Label nameTextLabel = new Label(cHeader, SWT.LEFT);
        nameTextLabel.setText("Name: ");

        nameLabel = new Label(cHeader, SWT.LEFT | SWT.SCROLL_LINE);

        Label infoLabel = new Label(cHeader, SWT.LEFT);
        infoLabel.setText("Grade book number: ");

        gradeBookNumberLabel = new Label(cHeader, SWT.FILL);
        gradeBookNumberLabel.setLayoutData(new GridData(GridData.FILL_BOTH));

        gradeTable = makeGradeTable(c);

        Button refreshBtn = new Button(c, SWT.CENTER);
        refreshBtn.setText("Refresh");
        refreshBtn.addListener(SWT.Selection, event -> {
            try {
                System.out.println(Integer.toString(studTable.getSelectionIndex()));
                if (studTable.getSelectionIndex() >= 0)
                    refreshGradeInfo(MainShell.getUniversity().getStudents().get(studTable.getSelectionIndex()));
            } catch (NoInitException e) {
            }
        });

        //todo
        return c;
    }

    /**
     * Make and return table with marks from grade book
     *
     * @param parent Parent Composite
     * @return Table that made
     */
    private Table makeGradeTable(Composite parent) {
        final int sizeOfColumn = 120;

        Table table = new Table(parent, SWT.SINGLE | SWT.BORDER | SWT.FULL_SELECTION);
        table.setLayout(new FillLayout());

        TableColumn subject = new TableColumn(table, SWT.LEFT);
        subject.setText("Subject");
        subject.setWidth(sizeOfColumn);

        TableColumn educator = new TableColumn(table, SWT.LEFT);
        educator.setText("Mark");
        educator.setWidth(sizeOfColumn);

        table.setHeaderVisible(true);

        return table;
    }

    /**
     * Clear and fill again all grade info
     *
     * @param s Student, which info will be shown
     */
    private void refreshGradeInfo(Student s) {
        gradeTable.removeAll();
        gradeBookNumberLabel.setText("");
        nameLabel.setText("");

        if (s == null) {
            return;
        }

        for (Mark m : s.getGradeBook().getMarks()) {
            TableItem tItem = new TableItem(gradeTable, SWT.LEFT);
            tItem.setText(new String[]{m.subject().toString(), Integer.toString(m.mark())});
        }

        nameLabel.setText(s.getName() + "   ");
        nameLabel.pack();
        gradeBookNumberLabel.setText(Integer.toString(s.getGradeBook().getGradeBookNumber()) + "   ");
        gradeBookNumberLabel.pack();
    }
}
