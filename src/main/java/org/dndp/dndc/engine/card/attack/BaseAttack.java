package org.dndp.dndc.engine.card.attack;

import java.util.Arrays;
import java.util.Observable;

import org.dndp.dndc.engine.card.bonus.Bonusable;

/**
 * Klasa abstrakcyjna definiująca interfejs i cześć zachowań Wzorzec projektowy
 * "Medtoda szablonowa"
 * 
 * @author bambucha
 */
public abstract class BaseAttack extends Observable implements Bonusable
{
    private BaseBonusToAttack baseAtack;
    private int               bonus;

    /**
     * Standardowy konstruktor Ustawia bazową premię do ataku na 0
     */
    public BaseAttack()
    {
        baseAtack = new BaseBonusToAttack(new int[] { 0 });
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
        if(baseAtack == null)
            throw new NullPointerException();
        if(!this.baseAtack.equals(baseAtack))
            setChanged();
        this.baseAtack = baseAtack;
        notifyObservers();
    }

    /**
     * Zwraca całkowitą premię do ataku, bez uwzględnienia broni.
     */
    public TotalBonusToAttack getAttacks()
    {
        int[] temp = Arrays.copyOf(baseAtack.getBonus(),
                baseAtack.getNumberOfAttacks());
        for(int q = 0; q < temp.length; ++q)
            temp[q] += bonus;
        return new TotalBonusToAttack(temp);
    }

    @Override
    public void setBonus(int bonus)
    {
        if(this.bonus != bonus)
            setChanged();
        this.bonus = bonus;
        notifyObservers(this);
    }

    @Override
    public boolean isSizeImportant()
    {
        return true;
    }

}
