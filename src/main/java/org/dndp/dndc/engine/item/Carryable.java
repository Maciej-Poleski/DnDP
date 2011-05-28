package org.dndp.dndc.engine.item;

/**
 * Modeluje zachowanie związane z podnoszeniem, i zostawianiem przez postać przedmiotów.
 * 
 * @author bambucha
 */
public interface Carryable
{
    /**
     * Generuje wydarzenia podczas podnoszenia, przez postać przedmiotów. Dodaje wagę i "sprawdza rozmiary", dodaje stany. Automatycznie dodaje przedmiot do
     * ekwipunku
     * 
     * @param picker
     *            Postać podnosząca
     */
    public void pickUp(EquipmentManager picker);

    /**
     * Zostawia przedmiot, czyli wyrzuca z ekwipunku. Odejmuje wagę i czyści ekwipunek.
     */
    public void leaveBehind();
}
