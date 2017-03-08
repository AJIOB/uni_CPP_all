package AJIOB.view.make;

import AJIOB.view.composites.HeadsOfDepartmentComposite;
import AJIOB.view.interfaces.MakeControl;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

/**
 * Created by AJIOB on 08.03.2017.
 */
public class FirstTab implements MakeControl {
    @Override
    public Control make(Composite parent) {
        return new HeadsOfDepartmentComposite(parent, SWT.FILL);
    }
}
