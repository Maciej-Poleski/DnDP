package org.dndp.dndc.engine.card.st;

import java.util.Observable;

import org.dndp.dndc.engine.Dice;
import org.dndp.dndc.engine.card.bonus.Bonusable;

/**
 * Klasa opisująca rzut obronny. <br/>
 * Wzorzec projektowy Metoda szablonowa
 * 
 * @author bambucha
 */
public abstract class SavingThrow extends Observable implements Bonusable
{
    private int base;
    private int bonus;

    /**
     * Standardowy konstrukor, tworzy rzut z zerową premią i dodatkowymi modyfikatorami
     * 
     * @param view
     *            Widok rzutu
     */
    public SavingThrow()
    {
        this.base = 0;
        this.bonus = 0;
    }

    /**
     * Wykonuje rzut obrony
     * 
     * @return Wynik rzutu
     */
    public Integer getThrow()
    {
        return Dice.D20.throwTheDice() + bonus;
    }

    /**
     * Zwraca wartość bazowej premii do rzutu obronnego
     * 
     * @return Wartość premii
     */
    public Integer getBaseModifier()
    {
        return base;
    }

    /**
     * Zwraca cały modyfikator do rzutu obronnego.
     * 
     * @return
     */
    public Integer getTotalModifier()
    {
        return base + bonus;
    }

    /**
     * Ustawia wartość bazowej premii do rzutu obronnego
     * 
     * @param base
     *            Nowa wartość
     * @throws IllegalArgumentException
     *             base &lt 0
     */
    public void setBaseModifier(Integer base)
    {
        if(base < 0)
            throw new IllegalArgumentException("Nie może być < 0");
        if(this.base != base)
            setChanged();
        this.base = base;
        notifyObservers(this);
        
    }

    /**
     * Zwraca dodatkowy modyfikator rzutu obronnego
     * 
     * @return Warość modyfikatora
     */
    public Integer getBonus()
    {
        return bonus;
    }

    /**
     * Ustawia dodatkowy modyfikator rzutu obronnego
     * 
     * @param bonus
     *            Nowa wartość
     */
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
        return false;
    }

}
