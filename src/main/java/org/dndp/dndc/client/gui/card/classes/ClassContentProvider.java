package org.dndp.dndc.client.gui.card.classes;

import java.util.List;

import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.Viewer;

public class ClassContentProvider implements IStructuredContentProvider
{

    @Override
    public void dispose()
    {    }
    
    @Override
    public Object[] getElements(Object arg0)
    {
        return ((List<?>)arg0).toArray();
    }

    @Override
    public void inputChanged(Viewer arg0, Object arg1, Object arg2)
    {    }

}