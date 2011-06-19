package org.dndp.dndc.client.gui.card.fleats;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;

public class FleatsView extends Group
{

    /**
     * Create the composite.
     * @param parent
     * @param style
     */
    public FleatsView(Composite parent, int style)
    {
        super(parent, style);
        setText("Atuty");

    }

    @Override
    protected void checkSubclass()
    {
        // Disable the check that prevents subclassing of SWT components
    }

}
