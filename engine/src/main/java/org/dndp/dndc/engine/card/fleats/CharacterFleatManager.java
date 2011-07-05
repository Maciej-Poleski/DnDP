package org.dndp.dndc.engine.card.fleats;

import java.util.Collection;
import java.util.Observer;

/**
 * Interfejs zapewniający operacje na atutach postaci.
 * Zapewnia wyszukiwanie oraz wylistowanie atutów.
 * @author evil, bambucha
 */
public interface CharacterFleatManager
{

    /**
     * Pobiera listę atutów.
     * 
     * @return
     */
    Collection<CharacterFleat> getAllCharacterFleats();

    /**
     * Zwraca CharacterFleat dla danego Fleat
     * 
     * @param key
     * @return
     */
    CharacterFleat getCharacterFleat(Fleat key);
    
    void addFleatObserver(Observer o);

}
