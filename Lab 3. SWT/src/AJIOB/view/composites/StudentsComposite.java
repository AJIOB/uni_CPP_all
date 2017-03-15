package AJIOB.view.composites;

import AJIOB.exceptions.NoInitException;
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
    public StudentsComposite(Composite parent, int style) {
        super(parent, style);

        init();
    }

    /**
     * Add all basic functional
     */
    private void init() {
        //TODO
        RowLayout layout = new RowLayout();
        layout.type = SWT.VERTICAL;
        layout.spacing = 10;
        layout.fill = true;
        setLayout(layout);

        Label label = new Label(this, SWT.LEFT);
        label.setText("Students");

        Table table = makeTable(this);

        Button btn = new Button(this, SWT.CENTER | SWT.PUSH);
        btn.setText("Add new one");
        btn.setLayoutData(new RowData(60, 30));
        btn.addListener(SWT.Selection, event -> {
            Person newPerson = AddPersonShell.run();

            try {
                MainShell.getUniversity().enrollStudent(newPerson);
            } catch (NoInitException e) {
                e.printStackTrace();
                return;
            }

            //todo: update Table
        });
    }

    private Table makeTable(Composite parent) {
        final int sizeOfColumn = 120;

        Table table = new Table(parent, SWT.SINGLE | SWT.BORDER | SWT.FULL_SELECTION);
        table.setLayout(new FillLayout());

        table.addListener(SWT.Selection, event ->  {
            //todo: show grade book
        });

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
        } catch (NoInitException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {

        }
        return table;
    }

    private void ReloadTable() {
        //TODO. add TableWiever
    }
}
