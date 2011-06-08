package org.dndp.dndc.engine.card.attack;

import org.dndp.dndc.engine.card.abilities.AbilityType;
import org.dndp.dndc.engine.card.bonus.Bonusable;

/**
 * Klasa kapsułkująca bazową premię do ataku
 * 
 * @author bambucha
 */
public class BaseBonusToAttack
{
    private int[] bonus = new int[4];

    /**
     * Standardowy konstruktor, tworzy z tablicy obiekt
     * 
     * @param bonus
     */
    public BaseBonusToAttack(int[] bonus)
    {
        if(bonus.length > 4)
            throw new IllegalArgumentException("Tylko cztery ataki");
        for(Integer t : bonus)
            if(t < 0)
                throw new IllegalArgumentException("Bazowa premia nie mozę być ujemna");
        this.bonus = bonus;
    }

    public Integer getNumberOfAttacks()
    {
        return bonus.length;
    }

    public int[] getBonus()
    {
        return bonus;
    }

    public void setBonus(int[] bonus)
    {
        if(bonus.length > 4)
            throw new IllegalArgumentException("Tylko cztery ataki");
        for(Integer t : bonus)
            if(t < 0)
                throw new IllegalArgumentException("Bazowa premia nie może być ujemna");
        this.bonus = bonus;
    }
}
