package org.dndp.dndc.client.gui.card.fleats;

import java.util.Observable;
import java.util.Observer;

import org.dndp.dndc.client.gui.card.CollectionContentProvider;
import org.dndp.dndc.engine.card.fleats.CharacterFleatManager;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;

public class FleatsView extends Group implements Observer
{
    private ListViewer listViewer;

    /**
     * Create the composite.
     * 
     * @param parent
     * @param style
     */
    public FleatsView(Composite parent, int style)
    {
        super(parent, style);
        setText("Atuty");
        setLayout(new FillLayout(SWT.HORIZONTAL));

        listViewer = new ListViewer(this, SWT.BORDER | SWT.V_SCROLL);
        listViewer.setContentProvider(new CollectionContentProvider());
        listViewer.setLabelProvider(new FleatLabelProvider());

    }

    @Override
    protected void checkSubclass()
    {
        // Disable the check that prevents subclassing of SWT components
    }

    @Override
    public void update(Observable o, Object arg)
    {
        if(o instanceof CharacterFleatManager)
        {
            listViewer.setInput(((CharacterFleatManager)o)
                    .getAllCharacterFleats());
        }
    }
}
