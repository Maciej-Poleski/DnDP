package org.dndp.dndc.engine.card.fleats;

import org.dndp.dndc.engine.FantasyCharacter;
import org.dndp.dndc.engine.check.Checkable;

/**
 * To wywalenie. Podwaja org.dndp.dndc.engine.check.FeleatCheck
 * 
 * Klasa opisująca zależność między atutami.
 * @author evil, bambucha
 */
public class FleatDependency implements Checkable
{
    private Fleat fleat;

    /**
     * Konstruktor.
     * 
     * @param fleat
     *            Atut.
     */
    public FleatDependency(Fleat fleat)
    {
        this.fleat = fleat;
    }

    /**
     * Sprawdza czy atut jest dostępny.
     * 
     * @param fantasyCharacter
     * @return
     */
    @Override
    public boolean check(FantasyCharacter fantasyCharacter)
    {
        return fantasyCharacter.getCharacterFleat(fleat).getState() == CharacterFleat.State.ENABLED;
    }

}
