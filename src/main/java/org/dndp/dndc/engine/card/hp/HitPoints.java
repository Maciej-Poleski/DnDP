package org.dndp.dndc.engine.card.hp;

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
    public Integer getHP();

    /**
     * Ustawia ilść hp postaci.
     * 
     * @param HP
     */
    public void setHP(Integer HP);

    /**
     * Zwraca maksymalną ilość hp
     * 
     * @return
     */
    public Integer getMaxHP();

    /**
     * Ustawia maksymalną ilość hp
     * 
     * @param maxHP
     *            Maksymalna Ilość HP
     */
    public void setMaxHP(Integer maxHP);

}
