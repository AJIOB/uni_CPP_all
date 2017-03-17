package AJIOB.view.make;

import AJIOB.model.uni.people.Educator;
import AJIOB.view.MainShell;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.*;

import java.util.ArrayList;

/**
 * Created by AJIOB on 17.03.2017.
 *
 * @author AJIOB
 */
public class AddFewEducatorsShell {
    private static boolean isOKPressed = false;
    private static ArrayList<Educator> educators = new ArrayList<>();

    public static ArrayList<Educator> run() {
        isOKPressed = false;
        educators = new ArrayList<>();

        Shell shell = new Shell(MainShell.getShell(), SWT.APPLICATION_MODAL | SWT.DIALOG_TRIM);
        shell.setText("Add Head of Department dialog");
        shell.setSize(250, 250);

        init(shell);

        shell.pack();
        shell.open();

        while (!shell.isDisposed()) {
            if (!MainShell.getDisplay().readAndDispatch())
                MainShell.getDisplay().sleep();
        }

        shell.dispose();

        return (isOKPressed && educators != null && educators.size() != 0) ? educators : null;
    }

    /**
     * Initialise basic shell components
     *
     * @param sh Parent shell
     */
    private static void init(Shell sh) {
        sh.setLayout(new FillLayout());

        Group g = new Group(sh, SWT.FILL);
        g.setText("Educators:");

        RowLayout layout = new RowLayout();
        layout.type = SWT.VERTICAL;
        layout.spacing = 5;
        layout.marginWidth = 10;
        layout.marginHeight = 10;
        g.setLayout(layout);

        Table t = makeTable(g);

        Composite downComposite = new Composite(g, SWT.FILL);
        RowLayout rlayout = new RowLayout();
        rlayout.center = true;
        downComposite.setLayout(rlayout);

        Button addBtn = new Button(downComposite, SWT.CENTER);
        addBtn.setText("Add");
        addBtn.addListener(SWT.Selection, event -> {
            Educator e = AddEducatorClassShell.run();
            if (e == null) {
                return;
            }

            educators.add(e);
            addRowToTable(t, e);
        });

        Button okBtn = new Button(downComposite, SWT.CENTER);
        okBtn.setText("OK");
        okBtn.addListener(SWT.Selection, event -> {
            isOKPressed = true;
            sh.close();
        });

        Button cancelBtn = new Button(downComposite, SWT.CENTER);
        cancelBtn.setText("Cancel");
        cancelBtn.addListener(SWT.Selection, event -> {
            sh.close();
        });
    }

    /**
     * Make table with base info to show
     *
     * @param parent Parent composite
     * @return Table that was made
     */
    private static Table makeTable(Composite parent) {
        Table t = new Table(parent, SWT.BORDER | SWT.SINGLE);

        TableColumn tableColumn = new TableColumn(t, SWT.NONE);
        tableColumn.setWidth(100);
        tableColumn.setText("Educator preview info");

        return t;
    }

    /**
     * Add one row to table t, made from Subject s
     *
     * @param t Table, which will be as parent
     * @param e Donor of info to row
     */
    private static void addRowToTable(Table t, Educator e) {
        if (e == null) {
            return;
        }

        TableItem tableItem = new TableItem(t, SWT.NONE);
        tableItem.setText(e.getName());
    }
}
