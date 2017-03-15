package AJIOB.view.make;

import AJIOB.model.uni.people.Person;
import AJIOB.view.MainShell;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.*;

/**
 * Created by AJIOB on 15.03.2017.
 *
 * @author AJIOB
 */
public class AddPersonShell {
    private static Person person;

    public static Person run() {
        person = null;

        Shell shell = new Shell(MainShell.getShell(), SWT.APPLICATION_MODAL | SWT.DIALOG_TRIM);
        shell.setText("Add person dialog");
        shell.setSize(250, 250);

        init(shell);

        shell.pack();
        shell.open();

        while (!shell.isDisposed()) {
            if (!MainShell.getDisplay().readAndDispatch())
                MainShell.getDisplay().sleep();
        }

        shell.dispose();

        return person;
    }

    /**
     * Initialise basic shell components
     *
     * @param sh Parent shell
     */
    private static void init(Shell sh) {
        RowLayout layout = new RowLayout();
        layout.type = SWT.VERTICAL;
        layout.spacing = 5;
        layout.marginWidth = 10;
        layout.marginHeight = 10;
        sh.setLayout(layout);

        Label HeaderLabel = new Label(sh, SWT.CENTER);
        HeaderLabel.setText("Person info:");

        Composite gridComposite = new Composite(sh, SWT.FILL);
        GridLayout gLayout = new GridLayout();
        gLayout.numColumns = 2;
        gridComposite.setLayout(gLayout);

        Label nameLabel = new Label(gridComposite, SWT.FILL);
        nameLabel.setText("Name:");

        Text nameText = new Text(gridComposite, SWT.FILL);

        Composite downComposite = new Composite(sh, SWT.FILL);
        RowLayout rlayout = new RowLayout();
        rlayout.center = true;
        downComposite.setLayout(rlayout);

        Button okBtn = new Button(downComposite, SWT.CENTER);
        okBtn.setText("OK");
        okBtn.addListener(SWT.Selection, event -> {
            person = new Person(nameText.getText());
            sh.close();
        });

        Button cancelBtn = new Button(downComposite, SWT.CENTER);
        cancelBtn.setText("Cancel");
        cancelBtn.addListener(SWT.Selection, event -> {
            sh.close();
        });
    }
}
