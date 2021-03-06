package org.dndp.dndc.engine.card.abilities;

import org.dndp.dndc.engine.card.bonus.Bonusable;
import org.dndp.dndc.engine.util.ChangeObservable;

/**
 * Klasa atrybutu stworzona na potrzeby enkapsulację modyfikatora i wartości.
 * Implementuje Bonusable, by uwzględnić modyfikatory z usprawnienia.
 * 
 * @author bambucha
 * @see dndp.engine.card.abilities.Abilities
 * @see dndp.engine.card.abilities.DnDAbilities
 */
public class Abiliti extends ChangeObservable implements Bonusable
{
    int value;
    int modifier;
    int bonus;

    /**
     * Konstruktor budujący atrybut o wartości 10. Dodatkowy argument to
     * interfejs widoku danego obiektu
     * 
     * @param view
     *            Widok dla atrybutu
     */
    public Abiliti()
    {
        this.value = 10;
        this.modifier = 0;
        this.bonus = 0;
    }

    /**
     * Zwraca modyfikator atrybutu
     * 
     * @return wartość modyfikatora
     */
    public Integer getModifier()
    {
        return modifier;
    }

    /**
     * Zwraca wartość atrybutu
     * 
     * @return wartość atrybutu
     */
    public Integer getValue()
    {
        return value;
    }

    /**
     * Zmienia wartość atrybutu na inną.
     * 
     * @param value
     *            nowa wartość atrybutu
     * @throws IllegalArgumentException
     *             Gdy wartość atrybutu jest ujemna
     */
    public synchronized void setValue(int value)
    {
        if(value < 0)
            throw new IllegalArgumentException("Ujmny atrybut");
        if(this.value != value)
            setChanged();
        this.value = value;
        this.modifier = (this.value + this.bonus - 10) / 2;
        notifyObservers(this);
    }

    @Override
    public synchronized void setBonus(int bonus)
    {
        if(this.bonus != bonus)
            setChanged();
        this.bonus = bonus;
        this.modifier = (this.value + this.bonus - 10) / 2;
        notifyObservers(this);
    }

    @Override
    public AbilityType getAbilityName()
    {
        return AbilityType.NONE;
    }

    @Override
    public boolean isSizeImportant()
    {
        return false;
    }
}
