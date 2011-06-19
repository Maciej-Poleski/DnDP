package org.dndp.dndc.client.gui.card.fleats;

import org.dndp.dndc.engine.card.fleats.CharacterFleat;
import org.eclipse.jface.viewers.LabelProvider;

public class FleatLabelProvider extends LabelProvider
{

    @Override
    public String getText(Object element)
    {
        return ((CharacterFleat)element).getFleat().getName();
    }

}
