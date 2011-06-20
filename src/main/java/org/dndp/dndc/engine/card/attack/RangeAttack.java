package org.dndp.dndc.engine.card.attack;

import org.dndp.dndc.engine.card.abilities.AbilityType;

/**
 * Klasa obsługująca ataki dystansowe
 * 
 * @author bambucha
 */
public class RangeAttack extends BaseAttack
{

    /**
     * Standardowy konstruktor z postacią
     */
    public RangeAttack()
    {
        super();
    }

    @Override
    public AbilityType getAbilityName()
    {
        return AbilityType.DEXTERITY;
    }
}
