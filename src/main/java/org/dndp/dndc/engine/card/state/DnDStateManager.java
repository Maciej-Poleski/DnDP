package org.dndp.dndc.engine.card.state;

import java.util.HashSet;
import java.util.Set;

import org.dndp.dndc.engine.Character;
import org.dndp.dndc.engine.benefit.Benefit;


/**
 * Klasa obsługująca stany postaci. Kontroluje wszystkie stany postaci.
 * 
 * @author bambucha
 */
public class DnDStateManager implements StateManager
{
    private Set<State> statusSet;
    private Character  character;

    public DnDStateManager(Character character)
    {
        this.statusSet = new HashSet<State>();
        this.character = character;
    }

    /*
     * (non-Javadoc)
     * @see engine.card.state.StateManager#setState(engine.card.state.State)
     */
    @Override
    public void setState(State state)
    {
        statusSet.add(state);
        for (Benefit b : state.getBenefits())
            b.apply(character);
    }

    /*
     * (non-Javadoc)
     * @see engine.card.state.StateManager#removeState(engine.card.state.State)
     */
    @Override
    public void removeState(State state)
    {
        if(statusSet.contains(state))
            throw new IllegalArgumentException("Nie ma ustawionego takiego stanu");
        statusSet.remove(state);
        for (Benefit b : state.getBenefits())
            b.abandon(character);
    }

}
