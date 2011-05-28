package org.dndp.dndc.engine.card.state;

import org.dndp.dndc.engine.benefit.Benefit;

/**
 * Jeden stan możliwy postaci.
 * 
 * @par TODO Ztworzenie wiązań do grafu.
 * 
 * @author bambucha
 */
public class State
{
    private final String name;
    private final Benefit[] benefits; // Skutki ustawienia stanu.
    //private List<State> stats;
    
    /**
     * @param name Nazwa stanu.
     * @param benefits Premie/Kary stanu.
     */
    public State(String name, Benefit[] benefits)
    {
        super();
        this.name = name;
        this.benefits = benefits;
    }

    /**
     * Zwraca nazwę stanu.
     * @return Nazwa.
     */
    public String getName()
    {
        return name;
    }

    /**
     * Zwraca listę premi/kar
     * @return Lista kar/premi.
     */
    public Benefit[] getBenefits()
    {
        return benefits;
    }
    
    
}
