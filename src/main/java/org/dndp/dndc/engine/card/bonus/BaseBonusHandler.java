package org.dndp.dndc.engine.card.bonus;

import java.util.EnumMap;

import org.dndp.dndc.engine.card.abilities.Abilities;
import org.dndp.dndc.engine.card.attack.GrappleAttack;
import org.dndp.dndc.engine.card.description.Description;

/**
 * Zajmuje się całym pakietem wszytkich premi dla jednego atrybutu,
 * umiejętności.
 * 
 * @author bambucha
 */
public class BaseBonusHandler
{
    private final Bonusable             cared;
    private final Abilities             abilities;
    private final Description           description;
    protected EnumMap<BonusType, Bonus> bonusTypePool = new EnumMap<BonusType, Bonus>(
                                                              BonusType.class);

    /**
     * 
     * @param cared
     * @param abilities
     */
    public BaseBonusHandler(Bonusable cared, Abilities abilities,
            Description description)
    {
        this.abilities = abilities;
        this.cared = cared;
        this.description = description;
        bonusTypePool.put(BonusType.ALCHEMICAL, new MaximizedBonus());
        bonusTypePool.put(BonusType.CIRCUMSTANCE, new AdductBonus());
        bonusTypePool.put(BonusType.COMPETENCE, new MaximizedBonus());
        bonusTypePool.put(BonusType.ENHANCEMENT, new AdductBonus());
        bonusTypePool.put(BonusType.INSIGHT, new MaximizedBonus());
        bonusTypePool.put(BonusType.LUCK, new MaximizedBonus());
        bonusTypePool.put(BonusType.MORALE, new MaximizedBonus());
        bonusTypePool.put(BonusType.PROFANE, new MaximizedBonus());
        bonusTypePool.put(BonusType.RACIAL, new AdductBonus());
        bonusTypePool.put(BonusType.RESOSTANCE, new MaximizedBonus());
        bonusTypePool.put(BonusType.SACRED, new MaximizedBonus());
    }

    /**
     * Zlicza wartość wszystkich bonusów.
     * 
     * @return
     */
    protected Integer countBonus()
    {
        int temp = 0;
        for(Bonus t : bonusTypePool.values())
            temp += t.getBonus();
        if(cared.getAbilityName().getAbiliti(abilities) != null)
            temp += cared.getAbilityName().getAbiliti(abilities).getModifier();
        if(cared.isSizeImportant() && !(cared instanceof GrappleAttack))
            temp += description.getSize().getBaseModifier();
        if(cared.isSizeImportant() && (cared instanceof GrappleAttack))
            temp += description.getSize().getGrappleAttacksModifier();

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
