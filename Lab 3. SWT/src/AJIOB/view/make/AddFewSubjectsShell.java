package AJIOB.view.make;

import AJIOB.model.uni.teaching.Subject;
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
public class AddFewSubjectsShell {
    private static boolean isOKPressed = false;
    private static ArrayList<Subject> subjects = new ArrayList<>();

    public static ArrayList<Subject> run() {
        isOKPressed = false;
        subjects = new ArrayList<>();

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

        return (isOKPressed && subjects != null && subjects.size() != 0) ? subjects : null;
    }

    /**
     * Initialise basic shell components
     *
     * @param sh Parent shell
     */
    private static void init(Shell sh) {
        sh.setLayout(new FillLayout());

        Group g = new Group(sh, SWT.FILL);
        g.setText("Subjects:");

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
            Subject s = AddSubjectClassShell.run();
            if (s == null) {
                return;
            }

            subjects.add(s);
            addRowToTable(t, s);
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
        tableColumn.setText("Subject preview info");

        return t;
    }

    /**
     * Add one row to table t, made from Subject s
     *
     * @param t Table, which will be as parent
     * @param s Donor of info to row
     */
    private static void addRowToTable(Table t, Subject s) {
        if (s == null) {
            return;
        }

        TableItem tableItem = new TableItem(t, SWT.NONE);
        tableItem.setText(s.toString());
    }
}
