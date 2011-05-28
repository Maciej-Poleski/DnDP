package org.dndp.dndc.engine.card.st;

import org.dndp.dndc.engine.card.abilities.AbilityType;

/**
 * Klasa rzutu obronego na Wolę.
 * 
 * @author bambucha
 */
public class WillThrow extends SavingThrow
{

    /**
     * Standardowy konstruktor
     * 
     * @see dndp.engine.card.st.SavingThrow
     * @param view
     *            Widok rzutu obronnego.
     */
    public WillThrow()
    {
        super();
    }

    @Override
    public AbilityType getAbilityName()
    {
        return AbilityType.WISDOM;
    }

}
