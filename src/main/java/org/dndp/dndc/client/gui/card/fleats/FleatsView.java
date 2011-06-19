package org.dndp.dndc.client.gui.card.fleats;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.List;
import org.eclipse.jface.viewers.ListViewer;

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
        setLayout(new FillLayout(SWT.HORIZONTAL));
        
        ListViewer listViewer = new ListViewer(this, SWT.BORDER | SWT.V_SCROLL);
        List fleetListView = listViewer.getList();

    }

    @Override
    protected void checkSubclass()
    {
        // Disable the check that prevents subclassing of SWT components
    }
}
