package org.dndp.dndc.engine.card.hp;

import java.util.Observer;

/**
 * Interfejs punktów życia postaci
 * 
 * @author bambucha
 */
public interface HitPoints
{
    /**
     * Zwraca aktualną ilość HP postaci.
     * 
     * @return
     */
    public int getHP();

    /**
     * Ustawia ilść hp postaci.
     * 
     * @param HP
     */
    public void setHP(int HP);

    /**
     * Zwraca maksymalną ilość hp
     * 
     * @return
     */
    public int getMaxHP();

    /**
     * Ustawia maksymalną ilość hp
     * 
     * @param maxHP
     *            Maksymalna Ilość HP
     */
    public void setMaxHP(int maxHP);

    public void addHitPointsObserver(Observer o);

    public void removeObserversFromHP();

    public void removeObserverFromHP(Observer o);

}
