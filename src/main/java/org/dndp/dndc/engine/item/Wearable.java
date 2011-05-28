package org.dndp.dndc.engine.item;

/**
 * Interfejs implementowany przez przedmioty, które można nosić. Odpowiednie metody są wywoływane podczas wydarzeń na przedmiocie.
 * 
 * @author bambucha
 */
public interface Wearable
{
    /**
     * Określa zmianny postaci oraz wydarzenia generowane podczas ubierania przedmiotu. Np zwiększenie siły podczas ubrania pasu siły olbrzyma. Item
     * implementuje ten interfejs tylko na potrzeby polimorfizmu.
     * 
     * @note Jeżli przedmiot jest nie ubieralny należu pozostawić tą funkcję pustą, albo rzucić z niej wyjątek typu checked.
     * 
     * @return true, jeżeli się udało.
     */
    public void putOn();

    /**
     * Aalogicznie do <code>putOn</code> tylko podczas ściągania zbroi, cudownych przedmiotów.
     * 
     * @return true, jeżeli się udało.
     */
    public void takeOff();
}
