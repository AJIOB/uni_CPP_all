package AJIOB;

import AJIOB.model.uni.University;
import AJIOB.view.MainShell;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.*;

/**
 * Created by AJIOB on 07.03.2017.
 */
public class Main {
    public static void main(String[] args) {
        Display display = new Display();
        Shell shell = MainShell.get(display);
        shell.open();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) display.sleep();
        }
        display.dispose();
    }
}
