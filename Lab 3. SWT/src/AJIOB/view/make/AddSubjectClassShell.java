package AJIOB.view.make;

import AJIOB.model.uni.teaching.Subject;
import AJIOB.view.MainShell;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.*;

/**
 * Created by AJIOB on 17.03.2017.
 *
 * @author AJIOB
 */
public class AddSubjectClassShell {
    private static Subject subject;

    public static Subject run() {
        subject = null;

        Shell shell = new Shell(MainShell.getShell(), SWT.APPLICATION_MODAL | SWT.DIALOG_TRIM);
        shell.setText("Add subject dialog");
        shell.setSize(250, 250);

        init(shell);

        shell.pack();
        shell.open();

        while (!shell.isDisposed()) {
            if (!MainShell.getDisplay().readAndDispatch())
                MainShell.getDisplay().sleep();
        }

        shell.dispose();

        return subject;
    }

    /**
     * Initialise basic shell components
     *
     * @param sh Parent shell
     */
    private static void init(Shell sh) {
        sh.setLayout(new FillLayout());

        Group g = new Group(sh, SWT.FILL);
        g.setText("Subject info:");

        RowLayout layout = new RowLayout();
        layout.type = SWT.VERTICAL;
        layout.spacing = 5;
        layout.marginWidth = 10;
        layout.marginHeight = 10;
        g.setLayout(layout);

        Composite gridComposite = new Composite(g, SWT.FILL);
        GridLayout gLayout = new GridLayout();
        gLayout.numColumns = 2;
        gridComposite.setLayout(gLayout);

        Label nameLabel = new Label(gridComposite, SWT.FILL);
        nameLabel.setText("Name:");

        Text nameText = new Text(gridComposite, SWT.FILL);

        Composite downComposite = new Composite(g, SWT.FILL);
        RowLayout rlayout = new RowLayout();
        rlayout.center = true;
        downComposite.setLayout(rlayout);

        Button okBtn = new Button(downComposite, SWT.CENTER);
        okBtn.setText("OK");
        okBtn.addListener(SWT.Selection, event -> {
            if (nameText.getText() != "") {
                subject = new Subject(nameText.getText());
            }

            sh.close();
        });

        Button cancelBtn = new Button(downComposite, SWT.CENTER);
        cancelBtn.setText("Cancel");
        cancelBtn.addListener(SWT.Selection, event -> {
            sh.close();
        });
    }
}