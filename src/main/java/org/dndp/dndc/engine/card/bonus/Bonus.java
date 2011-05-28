package org.dndp.dndc.engine.card.bonus;

/**
 * Modeluje zachowania premii.
 * 
 * @author bambucha
 */
public interface Bonus
{
    /**
     * Dodaje premię danego typu do pola
     * 
     * @param bonus
     *            Wartośc premi
     */
    public void addBonus(Integer bonus);

    /**
     * Usuwa premię danego typu z danego pola
     * 
     * @param bonus
     */
    public void removeBonus(Integer bonus);

    /**
     * Zwraca premię danego typu z pola. Uwzglednia przy tym wszystkie premie.
     * 
     * @return Warotśc premii.
     */
    public Integer getBonus();
}
