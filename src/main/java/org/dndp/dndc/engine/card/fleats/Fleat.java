package org.dndp.dndc.engine.card.fleats;

import org.dndp.dndc.engine.benefit.Benefit;
import org.dndp.dndc.engine.check.Checkable;

/**
 * Klasa opisująca atut w bazie danych.
 * 
 * @author evil, bambucha
 */
public class Fleat
{

    private final Checkable[] dependency;
    private final Benefit[]   benefits;
    private String            name;

    /**
     * 
     * @param name
     *            Nazwa
     */
    public Fleat(String name, Checkable[] dependens, Benefit[] benefits)
    {
        this.name = name;
        this.dependency = dependens;
        this.benefits = benefits;
    }

    /**
     * Zwraca listę zależności.
     * 
     * @return Tablica zeleżności.
     */
    public Checkable[] getDependency()
    {
        return dependency;
    }

    /**
     * Zwraca tablicę premi zapewnianych przez atut.
     * 
     * @return Tablica premi.
     */
    public Benefit[] getBenefits()
    {
        return benefits;
    }

    /**
     * Zwraca nazwę atutu.
     * @return Nazwa.
     */
    public String getName()
    {
        return name;
    }

}
