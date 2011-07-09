package org.dndp.dndc.engine.card.classes;

import static java.lang.Math.floor;

/**
 * Opis jednej klasy wybranej przez postać.
 * 
 * Opisuje klasę gdzie gracz zdecydował się rozwinąc przynajmniej jeden level.
 * 
 * @author bambucha
 */
public class CharacterClass
{
    private BaseClass classes;
    private int       level;

    /**
     * @param classes
     * @param level
     */
    public CharacterClass(BaseClass classes, Integer level)
    {
        super();
        this.classes = classes;
        this.level = level;
    }

    /**
     * Zwraca poziom w danej klasie
     * 
     * @return Poziom
     */
    public Integer getLevel()
    {
        return level;
    }

    /**
     * Ustawia nowy poziom dla danej klasy
     * 
     * @param level
     *            Nowy poziom
     */
    public void setLevel(int level)
    {
        this.level = level;
    }

    /**
     * Zwraca opis klasy w której jest rozwijana
     * 
     * @return
     */
    public BaseClass getClasses()
    {
        return classes;
    }

    private int countLowSavingThorwBonus()
    {
        return (int)floor(level / 3);
    }

    private int countHightSavingThrowBonus()
    {
        return (int)(2 + floor(level / 2));
    }

    public Integer getFortitudeBonus()
    {
        if(classes.isHighFortitudeBonus())
            return countHightSavingThrowBonus();
        return countLowSavingThorwBonus();
    }

    public Integer getReflexBonus()
    {
        if(classes.isHighReflexeBonus())
            return countHightSavingThrowBonus();
        return countLowSavingThorwBonus();
    }

    public Integer getWillBonus()
    {
        if(classes.isHighWillBonus())
            return countHightSavingThrowBonus();
        return countLowSavingThorwBonus();
    }

}
