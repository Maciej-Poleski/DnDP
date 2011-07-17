package org.dndp.dndc.engine;

/**
 * Enum z typami osobowości tworzonymi przez mechanikę.
 * 
 * @par TODO Tłumacznie
 * @author bambucha
 */
public enum PersonalityTypes
{
    PD("Praworządny Dobry"), ND("Neutrany Dobry"), CD("Chaotyczny Dobry"), PN(
            "Praworządny Neutrany"), NN("Prawdziwie Neutrany"), CN(
            "Chaotyczny Neutrany"), PZ("Praworządny Zły"), NZ("Neutrany Zły"), CZ(
            "Chaotyczny Zły");

    private PersonalityTypes(String name)
    {
        this.name = name;
    }

    private String name;

    public String getName()
    {
        return name;
    }

    @Override
    public String toString()
    {
        return name;
    }

}
