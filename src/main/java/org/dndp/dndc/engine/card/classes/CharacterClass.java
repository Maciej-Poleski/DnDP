package org.dndp.dndc.engine.card.classes;

/**
 * Opis jednej klasy wybranje przez postać.
 * 
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

    public Integer getLevel()
    {
        return level;
    }

    public void setLevel(Integer level)
    {
        this.level = level;
    }

    public BaseClass getClasses()
    {
        return classes;
    }
}
