package org.dndp.dndc.engine.benefit;

import org.dndp.dndc.engine.Character;
import org.dndp.dndc.engine.card.bonus.BonusType;

/**
 * 
 * Klasa kapsułkująca premię będącą bonusem do jakiegoś pola.
 * @author bambucha
 */
public class BonusBenefit implements Benefit
{
    private String    targetName;
    private BonusType bonusType;
    private Integer   bonusValue;

    /**
     * @param targetName
     *            Nazwa pola do którego odwołuje się bonus.
     * @param bonusType
     *            Typ bonusu.
     * @param bonusValue
     *            Wartość bonusu.
     */
    public BonusBenefit(String targetName, BonusType bonusType, Integer bonusValue)
    {
        this.targetName = targetName;
        this.bonusType = bonusType;
        this.bonusValue = bonusValue;
    }

    /*
     * (non-Javadoc)
     * @see engine.benefit.Benefit#apply(engine.Character)
     */
    @Override
    public void apply(Character benefitTarget)
    {
        benefitTarget.getBonusHandler(targetName).addBonus(bonusType, bonusValue);
    }

    /*
     * (non-Javadoc)
     * @see engine.benefit.Benefit#abandon(engine.Character)
     */
    @Override
    public void abandon(Character benefitTarget)
    {
        benefitTarget.getBonusHandler(targetName).removeBonus(bonusType, bonusValue);
    }

}
