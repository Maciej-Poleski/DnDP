package org.dndp.dndc.engine.card.attack;

import java.util.Arrays;

import org.dndp.dndc.engine.card.bonus.Bonusable;
import org.dndp.dndc.engine.Character;


/**
 * Klasa abstrakcyjna definiująca interfejs i cześć zachowań Wzorzec projektowy
 * "Medtoda szablonowa"
 * 
 * @author bambucha
 */
public abstract class BaseAttack implements Bonusable
{
    private BaseBonusToAttack baseAtack;
    private Integer           bonus;
    protected Character       main;
    protected Integer         atackModifier;

    /**
     * Standardowy konstruktor Ustawia bazową premię do ataku na 0
     * 
     * @param main
     */
    public BaseAttack(Character main)
    {
        this.main = main;
        baseAtack = new BaseBonusToAttack(new Integer[] { 0 });
        bonus = 0;
    }

    /**
     * Zwraca bazową premię do ataku
     * 
     * @return Bazowa premia do ataku
     */
    public BaseBonusToAttack getBaseAttack()
    {
        return baseAtack;
    }

    /**
     * Ustawia bazową premię do ataku
     * 
     * @param baseAtack
     *            Premia do ustawienia
     */
    public void setBaseAttack(BaseBonusToAttack baseAtack)
    {
        if (baseAtack == null)
            throw new NullPointerException();
        this.baseAtack = baseAtack;
    }

    /**
     * Funkcja licząca modyfikator ataku, niezależny od bazowego. Jest to
     * uwzględnienie rozmiaru, siły, zręczności. W zalezności od ataku.
     */
    protected abstract void countAttacksModifier();

    /*
     * Zwraca całkowitą premię do ataku, bez uwzględnienia broni.
     */
    public TotalBonusToAttack getAttacks()
    {
        countAttacksModifier();
        Integer[] temp = Arrays.copyOf(baseAtack.getBonus(),
                baseAtack.getNumberOfAttacks());
        for (int q = 0; q < temp.length; ++q)
            temp[q] += (atackModifier + bonus);
        return new TotalBonusToAttack(temp);
    }

    @Override
    public void setBonus(Integer bonus)
    {
        this.bonus = bonus;
    }

}
