package org.dndp.dndc.client.gui.card.skills;

import org.dndp.dndc.engine.card.skills.CharacterSkill;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;

/**
 * Przygotowuje labele do tabeli z umiejętnościami.
 * 
 * @author bambucha, evil
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
        CharacterSkill skillToDispatch=(CharacterSkill)arg0;
        switch(arg1)
        {
        case 0:
            return skillToDispatch.getSkil().getName();
        case 1:
            return Integer.toString(skillToDispatch.getBonus()+skillToDispatch.getRank());
        case 2:
            return skillToDispatch.getRank().toString();
        case 3:
            return skillToDispatch.getSkil().getAbilitiModifier().toString();
        case 4:
            return skillToDispatch.getBonus().toString();
        default:
            return "Nie potrafie podać rządanych danych!";
        }
    }

}
