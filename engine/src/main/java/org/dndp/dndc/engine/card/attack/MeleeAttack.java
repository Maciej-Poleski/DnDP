package org.dndp.dndc.engine.card.attack;

import org.dndp.dndc.engine.card.abilities.AbilityType;

/**
 * Klasa obsługująca atak wręcz
 * 
 * @author bambucha
 */
public class MeleeAttack extends BaseAttack
{

    public MeleeAttack(Attack a)
    {
        super(a);
    }

    @Override
    public AbilityType getAbilityName()
    {
        return AbilityType.STRENGHT;
    }

}
