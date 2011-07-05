package org.dndp.dndc.engine.item.things;

import org.dndp.dndc.engine.benefit.Benefit;
import org.dndp.dndc.engine.item.Item;
import org.dndp.dndc.engine.item.Value;

/**
 * Opisuje wszykie amulety , brosze , medaliony, naszjniki, wisioreki lub skarabeusze występujące w grze.
 * 
 * @author bambucha
 */
public class Necklace extends Item
{

    public Necklace(String name, Double weight, Value value, Benefit[] benefits)
    {
        super(name, weight, value, benefits);
    }

    /*
     * (non-Javadoc)
     * @see engine.item.Wearable#putOn()
     */
    @Override
    public void putOn()
    {
        if(getManager().getNecklace() != null)
            getManager().getNecklace().takeOff();
        getManager().applyItemBenefits(this);
        getManager().setNecklace(this);
        if(getParent() != null)
            getParent().remove(this);
    }

    /*
     * (non-Javadoc)
     * @see engine.item.Wearable#takeOff()
     */
    @Override
    public void takeOff()
    {
        if(getManager().getNecklace() != this)
            return;
        getManager().abbandoItemBenefits(this);
        getManager().setNecklace(null);
    }

}
