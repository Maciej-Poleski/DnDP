package org.dndp.dndc.engine.card.attack;

/**
 * Klasa kapsułkująca informacje o całkowitym ataku postaci danego typu
 * Uwzględnia dwuręczność , chodz nie do końca.
 * 
 * @author bambucha
 */
public class TotalBonusToAttack
{
    private Integer[] mainHand;

    public TotalBonusToAttack(Integer[] main)
    {
        if (main.length > 4)
            throw new IllegalArgumentException("Za dużo ataków");
        this.mainHand = main;
    }

    public Integer[] getMainHand()
    {
        return mainHand;
    }
}
