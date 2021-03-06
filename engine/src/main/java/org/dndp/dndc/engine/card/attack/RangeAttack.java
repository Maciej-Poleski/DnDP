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
     * 
     * @param attack
     */
    public RangeAttack(Attack attack)
    {
        super(attack);
    }

    @Override
    public AbilityType getAbilityName()
    {
        return AbilityType.DEXTERITY;
    }
}
