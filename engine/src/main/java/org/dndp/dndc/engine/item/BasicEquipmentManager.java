package org.dndp.dndc.engine.item;

/**
 * Zapewnia interfejs przedmiotów dla postaci.
 * 
 * @author bambucha
 */
public interface BasicEquipmentManager
{

    /**
     * Powoduje zaaplikownaie na postaci premi przedmiotu. Wywołuwać podczas, ubierania przedmiotów, oraz wyciągania ich w celu użycia, np magiczego miecza z
     * pochwy.
     * 
     * @param what
     *            Przedmiot
     */
    public abstract void putOn(Item what);

    /**
     * Wrzuca przedmiot do plecaka. Wywoływana podczas podnoszenia przedmiotów, oraz po ściągnięciu przedmiotu.
     * 
     * @param what
     *            Przedmiot
     */
    public abstract void store(Item what);

    /**
     * Zwraca karę do testów umiejętności wynikającą z pancerza. Uwzględnia cały ekwipunek.
     * 
     * @return Kara do testów.
     */
    public abstract Integer getCurrentArmorPently();

    /**
     * Zwraca maksymalną premię do pancerza wynikającą ze zręczności na którą pozwala noszona zbroja.
     * 
     * @return Masymalna premia do KP.
     */
    public abstract Integer getMaximumDexterityACBonus();

}
