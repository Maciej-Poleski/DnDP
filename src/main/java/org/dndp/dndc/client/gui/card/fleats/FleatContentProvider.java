package org.dndp.dndc.client.gui.card.fleats;

import java.util.Collection;

import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.Viewer;

public class FleatContentProvider implements IStructuredContentProvider
{

    @Override
    public void dispose()
    {    }

    @Override
    public void inputChanged(Viewer arg0, Object arg1, Object arg2)
    {    }

    @Override
    public Object[] getElements(Object arg0)
    {
        return ((Collection<?>)arg0).toArray();
    }

}
