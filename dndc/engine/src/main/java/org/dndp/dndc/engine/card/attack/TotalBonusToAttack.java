package org.dndp.dndc.engine.card.attack;

/**
 * Klasa kapsułkująca informacje o całkowitym ataku postaci danego typu
 * Uwzględnia dwuręczność , chodz nie do końca.
 * 
 * @author bambucha
 */
public class TotalBonusToAttack
{
    private int[] mainHand;

    public TotalBonusToAttack(int[] temp)
    {
        if (temp.length > 4)
            throw new IllegalArgumentException("Za dużo ataków");
        this.mainHand = temp;
    }

    /**
     * Zwraca atak główną ręką.
     * @return
     */
    public int[] getMainHand()
    {
        return mainHand;
    }
}
