package AJIOB.view.composites;

import AJIOB.view.interfaces.MakeControl;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

/**
 * Created by AJIOB on 08.03.2017.
 */
public class StudentsComposite extends Composite implements MakeControl {
    public StudentsComposite(Composite parent, int style) {
        super(parent, style);

        //todo
    }

    @Override
    public Control make(Composite parent) {
        return new StudentsComposite(parent, SWT.FILL);
    }
}
