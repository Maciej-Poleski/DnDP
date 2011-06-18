package org.dndp.dndc.client.gui.card.classes;

import org.dndp.dndc.engine.card.classes.CharacterClass;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;


public class ClassLabelProvider extends LabelProvider
{

    @Override
    public Image getImage(Object element)
    {
        return null;
    }

    @Override
    public String getText(Object element)
    {
        return ((CharacterClass)element).getClasses().getName();
    }
    
}
