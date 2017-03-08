package AJIOB.view;

import AJIOB.exceptions.NoInitException;
import AJIOB.model.uni.University;
import AJIOB.view.interfaces.MakeControl;
import AJIOB.view.make.*;
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
public class MainShell extends Shell {
    private static University uni;
    private static Shell shell;
    private static boolean isRuningYet = false;

    public static Shell get(Display display) {
        if (isRuningYet) {
            return shell;
        }

        shell = new Shell(display);

        uni = new University("BSUIR", 200, 300);

        isRuningYet = true;

        init();

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
        makeTabItem(tabFolder, "Heads of department", new FirstTab());
        makeTabItem(tabFolder, "Exams", new SecondTab());
        makeTabItem(tabFolder, "Students", new ThirdTab());

    }

    /**
     * Fast help to make SWT TabItem for SWT TabFolder object
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
     * @throws NoInitException If you run this method before get() method
     */
    public static University getUniversity() throws NoInitException {
        if (!isRuningYet) {
            throw new NoInitException();
        }

        return uni;
    }
}
