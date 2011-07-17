package org.dndp.dndc.engine.item.armor;

import org.dndp.dndc.engine.benefit.Benefit;
import org.dndp.dndc.engine.item.Value;

/**
 * Klasa na zbroje i inne "ubierane" na klatkę piersiową pancerze.
 * 
 * @author bambucha
 */
public class Plate extends Armor
{
    private final Integer maxDexBonus;

    /**
     * Kosntruktor budujący całą zbroje od zera.
     * 
     * @param name
     *            Nazwa
     * @param weight
     *            Waga
     * @param value
     *            Wartość rynkowa
     * @param benefits
     *            Premie przedmiotu
     * @param armorPenalty
     *            Kara do testów
     * @param arcaneSpellFail
     *            Niepowodzenie czarów
     * @param maxDexBonus
     *            Masksymalna premia ze zręczności do pancerza
     * @see dndp.engine.item.Item
     * @see engine.item.Armor
     */
    public Plate(String name, Double weight, Value value, Benefit[] benefits, Integer armorPenalty, Double arcaneSpellFail,
            Integer maxDexBonus)
    {
        super(name, weight, value, benefits, armorPenalty, arcaneSpellFail);
        this.maxDexBonus = maxDexBonus;
    }

    /**
     * Zwraca maksymalną premię ze zręczności do pancerza wynikającą ze zbroji
     * 
     * @return Wartość maksymalna premi
     */
    public Integer getMaxDexBonus()
    {
        return maxDexBonus;
    }

    @Override
    public void putOn()
    {
        if(getManager().getArmor() != null)
            getManager().getArmor().takeOff();
        getManager().applyItemBenefits(this);
        getManager().setArmor(this);
        if(getParent() != null)
            getParent().remove(this);
    }

    @Override
    public void takeOff()
    {
        if(getManager().getArmor() != this)
            return;
        getManager().store(this);
        getManager().abbandoItemBenefits(this);
        getManager().setArmor(null);
    }

}
