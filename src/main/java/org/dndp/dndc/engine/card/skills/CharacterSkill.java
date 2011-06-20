package org.dndp.dndc.engine.card.skills;

import java.util.Observable;

import org.dndp.dndc.engine.card.abilities.AbilityType;
import org.dndp.dndc.engine.card.bonus.BonusManager;
import org.dndp.dndc.engine.card.bonus.Bonusable;

/**
 * Klasa opiekująca się umiejętnościami bohatera. Używa Skil, jako informacji o
 * umijętności.
 * 
 * @par TODO Połączenie setRang z levelem postaci, zgodnie z wytycznymi, tj.
 *      Maksymaną ilość rang jaka może być zainwestowana w umiejętność zachodzi
 *      zgodnie równaniem
 * @f$ rank_{max} = lvl+3 @f$ gdzie lvl to suma poziomów klas postaci.
 * @author bambucha
 */
public class CharacterSkill extends Observable implements Bonusable
{
    private Skill   skil;
    private boolean isClasses;
    private int     rank;
    private int     bonus;

    /**
     * Konstruktor z opisu umiejętności
     * 
     * @param skil
     *            Opis umiejętności
     * @param bonusManager
     *            Menadżer bonusów.
     */
    public CharacterSkill(Skill skil, BonusManager bonusManager)
    {
        this.skil = skil;
        this.rank = new Integer(0);
        this.bonus = new Integer(0);
        this.isClasses = false;
        bonusManager.registerBonus(skil.getName(), this);
    }

    /**
     * Zwraca opis umiejętności
     * 
     * @return Opis umiejętności
     */
    public Skill getSkil()
    {
        return skil;
    }

    /**
     * Zwraca ilość rang umiejętności.
     * 
     * @return Ranga
     */
    public Integer getRank()
    {
        return rank;
    }

    /**
     * Ustawia ilośc rang umiejętności
     * 
     * @param rank
     */
    public void setRank(int rank)
    {
        if(rank < 0)
            throw new IllegalArgumentException("rank nie może być ujemne");
        if(this.rank != rank)
            setChanged();
        this.rank = rank;
        notifyObservers(this);
    }

    /**
     * Zwraca modyfikator. Modyfikator odnosi się do umiejętności danej postaci.
     * Jest to zbiorcze miejsce na wszystkie modyfikatory.
     * 
     * @return
     */
    public Integer getBonus()
    {
        return bonus;
    }

    /**
     * Ustawia modyfikatory do umiejętności.
     * 
     * @param bonus
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
    public AbilityType getAbilityName()
    {
        return getSkil().getAbilitiModifier();
    }

    /**
     * Zwraca iformację czy umiejętność jest umiejętnością klasową postaci.
     * 
     * @return true, jeśli klasowa
     */
    public Boolean isClasses()
    {
        return isClasses;
    }

    /**
     * Ustwia czy umiejętność jest klasowa dla postaci.
     * 
     * @param isClasses
     *            Status umiejętności.
     */
    public void setClasses(boolean isClasses)
    {
        if(this.isClasses != isClasses)
            hasChanged();
        this.isClasses = isClasses;
        notifyObservers(this);
    }

    @Override
    public boolean isSizeImportant()
    {
        return false;
    }
}
