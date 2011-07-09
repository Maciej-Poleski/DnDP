package org.dndp.dndc.engine.card.st;

import java.util.Observer;

/**
 * Interfejs rzutów obronnych
 * 
 * @author bambucha
 */
public interface SavingThrows
{
    /**
     * Zwraca dostęp do rzutów na wytrzymałość
     * 
     * @return Wynik testu
     */
    SavingThrow getForttiude();

    /**
     * Zwraca dostęp do rzutów na refleks
     * 
     * @return Wynik testu
     */
    SavingThrow getReflex();

    /**
     * Zwraca dostęp do rzutów na wolę
     * 
     * @return Wartość testu
     */
    SavingThrow getWill();

    /**
     * Zwraca odporność na czary
     * 
     * @return Wartość odporności na czary
     */
    double getSpellResistance();

    /**
     * Ustawia nową wartość odpornosci na magię
     * 
     * @param newValue
     *            Nowa wartość
     * @throw IllegalArgumentException newValue &lt 0
     */
    void setSpellResistance(double newValue);

    void addSavingThrowObserver(Observer o);

    void removeObserverFromST(Observer o);

    void removeObserversFromST();

}
