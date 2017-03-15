package AJIOB;

import AJIOB.view.MainShell;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

/**
 * Created by AJIOB on 07.03.2017.
 */
public class Main {
    public static void main(String[] args) {
        Display display = new Display();
        Shell shell = MainShell.getNewShell(display);
        shell.pack();
        shell.open();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) display.sleep();
        }
        display.dispose();
    }
}
