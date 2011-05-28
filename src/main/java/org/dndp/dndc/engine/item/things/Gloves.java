package org.dndp.dndc.engine.item.things;

import org.dndp.dndc.engine.benefit.Benefit;
import org.dndp.dndc.engine.item.Item;
import org.dndp.dndc.engine.item.Value;

/**
 * 
 * 
 * @author bambucha
 */
public class Gloves extends Item
{

    public Gloves(String name, Double weight, Value value, Benefit[] benefits)
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
        if(getManager().getGloves() != null)
            getManager().getGloves().takeOff();
        getManager().applyItemBenefits(this);
        getManager().setGloves(this);
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
        if(getManager().getGloves() != this)
            return;
        getManager().abbandoItemBenefits(this);
        getManager().setGloves(null);

    }

}
