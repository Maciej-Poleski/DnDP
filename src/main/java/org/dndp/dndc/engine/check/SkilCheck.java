package org.dndp.dndc.engine.check;

import org.dndp.dndc.engine.Character;
import org.dndp.dndc.engine.card.skills.Skill;

/**
 * Sprawdza czy postać ma wystarczającą ilośc rank w danej umiejętności.
 * 
 * @author bambucha
 */
public class SkilCheck implements Checkable
{
    private final Skill skil;
    private final Integer rank;
    
    /**
     * @param skil
     * @param rank
     */
    public SkilCheck(Skill skil, Integer rank)
    {
        super();
        this.skil = skil;
        this.rank = rank;
    }



    /* (non-Javadoc)
     * @see engine.check.Checkable#check(engine.Character)
     */
    @Override
    public boolean check(Character character)
    {
        return character.getSkil(skil.getName()).getRank() >= rank;
    }

}
