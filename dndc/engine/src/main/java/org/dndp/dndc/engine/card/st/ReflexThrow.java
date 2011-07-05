package org.dndp.dndc.engine.card.st;

import org.dndp.dndc.engine.card.abilities.AbilityType;

/**
 * Klasa rzutu obronego na refleks
 * 
 * @author bambucha
 */
public class ReflexThrow extends SavingThrow
{

    /**
     * Standardowy konstruktor
     * 
     * @param who
     *            Właściciel rzutu
     * @param view
     *            Widok rzutu
     */
    public ReflexThrow()
    {
        super();
    }

    @Override
    public AbilityType getAbilityName()
    {
        return AbilityType.DEXTERITY;
    }

}
