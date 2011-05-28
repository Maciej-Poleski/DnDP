package org.dndp.dndc.engine.card.bonus;

import java.util.EnumMap;

import org.dndp.dndc.engine.card.abilities.Abilities;


/**
 * Zajmuje się całym pakietem wszytkich premi dla jednego atrybutu, umiejętności.
 * 
 * @author bambucha
 */
public class BaseBonusHandler
{
    private Bonusable                   cared;
    private Abilities                   abilities;
    protected EnumMap<BonusType, Bonus> bonusTypePool = new EnumMap<BonusType, Bonus>(BonusType.class);

    /**
     * 
     * @param cared
     * @param abilities
     */
    public BaseBonusHandler(Bonusable cared, Abilities abilities)
    {
        this.abilities = abilities;
        this.cared = cared;
        bonusTypePool.put(BonusType.Alchemical, new MaximizedBonus());
        bonusTypePool.put(BonusType.Circumstance, new AdductBonus());
        bonusTypePool.put(BonusType.Competence, new MaximizedBonus());
        bonusTypePool.put(BonusType.Enhancement, new AdductBonus());
        bonusTypePool.put(BonusType.Insight, new MaximizedBonus());
        bonusTypePool.put(BonusType.Luck, new MaximizedBonus());
        bonusTypePool.put(BonusType.Morale, new MaximizedBonus());
        bonusTypePool.put(BonusType.Profane, new MaximizedBonus());
        bonusTypePool.put(BonusType.Racial, new AdductBonus());
        bonusTypePool.put(BonusType.Resistance, new MaximizedBonus());
        bonusTypePool.put(BonusType.Sacred, new MaximizedBonus());
    }

    /**
     * Zlicza wartość wszystkich bonusów.
     * 
     * @return
     */
    protected Integer countBonus()
    {
        int temp = 0;
        for (Bonus t : bonusTypePool.values())
            temp += t.getBonus();
        if(cared.getAbilityName().getAbiliti(abilities) != null)
            return temp + cared.getAbilityName().getAbiliti(abilities).getModifier();
        return temp;
    }

    /**
     * Dodaje bonus do pola i aktualizuje warość bonusu w polu.
     * 
     * @param bonusType
     *            Typ premmi
     * @param bonus
     *            Wartosć premi
     */
    public void addBonus(BonusType bonusType, Integer bonus)
    {
        Bonus temp = bonusTypePool.get(bonusType);
        if(bonus == null)
            throw new IllegalArgumentException("To pole nie ma takiej premi");
        temp.addBonus(bonus);
        cared.setBonus(countBonus());
    }

    /**
     * Usuwa premię z pola i katualizuje bonus.
     * 
     * @param bonusType
     *            Typ premii
     * @param bonus
     *            Wartość premii
     */
    public void removeBonus(BonusType bonusType, Integer bonus)
    {
        Bonus temp = bonusTypePool.get(bonusType);
        if(bonus == null)
            throw new IllegalArgumentException("To pole nie ma takiej premi");
        temp.removeBonus(bonus);
        cared.setBonus(countBonus());
    }
}
