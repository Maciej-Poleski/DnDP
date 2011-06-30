package org.dndp.dndc.engine.card.bonus;

import java.util.Observer;

/**
 * 
 * @author evil
 */
public interface BonusManager extends Observer
{

    /**
     * Zwraca bonus handler do zarejestrowanego składnika.
     * 
     * @param name
     *            Nazwa składnika
     * @return BonusHandlare zajmujący się nim.
     */
    BaseBonusHandler getBonusHandler(String name);

    /**
     * Rejestruje w menadżerze, jedno pole.
     * 
     * @param newBonus
     *            Pole wymagające
     * @param name
     *            Nawa pola
     */
    void registerBonus(String name, Bonusable newBonus);

}
