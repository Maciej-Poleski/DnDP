package org.dndp.dndc.engine.card.attack;

import java.util.Observer;

/**
 * Interfejs ataku postaci.
 * 
 * @author bambucha
 */
public interface Attack
{
    /**
     * Zwaraca bazową premię do atakau postaci.
     * 
     * @return bazowa premia do ataku
     */
    public BaseBonusToAttack getBaseAttack();

    /**
     * Ustawia bazową premnię do ataku.
     * 
     * @param newValue
     */
    public void setBaseAttack(BaseBonusToAttack newValue);

    /**
     * Zwraca atak w wręcz postaci.
     * 
     * @return atak w wręcz
     */
    public BaseAttack getMeleeAttack();

    /**
     * Zwraca premie do ataków dystansowych
     * 
     * @return premia do ataków
     */
    public BaseAttack getRangeAttack();

    /**
     * Zwaca premię do ataków w zwarciu.
     * 
     * @return premia w zwarciu
     */
    public BaseAttack getGrappleAttack();

    /**
     * Zwraca incjatywę
     * 
     * @return incjatywa postaci
     */
    public Initiative getInitiative();

    /**
     * Zwaraca szybkość postaci
     * 
     * @return
     */
    public Speed getSpeed();

    /**
     * Dodanie obserwera modułu postaci
     * 
     * @param o
     */
    public void addAttackObserver(Observer o);

    public void removeObserverFromAttack(Observer o);

    public void removeObserversFromAttack();

}
