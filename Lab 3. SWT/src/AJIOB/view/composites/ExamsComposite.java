package AJIOB.view.composites;

import AJIOB.exceptions.NoInitException;
import AJIOB.model.uni.teaching.Exam;
import AJIOB.view.MainShell;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.*;

/**
 * Created by AJIOB on 08.03.2017.
 */
public class ExamsComposite extends Composite {
    private int selectedTableRow = -1;

    public ExamsComposite(Composite parent, int style) {
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
        label.setText("Exams");

        Table table = makeTable(this);

        Button btn = new Button(this, SWT.CENTER | SWT.PUSH);
        btn.setText("Pass");
        btn.setLayoutData(new RowData(60, 30));
        btn.addListener(SWT.Selection, event -> {
            if (selectedTableRow < 0) {
                return;
            }

            try {
                MainShell.getUniversity().getExams().get(selectedTableRow).startExam();
            } catch (NoInitException e) {

            }
        });
    }

    private Table makeTable(Composite parent) {
        final int sizeOfColumn = 100;

        Table table = new Table(parent, SWT.SINGLE | SWT.BORDER | SWT.FULL_SELECTION);
        table.setLayout(new FillLayout());

        table.addListener(SWT.Selection, new Listener() {
            public void handleEvent(Event event) {
                TableItem item = (TableItem) event.item;
                selectedTableRow = table.indexOf(item);
            }
        });

        TableColumn subject = new TableColumn(table, SWT.LEFT);
        subject.setText("Subject");
        subject.setWidth(sizeOfColumn);

        TableColumn educator = new TableColumn(table, SWT.LEFT);
        educator.setText("Educator");
        educator.setWidth(sizeOfColumn);

        table.setHeaderVisible(true);

        try {
            for (Exam exam : MainShell.getUniversity().getExams()) {
                TableItem tItem = new TableItem(table, SWT.LEFT);
                tItem.setText(new String[]{exam.getSubject().getName(), exam.getEducator().getName()});
            }

            //add listeners
            MainShell.getUniversity().addExamListener(new AJIOB.model.listeners.Listener<Exam>() {
                @Override
                public void SthIsChanged(int changedIndex, Exam exam) {
                    table.getItem(changedIndex).setText(
                            new String[]{exam.getSubject().getName(), exam.getEducator().getName()}
                    );
                }

                @Override
                public void SthIsAdd(int newElemIndex, Exam e) {
                    TableItem tItem = new TableItem(table, SWT.LEFT, newElemIndex);
                    tItem.setText(new String[]{e.getSubject().getName(), e.getEducator().getName()});
                }

                @Override
                public void SthIsRemoved(int oldElemIndex, Exam e) {
                    table.remove(oldElemIndex);
                }
            });
        } catch (NoInitException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {

        }
        return table;
    }
}
