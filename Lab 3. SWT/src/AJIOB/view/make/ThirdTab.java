package AJIOB.view.make;

import AJIOB.view.composites.StudentsComposite;
import AJIOB.view.interfaces.MakeControl;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

/**
 * Created by AJIOB on 08.03.2017.
 */
public class ThirdTab implements MakeControl {
    @Override
    public Control make(Composite parent) {
        return new StudentsComposite(parent, SWT.FILL);
    }
}
