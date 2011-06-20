package org.dndp.dndc.engine.check;

import org.dndp.dndc.engine.FantasyCharacter;
import org.dndp.dndc.engine.card.abilities.AbilityType;

/**
 * Sprawdza czy wskazany atrybut ma wystarczającą wartośc.
 * 
 * @author bambucha
 */
public class AbilitiCheck implements Checkable
{
    private final AbilityType abilityType;
    private final Integer value;

    
    /**
     * Standardowy konstruktor
     * @param abilityType Atrybut do testów.
     * @param value Wymagana wartość.
     */
    public AbilitiCheck(AbilityType abilityType, Integer value)
    {
        super();
        this.abilityType = abilityType;
        this.value = value;
    }


    /* (non-Javadoc)
     * @see engine.check.Checkable#check(engine.Character)
     */
    @Override
    public boolean check(FantasyCharacter fantasyCharacter)
    {
        return abilityType.getAbiliti(fantasyCharacter).getValue() >= value;
    }

}
