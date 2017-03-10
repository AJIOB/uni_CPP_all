package AJIOB.view.composites;

import AJIOB.exceptions.NoInitException;
import AJIOB.model.uni.teaching.Exam;
import AJIOB.view.MainShell;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

/**
 * Created by AJIOB on 08.03.2017.
 */
public class ExamsComposite extends Composite {
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

        setLayout(new FillLayout());

        Table table = makeTable(this);

    }

    private Table makeTable(Composite parent) {
        final int sizeOfColumn = 100;
        //TODO: bad secection of row
        Table table = new Table(parent, SWT.VIRTUAL | SWT.BORDER);
/*
        table.addListener(SWT.SetData, new Listener() {
            public void handleEvent(Event event) {
                TableItem item = (TableItem) event.item;
                int index = table.indexOf(item);
                item.setText("Item " + index);
                System.out.println(item.getText());
            }
        });*/

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
                tItem.setText(new String[] {exam.getSubject().getName(), exam.getEducator().getName()});
            }
        } catch (NoInitException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {

        }
        return table;
    }
}
