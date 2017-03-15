package AJIOB.view.composites;

import AJIOB.exceptions.NoInitException;
import AJIOB.model.uni.people.Worker;
import AJIOB.view.MainShell;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.*;

/**
 * Created by AJIOB on 08.03.2017.
 */
public class HeadsOfDepartmentsComposite extends Composite {
    public HeadsOfDepartmentsComposite(Composite parent, int style) {
        super(parent, style);

        init();
    }

    private void init() {
        RowLayout rLayoutForMain = new RowLayout();
        rLayoutForMain.type = SWT.HORIZONTAL;
        rLayoutForMain.marginWidth = 5;
        rLayoutForMain.spacing = 5;
        rLayoutForMain.pack = false;

        setLayout(rLayoutForMain);

        Composite first = make1stColumn(this);
        //first.setLayout(new FillLayout());

    }

    /**
     * Generating first column as one composite. This column contains list of heads of departments
     *
     * @return Generated composite
     */
    private Composite make1stColumn(Composite parent) {
        RowLayout layout = new RowLayout();
        layout.type = SWT.VERTICAL;
        layout.spacing = 5;

        Composite res = new Composite(parent, SWT.NONE);
        res.setLayout(layout);

        Label headText = new Label(res, SWT.LEFT | SWT.HORIZONTAL);
        headText.setText("Heads of departments");

        Table mainTable = new Table(res, SWT.SINGLE | SWT.BORDER | SWT.FULL_SELECTION);

        TableColumn name = new TableColumn(mainTable, SWT.LEFT);
        name.setText("Name");
        name.setWidth(100);

        try {
            for (Worker w : MainShell.getUniversity().getWorkers()) {
                if (w.getJob() == "HeadOfDepartment") {
                    TableItem tItem = new TableItem(mainTable, SWT.NONE);
                    tItem.setText(new String[]{w.getName()});
                }
            }
        } catch (NoInitException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {

        }

        return res;
    }
}
