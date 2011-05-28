package org.dndp.dndc.engine.card.bonus;

import org.dndp.dndc.engine.card.abilities.Abilities;

/**
 * Zajmuje się premiami do pancerza.
 * 
 * @author bambucha
 */
public class ArmorBonusHandler extends BaseBonusHandler
{

    public ArmorBonusHandler(Bonusable cared, Abilities abilities)
    {
        super(cared, abilities);
        bonusTypePool.put(BonusType.Armor, new AdductBonus());
        bonusTypePool.put(BonusType.Shield, new AdductBonus());
        bonusTypePool.put(BonusType.Deflection, new MaximizedBonus());
        bonusTypePool.put(BonusType.Dodge, new AdductBonus());
        bonusTypePool.put(BonusType.Natural, new AdductBonus());
    }
    
    /**
     * Zwraca pełną premię do Klasy Pancerza (KP)
     * @return Premia
     */
    public Integer getACBonus()
    {
        return countBonus();
    }
    
    /**
     * Zwraca premię do Klasy Pancerza (KP) gdy jest pozbawiona premi do pancerza.
     * @return Premia
     */
    public Integer getFlatFootetAC()
    {
        return countBonus() - bonusTypePool.get(BonusType.Dodge).getBonus();
    }
    
    /**
     * Zwraca premię do Klasy Pancerza (KP) postaci podczas ataków dotykowych.
     * @return
     */
    public Integer getTouchAttacksAC()
    {
        return countBonus() - bonusTypePool.get(BonusType.Armor).getBonus() - bonusTypePool.get(BonusType.Shield).getBonus();
    }
    
}
