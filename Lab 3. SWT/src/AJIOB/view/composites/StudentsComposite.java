package AJIOB.view.composites;

import AJIOB.exceptions.NoInitException;
import AJIOB.model.listeners.Listener;
import AJIOB.model.uni.people.Person;
import AJIOB.model.uni.people.Student;
import AJIOB.view.MainShell;
import AJIOB.view.make.AddPersonShell;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.*;

/**
 * Created by AJIOB on 08.03.2017.
 */
public class StudentsComposite extends Composite {
    private Table studTable = null;
    private Table gradeTable = null;

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

        studTable.addListener(SWT.Selection, event -> {
            //todo: show grade book
        });
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

        return table;
    }

    /**
     * Make composite with info about student's grade book
     *
     * @param parent
     * @return
     */
    private Composite makeGradeBookPart(Composite parent) {
        Composite c = new Composite(parent, SWT.FILL);

        //todo
        return c;
    }
}
