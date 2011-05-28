package org.dndp.dndc.engine.item.things;

import org.dndp.dndc.engine.benefit.Benefit;
import org.dndp.dndc.engine.item.Item;
import org.dndp.dndc.engine.item.Value;

/**
 * Moedluje kamizelaki, ornaty lub koszulki oraz inne ubrania ubierane pod nakrycie wierzchnie.
 * 
 * @author bambucha
 */
public class Shirt extends Item
{

    public Shirt(String name, Double weight, Value value, Benefit[] benefits)
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
        if(getManager().getShirt() != null)
            getManager().getShirt().takeOff();
        getManager().applyItemBenefits(this);
        getManager().setShirt(this);
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
        if(getManager().getShirt() != this)
            return;
        getManager().abbandoItemBenefits(this);
        getManager().setShirt(this);
    }

}
