package org.dndp.dndc.engine.card.st;

import org.dndp.dndc.engine.card.abilities.AbilityType;

/**
 * Klasa rzutu na wytwałość
 * 
 * @author bambucha
 */
public class FortitudeThrow extends SavingThrow 
{

    /**
     * Standardowy kostruktor
     * 
     * @param who
     *            Postać
     * @param view
     *            Widok rzutu
     * @see dndp.engine.card.st.SavingThrow
     */
    public FortitudeThrow()
    {
        super();
    }

    @Override
    public AbilityType getAbilityName()
    {
        return AbilityType.STRENGHT;
    }
}
