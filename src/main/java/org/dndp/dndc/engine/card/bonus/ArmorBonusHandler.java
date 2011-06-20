package org.dndp.dndc.engine.card.bonus;

import org.dndp.dndc.engine.card.abilities.Abilities;
import org.dndp.dndc.engine.card.description.Description;

/**
 * Zajmuje się premiami do pancerza.
 * 
 * @author bambucha
 */
public class ArmorBonusHandler extends BaseBonusHandler
{

    public ArmorBonusHandler(Bonusable cared, Abilities abilities, Description description)
    {
        super(cared, abilities,description);
        bonusTypePool.put(BonusType.ARMOR, new AdductBonus());
        bonusTypePool.put(BonusType.SHIELD, new AdductBonus());
        bonusTypePool.put(BonusType.DEFLECTION, new MaximizedBonus());
        bonusTypePool.put(BonusType.DODGE, new AdductBonus());
        bonusTypePool.put(BonusType.NATURAL, new AdductBonus());
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
        return countBonus() - bonusTypePool.get(BonusType.DODGE).getBonus();
    }
    
    /**
     * Zwraca premię do Klasy Pancerza (KP) postaci podczas ataków dotykowych.
     * @return
     */
    public Integer getTouchAttacksAC()
    {
        return countBonus() - bonusTypePool.get(BonusType.ARMOR).getBonus() - bonusTypePool.get(BonusType.SHIELD).getBonus();
    }
    
}
