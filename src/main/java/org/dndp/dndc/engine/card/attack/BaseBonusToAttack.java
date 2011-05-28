package org.dndp.dndc.engine.card.attack;

/**
 * Klasa kapsułkująca bazową premię do ataku
 * 
 * @author bambucha
 */
public class BaseBonusToAttack
{
    private Integer[] bonus = new Integer[4];

    /**
     * Standardowy konstruktor, tworzy z tablicy obiekt
     * 
     * @param bonus
     */
    public BaseBonusToAttack(Integer[] bonus)
    {
        if (bonus.length > 4)
            throw new IllegalArgumentException("Tylko cztery ataki");
        for (Integer t : bonus)
            if (t < 0)
                throw new IllegalArgumentException(
                        "Bazowa premia nie mozę być ujemna");
        this.bonus = bonus;
    }

    public Integer getNumberOfAttacks()
    {
        return bonus.length;
    }

    public Integer[] getBonus()
    {
        return bonus;
    }

    public void setBonus(Integer[] bonus)
    {
        if (bonus.length > 4)
            throw new IllegalArgumentException("Tylko cztery ataki");
        for (Integer t : bonus)
            if (t < 0)
                throw new IllegalArgumentException(
                        "Bazowa premia nie może być ujemna");
        this.bonus = bonus;
    }
}
