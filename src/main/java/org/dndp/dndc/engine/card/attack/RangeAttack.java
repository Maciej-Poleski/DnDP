package org.dndp.dndc.engine.card.attack;

import org.dndp.dndc.engine.Character;
import org.dndp.dndc.engine.card.abilities.AbilityType;

/**
 * Klasa obsługująca ataki dystansowe
 * 
 * @author bambucha
 */
public class RangeAttack extends BaseAttack
{

    /**
     * Standardowy konstruktor z postacią
     * 
     * @param main
     */
    public RangeAttack(Character main)
    {
        super(main);
    }

    /**
     * Liczy premię do ataków dystansowych. Uwględnia modyfikatro ze zręcznośći
     * i rozmiar. Nie uwzględnia kary za odległość.
     */
    @Override
    protected int countAttacksModifier()
    {
        return main.getSize().getBaseModifier();
    }

    @Override
    public AbilityType getAbilityName()
    {
        return AbilityType.DEXTERITY;
    }
}
