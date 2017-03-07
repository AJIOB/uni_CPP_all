package AJIOB;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

/**
 * Created by AJIOB on 07.03.2017.
 */
public class Main {
    public static Shell makeShell(Display display) {
        Shell shell = new Shell(display);

        Label label = new Label(shell, SWT.NONE);
        shell.setSize(300,200);
        label.setText("Hello World");
        label.pack();
        //todo

        return shell;
    }

    public static void main (String[] args) {
        Display display = new Display();
        Shell shell = makeShell(display);
        shell.open();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch ()) display.sleep ();
        }
        display.dispose ();
    }
}
