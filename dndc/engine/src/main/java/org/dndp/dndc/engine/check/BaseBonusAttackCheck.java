package org.dndp.dndc.engine.check;

import org.dndp.dndc.engine.FantasyCharacter;

/**
 * Klasa sprawdza czy wartość bazowej premi do ataku jest wystarczająca.
 * 
 * @author bambucha
 */
public class BaseBonusAttackCheck implements Checkable
{
    private Integer value;
    
    
    
    /**
     * Standardowy konstruktor
     * @param value Wymagana wartość.
     */
    public BaseBonusAttackCheck(Integer value)
    {
        super();
        this.value = value;
    }



    /* (non-Javadoc)
     * @see engine.check.Checkable#check(engine.Character)
     */
    @Override
    public boolean check(FantasyCharacter fantasyCharacter)
    {
        return fantasyCharacter.getBaseAttack().getBonus()[0] >= value;
    }

}
