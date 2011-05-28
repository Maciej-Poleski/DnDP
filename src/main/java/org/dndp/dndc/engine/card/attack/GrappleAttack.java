package org.dndp.dndc.engine.card.attack;

import java.util.Arrays;

import org.dndp.dndc.engine.card.abilities.AbilityType;
import org.dndp.dndc.engine.Character;


/**
 * Implementacja licząca premie do walk w zwarciu
 * 
 * @author bambucha
 */
public class GrappleAttack extends BaseAttack
{

    /**
     * Strandardowy konstruktor z użyciem postaci
     * 
     * @param main
     */
    public GrappleAttack(Character main)
    {
        super(main);
    }

    /**
     * Metodal licząca premie(nie bazową) do ataków w zwarciu. Uwzględnia
     * rozmiar i modyfikator z siły
     */
    @Override
    protected void countAttacksModifier()
    {
        atackModifier = main.getStrenght().getModifier();
        atackModifier = main.getSize().getGrappleAttacksModifier();
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
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
