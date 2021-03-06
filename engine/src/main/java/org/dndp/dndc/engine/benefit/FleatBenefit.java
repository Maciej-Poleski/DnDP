package org.dndp.dndc.engine.benefit;

import org.dndp.dndc.engine.FantasyCharacter;
import org.dndp.dndc.engine.card.fleats.Fleat;

/**
 * Klasa kapsułkując premię będącą atutem.
 * 
 * @author bambucha
 */
public class FleatBenefit implements Benefit
{
    private Fleat fleat;
    
    
    /**
     * @param fleat
     */
    public FleatBenefit(Fleat fleat)
    {
        this.fleat = fleat;
    }

    /* (non-Javadoc)
     * @see engine.benefit.Benefit#apply(engine.Character)
     */
    @Override
    public void apply(FantasyCharacter benefitTarget)
    {
        benefitTarget.getCharacterFleat(fleat).active();
    }

    /* (non-Javadoc)
     * @see engine.benefit.Benefit#abandon(engine.Character)
     */
    @Override
    public void abandon(FantasyCharacter benefitTarget)
    {
        benefitTarget.getCharacterFleat(fleat).deactive();
    }

}
