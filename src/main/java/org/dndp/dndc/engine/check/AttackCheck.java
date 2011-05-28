package org.dndp.dndc.engine.check;

import org.dndp.dndc.engine.Character;

/**
 * Klasa sprawdza czy wartość bazowej premi do ataku jest wystarczająca.
 * 
 * @author bambucha
 */
public class AttackCheck implements Checkable
{
    private Integer value;
    
    
    
    /**
     * Standardowy konstruktor
     * @param value Wymagana wartość.
     */
    public AttackCheck(Integer value)
    {
        super();
        this.value = value;
    }



    /* (non-Javadoc)
     * @see engine.check.Checkable#check(engine.Character)
     */
    @Override
    public boolean check(Character character)
    {
        return character.getBaseAttack().getBonus()[0] >= value;
    }

}
