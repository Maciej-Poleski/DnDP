package org.dndp.dndc.engine.item.things;

import org.dndp.dndc.engine.benefit.Benefit;
import org.dndp.dndc.engine.item.Item;
import org.dndp.dndc.engine.item.Value;

/**
 * Klasa na branzolety, karwasze itp. przeznaczone do noszenia na zbroji.
 * 
 * @author bambucha
 */
public class Bracer extends Item
{

    public Bracer(String name, Double weight, Value value, Benefit[] benefits)
    {
        super(name, weight, value, benefits);
    }

    /* (non-Javadoc)
     * @see engine.item.Wearable#putOn()
     */
    @Override
    public void putOn()
    {
        if(getManager().getBracer() != null)
            getManager().getBracer().takeOff();
        getManager().applyItemBenefits(this);
        getManager().setBracer(this);
        if(getParent() != null)
            getParent().remove(this);
    }

    /* (non-Javadoc)
     * @see engine.item.Wearable#takeOff()
     */
    @Override
    public void takeOff()
    {
        if(getManager().getBracer() != this)
            return;
        getManager().abbandoItemBenefits(this);
        getManager().setBracer(null);
    }

}
