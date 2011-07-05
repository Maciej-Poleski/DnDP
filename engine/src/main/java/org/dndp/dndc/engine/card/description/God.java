package org.dndp.dndc.engine.card.description;

import org.dndp.dndc.engine.PersonalityTypes;

/**
 * Klasa reperzętująca bóstwo.
 * 
 * @author bambucha
 */
public class God
{
    private String           name;
    private String           description;
    private PersonalityTypes character;

    // Konstruktor stworzony na potrzeby testów opisu będą osobne testy
    public God()
    {
        name = "pelor";
        description = "strong";
        character = PersonalityTypes.ND;
    }

    public String getName()
    {
        return this.name;
    }

    public PersonalityTypes getCharacter()
    {
        return character;
    }

    public String getDescription()
    {
        return description;
    }

}
