package org.dndp.dndc.engine.item;

import org.dndp.dndc.engine.FantasyCharacter;

/**
 * Interfejs pozwalający na taka postaci przedmiotem.
 * 
 * @author bambucha
 */
public interface Attackable
{
    /**
     * Wytwarza AtackEvent w kierunku postaci.
     * 
     * @param who
     *            Zatakowany
     */
    public void Attack(FantasyCharacter who);
}
