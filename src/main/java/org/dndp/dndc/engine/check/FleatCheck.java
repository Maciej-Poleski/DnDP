package org.dndp.dndc.engine.check;

import org.dndp.dndc.engine.Character;
import org.dndp.dndc.engine.card.fleats.CharacterFleat.State;
import org.dndp.dndc.engine.card.fleats.Fleat;

/**
 * Sprawdza czy postać posiada wymagany atut.
 * 
 * @author bambucha
 */
public class FleatCheck implements Checkable
{
    private final Fleat fleat;
    
    /**
     * @param fleat
     */
    public FleatCheck(Fleat fleat)
    {
        super();
        this.fleat = fleat;
    }



    /* (non-Javadoc)
     * @see engine.check.Checkable#check(engine.Character)
     */
    @Override
    public boolean check(Character character)
    {
        return character.getCharacterFleat(fleat).getState() == State.ENABLED;
    }
}
