package org.dndp.dndc.engine.card.state;

public interface StateManager
{

    /**
     * Ustawia stan postaci oraz wszystkie premi/kary wynikające z niego.
     * 
     * @param state
     *            Stan
     */
    public abstract void setState(State state);

    /**
     * Usuwa dany stan postaci oraz wszystkie premie/kary wynikające z niego.
     * 
     * @param state
     *            Stan do odznaczenia.
     */
    public abstract void removeState(State state);

}
