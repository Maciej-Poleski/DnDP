package org.dndp.dndc.engine.card.attack;

import java.util.Arrays;

import org.dndp.dndc.engine.card.bonus.Bonusable;
import org.dndp.dndc.engine.util.ChangeObservable;

/**
 * Klasa abstrakcyjna definiująca interfejs i cześć zachowań Wzorzec projektowy
 * "Medtoda szablonowa"
 * 
 * @author bambucha
 */
public abstract class BaseAttack extends ChangeObservable implements Bonusable
{
    private int    bonus;
    private Attack attack;

    /**
     * Standardowy konstruktor Ustawia bazową premię do ataku na 0
     */
    public BaseAttack(Attack a)
    {
        bonus = 0;
        attack = a;
    }

    /**
     * Zwraca bazową premię do ataku
     * 
     * @return Bazowa premia do ataku
     */
    public BaseBonusToAttack getBaseAttack()
    {
        return attack.getBaseAttack();
    }

    /**
     * Zwraca całkowitą premię do ataku, bez uwzględnienia broni.
     */
    public TotalBonusToAttack getAttacks()
    {
        int[] temp = Arrays.copyOf(attack.getBaseAttack().getBonus(), attack
                .getBaseAttack().getNumberOfAttacks());
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

    void update()
    {
        setChanged();
        notifyObservers();
    }

}
