package org.dndp.dndc.client.gui.card.skills;

import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;

/**
 * Przygotowuje labele do tabeli z umiejętnościami.
 * 
 * @parm FIXME implementacja
 * @author bambucha
 */
public class SklilLabelProvider extends LabelProvider implements
        ITableLabelProvider
{

    @Override
    public Image getColumnImage(Object arg0, int arg1)
    {
        return null;
    }

    @Override
    public String getColumnText(Object arg0, int arg1)
    {
        throw new UnsupportedOperationException();
    }

}
