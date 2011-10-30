package org.dndp.dndc.engine.card.attack;

import java.sql.Array;
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
        int[] temp = new int[4];
        if(attack.getBaseAttack().getNumberOfAttacks()>0)
                    temp[0]=attack.getBaseAttack().first();
        if(attack.getBaseAttack().getNumberOfAttacks()>1)
                    temp[1]=attack.getBaseAttack().second();
        if(attack.getBaseAttack().getNumberOfAttacks()>2)
                    temp[2]=attack.getBaseAttack().third();
        if(attack.getBaseAttack().getNumberOfAttacks()>3)
                    temp[3]=attack.getBaseAttack().fourth();
        for(int q = 0; q < attack.getBaseAttack().getNumberOfAttacks(); ++q)
            temp[q] += bonus;
        return new TotalBonusToAttack(Arrays.copyOf(temp,attack.getBaseAttack().getNumberOfAttacks()));
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
