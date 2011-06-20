package org.dndp.dndc.engine.benefit;

import org.dndp.dndc.engine.FantasyCharacter;

/**
 * Interfejs implemetowany przez klasy opisujące jedną premię.
 * @author evil, bambucha
 */
public interface Benefit
{
    /**
     * Funkcja aplikująca premię na postaci.
     * @param benefitTarget Postać do nałożenia premi.
     */
    public void apply(FantasyCharacter benefitTarget);

    /**
     * Funkcja usuwająca premię z postaci.
     * @param benefitTarget Postać do usunięcia premii.
     */
    public void abandon(FantasyCharacter benefitTarget);
    
}
