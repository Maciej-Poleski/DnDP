package org.dndp.dndc.engine.check;

import org.dndp.dndc.engine.Character;
import org.dndp.dndc.engine.card.classes.BaseClass;

/**
 * Sprawdza czy klasa postaci jest na wystarczającym poziomie.
 * 
 * @author bambucha
 */
public class ClassCheck implements Checkable
{
    private final BaseClass baseClass;
    private final Integer level;
    
    /**
     * @param baseClass
     * @param level
     */
    public ClassCheck(BaseClass baseClass, Integer level)
    {
        super();
        this.baseClass = baseClass;
        this.level = level;
    }



    /* (non-Javadoc)
     * @see engine.check.Checkable#check(engine.Character)
     */
    @Override
    public boolean check(Character character)
    {
        return character.getClassLevel(baseClass) >= level;
    }

}
