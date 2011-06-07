package org.dndp.dndc.engine.card.fleats;

import java.util.Observable;

/**
 * Klasa opisująca atut u postaci.
 * 
 * @author evil, bambucha
 */
public class CharacterFleat extends Observable
{
    /**
     * Możliwe stany atutu danej postaci.
     */
    public enum State
    {
        /**
         * Możliwy, wyłączony
         */
        ABLE,
        /**
         * Możliwy, włączony
         */
        ENABLED,
        /**
         * Niemożliwy, wyłączony
         */
        DISABLED,
    }

    private Fleat                    fleat;
    private State                    state;
    private DnDCharacterFleatManager characterFleatManager;

    /**
     * Inicjalizuje ten atut danej postaci.
     * 
     * @param fleat
     *            Dany atut.
     * @param characterFleatManager
     *            Menadżer atutów danej postaci.
     */
    public CharacterFleat(Fleat fleat, DnDCharacterFleatManager characterFleatManager)
    {
        this.fleat = fleat;
        this.state = State.DISABLED;
        this.characterFleatManager = characterFleatManager;
    }

    /**
     * Sprawdza czy atut można zastosować.
     * 
     * @return
     */
    public synchronized void isPossible()
    {
        if (state != State.DISABLED)
            return;
        if (characterFleatManager.checkFleat(fleat))
        {
            state = State.ABLE;
            setChanged();
            notifyObservers();
        }
    }

    /**
     * Zwraca status tego atutu u danej postaci.
     * 
     * @return
     */
    public State getState()
    {
        return state;
    }

    /**
     * Funkcja aktuwuje atut oraz płynące z niego korzyści.
     */
    public synchronized void active()
    {
        if (state == State.ABLE)
        {
            characterFleatManager.setFleatBenefit(fleat);
            state = State.ENABLED;
            setChanged();
            notifyObservers(State.ENABLED);
        }
    }

    public synchronized void deactive()
    {
        if (state == State.ENABLED)
        {
            characterFleatManager.unsetFleatBenefit(fleat);
            state = State.ABLE;
            setChanged();
            notifyObservers(State.ABLE);
        }
    }

}
