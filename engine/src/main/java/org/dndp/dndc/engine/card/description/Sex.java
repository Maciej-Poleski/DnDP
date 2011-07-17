package org.dndp.dndc.engine.card.description;

/**
 * Klasa reprezentującą płeś
 * 
 * @author bambucha
 */
public enum Sex
{
    MALE("Mężczyzna"), FEMALE("Kobieta");

    private String name;

    private Sex(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    @Override
    public String toString()
    {
        return super.toString();
    }
}
