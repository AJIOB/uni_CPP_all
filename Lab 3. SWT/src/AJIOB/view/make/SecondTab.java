package AJIOB.view.make;

import AJIOB.view.composites.ExamsComposite;
import AJIOB.view.interfaces.MakeControl;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

/**
 * Created by AJIOB on 08.03.2017.
 */
public class SecondTab implements MakeControl {
    @Override
    public Control make(Composite parent) {
        return new ExamsComposite(parent, SWT.FILL);
    }
}