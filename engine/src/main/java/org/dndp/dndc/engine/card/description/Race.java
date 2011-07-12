package org.dndp.dndc.engine.card.description;

/**
 * Klasa opisująca rasę. Dane pobiera z bazy danych w obsługiwaną przez
 * FrontToDB.
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
        names = "bambucha";
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
