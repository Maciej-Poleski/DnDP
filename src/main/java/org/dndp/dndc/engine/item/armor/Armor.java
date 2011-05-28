package org.dndp.dndc.engine.item.armor;

import org.dndp.dndc.engine.benefit.Benefit;
import org.dndp.dndc.engine.item.Item;
import org.dndp.dndc.engine.item.Value;

/**
 * Klasa implemetująca część wspólną pancerzy, tarcz i innych
 * 
 * @author bambucha
 */
public abstract class Armor extends Item
{
    private final Integer armorPenalty;
    private final Double  arcaneSpellFail;

    /**
     * Konstruktro dla klas dzieci
     * 
     * @param name
     *            Nazwa
     * @param weight
     *            Waga
     * @param value
     *            Wartość
     * @param ACBonus
     *            Premia do pancerza
     * @param armorPenalty
     *            Kara do testów
     * @param arcaneSpellFail
     *            Szansa Niepowodzenia Czarów
     */
    public Armor(String name, Double weight, Value value, Benefit[] benefits, Integer armorPenalty, Double arcaneSpellFail)
    {
        super(name, weight, value, benefits);
        this.armorPenalty = armorPenalty;
        this.arcaneSpellFail = arcaneSpellFail;
    }

    /**
     * Zwraca karę do testów umiejętności z pancerza
     * 
     * @return Kara
     */
    public Integer getArmorPenalty()
    {
        return armorPenalty;
    }

    /**
     * Zwraca nie
     * 
     * @return
     */
    public Double getArcaneSpellFail()
    {
        return arcaneSpellFail;
    }
}
