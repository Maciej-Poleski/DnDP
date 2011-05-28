package org.dndp.dndc.engine.card.armor;

/**
 * Interfejs obsługi pancerza
 * @author bambucha
 */
public interface Armor
{
    /**
     * Zwaraca wartość Klasy Pancerza (KP) gdy postać jest pozbawiona premi ze zręczności.
     * @return
     */
    public Integer getFlatFootetAC();

    /**
     * Zwraca wartość Klasy Pancerza (KP) dla ataków dotykowych.
     * @return
     */
    public Integer getTouchAttaksAC();
    
    
    /**
     * Zwraca wartosć Klasy Pancerza (KP) dla normalnych ataków.
     * @return
     */
    public Integer getAC();

}
