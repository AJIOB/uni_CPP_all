package AJIOB.view;

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
 * Created by AJIOB on 08.03.2017.
 */
public class MainShell extends Shell {
    private University uni;

    public MainShell(Display display) {
        super(display);

        uni = new University("BSUIR", 200, 300);

        init();
    }

    /**
     * Base init of shell view
     */
    private void init() {
        setSize(500, 400);
        setLayout(new FillLayout());

        setText("University: " + uni.getName() + ". Square: " + uni.getSquare());

        //making main tab folder
        TabFolder tabFolder = new TabFolder(this, SWT.TOP);
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
    private TabItem makeTabItem(TabFolder parent, final String text, MakeControl control) {
        TabItem mainTabItem = new TabItem(parent, SWT.NONE);
        mainTabItem.setText(text);
        mainTabItem.setControl(control.make(parent));

        return mainTabItem;
    }
}
