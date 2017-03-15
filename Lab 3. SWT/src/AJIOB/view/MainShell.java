package AJIOB.view;

import AJIOB.exceptions.NoInitException;
import AJIOB.model.uni.University;
import AJIOB.view.interfaces.MakeControl;
import AJIOB.view.make.FirstTab;
import AJIOB.view.make.SecondTab;
import AJIOB.view.make.ThirdTab;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;

/**
 * Must by run only one time
 * <p>
 * Created by AJIOB on 08.03.2017.
 *
 * @author AJIOB
 */
public class MainShell /*extends Shell*/ {
    private static Display display;
    private static University uni;
    private static Shell shell = null;

    /**
     * Make new ma
     *
     * @param display Parent display
     * @return Shell that was made
     */
    public static Shell getNewShell(Display display) {
        if (MainShell.shell != null) {
            return shell;
        }

        MainShell.display = display;

        shell = new Shell(display);

        uni = new University("BSUIR", 200, 300);

        init();

        return shell;
    }

    public static Shell getShell() {
        return shell;
    }


    /**
     * Base init of shell view
     */
    private static void init() {
        shell.setSize(500, 400);
        shell.setLayout(new FillLayout());

        shell.setText("University: " + uni.getName() + ". Square: " + uni.getSquare());

        //making main tab folder
        TabFolder tabFolder = new TabFolder(shell, SWT.TOP);
        makeTabItem(tabFolder, "Heads of departments", new FirstTab());
        makeTabItem(tabFolder, "Exams", new SecondTab());
        makeTabItem(tabFolder, "Students", new ThirdTab());

    }

    /**
     * Fast help to run SWT TabItem for SWT TabFolder object
     *
     * @param parent  TabFolder parent object
     * @param text    Head of tab
     * @param control What you will see, when you choose this tab
     * @return TabItem that was made
     */
    private static TabItem makeTabItem(TabFolder parent, final String text, MakeControl control) {
        TabItem mainTabItem = new TabItem(parent, SWT.NONE);
        mainTabItem.setText(text);
        mainTabItem.setControl(control.make(parent));

        return mainTabItem;
    }

    /**
     * Returns University value
     *
     * @return University value that was set before
     * @throws NoInitException If you run this method before getNewShell() method
     */
    public static University getUniversity() throws NoInitException {
        if (shell == null) {
            throw new NoInitException();
        }

        return uni;
    }

    public static Display getDisplay() {
        return display;
    }
}
