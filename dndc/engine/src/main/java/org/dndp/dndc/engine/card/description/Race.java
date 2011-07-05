package org.dndp.dndc.engine.card.description;


import org.dndp.dndc.client.FrontToDB;

import com.db4o.ObjectSet;
import com.db4o.query.Predicate;

/**
 * Klasa opisująca rasę. Dane pobiera z bazy danych w obsługiwaną przez FrontToDB.
 * 
 * @author bambucha
 */
public class Race
{
    private String name;
    private String individuality;
    private String physicalDescription;
    private String probablyPersonalityTypes;
    private String lands;
    private String religion;
    private String language;
    private String names;

    // Konstruktor stworzony na potrzeby testów opisu
    public Race()
    {
        name = "human";
        individuality = "all";
        physicalDescription = "strong";
        probablyPersonalityTypes = "PN";
        lands = "all";
        religion = "pelor";
        language = "all";
        name = "bambucha";
    }

    /**
     * Zwraca rasę z bazy danych.
     * @param name Nazwa rasy
     */
    public static Race getFromDB(final String name)
    {
        ObjectSet<Race> query = FrontToDB.getInstance().getDB().query(new Predicate<Race>()
        {
            private static final long serialVersionUID = 1L;

            @Override
            public boolean match(Race arg0)
            {
                return arg0.getName() == name;
            }

        });
        return query.get(0);
    }

    public String getIndividuality()
    {
        return individuality;
    }

    public String getLands()
    {
        return lands;
    }

    public String getLanguage()
    {
        return language;
    }

    public String getName()
    {
        return name;
    }

    public String getNames()
    {
        return names;
    }

    public String getPhysicalDescription()
    {
        return physicalDescription;
    }

    public String getProbablyPersonalityTypes()
    {
        return probablyPersonalityTypes;
    }

    public String getReligion()
    {
        return religion;
    }

}
