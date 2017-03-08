package AJIOB.view.composites;

import AJIOB.exceptions.NoInitException;
import AJIOB.model.uni.teaching.Exam;
import AJIOB.view.MainShell;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
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

        setLayout(new FillLayout());

        Table table = new Table(this, SWT.VIRTUAL | SWT.BORDER);
/*
        table.addListener(SWT.SetData, new Listener() {
            public void handleEvent(Event event) {
                TableItem item = (TableItem) event.item;
                int index = table.indexOf(item);
                item.setText("Item " + index);
                System.out.println(item.getText());
            }
        });*/


        try {
            for (Exam exam : MainShell.getUniversity().getExams()) {
                TableItem tItem = new TableItem(table, SWT.LEFT);
                tItem.setText(exam.toString());
            }
        } catch (NoInitException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {

        }

    }
}
