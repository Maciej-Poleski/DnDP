package org.dndp.dndc.engine.card.skills;

import java.util.Collection;
import java.util.Observer;
import java.util.Set;

import org.dndp.dndc.engine.card.UnavailableTestException;

public interface SkillManager
{

    /**
     * Wykonuje test umijętności, wyszukując ją wg nazwy.
     * 
     * @param name
     * @return
     * @throws UnavailableTestException
     *             Gdy test jest niemożluwy do przeprowadzenia
     */
    public abstract Integer testSkil(String name)
            throws UnavailableTestException;

    /**
     * Zwraca umiejętność postaci na podstawie jej nazyw.
     * 
     * @param name
     *            Nazwa umiejętności.
     * @return Umiejętność postaci.
     */
    public abstract CharacterSkill getSkil(String name);

    /**
     * Zwraca set z nazwami umiejętności.
     * 
     * @see java.util.Map
     * @return
     */
    public abstract Set<String> getSkilNameSet();

    /**
     * Zwraca zbiór umiejętnośći postaci.
     * 
     * @return zbiór umiejętności
     */
    public abstract Collection<CharacterSkill> getCharacterSkillSet();

    public abstract void addSkillObserver(Observer o);

    public abstract void removeObserverFromSkill(Observer o);

    public abstract void removeObserversFromSkill();

}
