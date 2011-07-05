package org.dndp.dndc.engine.card.classes;

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
    private Integer   level;

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
     * @return Poziom
     */
    public Integer getLevel()
    {
        return level;
    }

    /**
     * Ustawia nowy poziom dla danej klasy
     * @param level Nowy poziom
     */
    public void setLevel(Integer level)
    {
        this.level = level;
    }

    /**
     * Zwraca opis klasy w której jest rozwijana
     * @return
     */
    public BaseClass getClasses()
    {
        return classes;
    }
}
