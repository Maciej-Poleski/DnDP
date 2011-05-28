package org.dndp.dndc.engine.item.things;

import org.dndp.dndc.engine.benefit.Benefit;
import org.dndp.dndc.engine.item.Item;
import org.dndp.dndc.engine.item.Value;

/**
 * Klasa na buty i inne odzienie dla stóp.
 * 
 * @author bambucha
 */
public class Shoes extends Item
{

    public Shoes(String name, Double weight, Value value, Benefit[] benefits)
    {
        super(name, weight, value, benefits);
    }

    /* (non-Javadoc)
     * @see engine.item.Wearable#putOn()
     */
    @Override
    public void putOn()
    {
        if(getManager().getShoes() != null)
            getManager().getShoes().takeOff();
        getManager().applyItemBenefits(this);
        getManager().setShoes(this);
        if(getParent() != null)
            getParent().remove(this);
    }

    /* (non-Javadoc)
     * @see engine.item.Wearable#takeOff()
     */
    @Override
    public void takeOff()
    {
        if(getManager().getShoes() != this)
            return;
        getManager().abbandoItemBenefits(this);
        getManager().setShoes(null);
    }

}
