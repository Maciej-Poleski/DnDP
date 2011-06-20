package org.dndp.dndc.engine.card.attack;

import org.dndp.dndc.engine.card.abilities.AbilityType;

/**
 * Klasa obsługująca atak wręcz
 * 
 * @author bambucha
 */
public class MeleeAttack extends BaseAttack
{

    /**
     * Standardowy konstruktor z postacią
     */
    public MeleeAttack()
    {
        super();
    }

    @Override
    public AbilityType getAbilityName()
    {
        return AbilityType.STRENGHT;
    }

}
