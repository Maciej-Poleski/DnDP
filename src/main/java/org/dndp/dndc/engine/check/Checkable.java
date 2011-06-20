/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
package org.dndp.dndc.engine.check;

import org.dndp.dndc.engine.FantasyCharacter;

/**
 * Interfejs sprawdzający...
 * Jeżeli postać spełnia warunki 
 * 
 * @author evil, bambucha
 */
public interface Checkable
{
    /**
     * Sprawdza czy można zastosować.
     * 
     * @param fantasyCharacter
     *            Postać na rzecz której dokonuje sie sprawdzanie.
     * @return true Jeżeli można.
     */
    boolean check(FantasyCharacter fantasyCharacter);
}
