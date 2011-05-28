package org.dndp.dndc.engine.card.description;


import org.dndp.dndc.client.FrontToDB;
import org.dndp.dndc.engine.PersonalityTypes;

import com.db4o.ObjectSet;
import com.db4o.query.Predicate;


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

    /**
     * @param name Nazwa bóstwa.
     */
    public static God getFromDB(final String name)
    {
        ObjectSet<God> query = FrontToDB.getInstance().getDB().query(new Predicate<God>()
        {
            private static final long serialVersionUID = 1L;

            @Override
            public boolean match(God arg0)
            {
                return arg0.getName() == name;
            }
            
        });
        return query.get(0);
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
