package org.dndp.dndc.engine.card.attack;

import java.util.Arrays;

import org.dndp.dndc.engine.card.abilities.AbilityType;


/**
 * Implementacja licząca premie do walk w zwarciu
 * 
 * @author bambucha
 */
public class GrappleAttack extends BaseAttack
{

    /**
     * Strandardowy konstruktor z użyciem postaci
     */
    public GrappleAttack()
    {
        super();
    }

    @Override
    public TotalBonusToAttack getAttacks()
    {
        TotalBonusToAttack t = super.getAttacks();
        return new TotalBonusToAttack(Arrays.copyOfRange(t.getMainHand(), 0, 1));
    }

    @Override
    public AbilityType getAbilityName()
    {
        return AbilityType.STRENGHT;
    }
}
