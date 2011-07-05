package org.dndp.dndc.engine.item.things;

import org.dndp.dndc.engine.benefit.Benefit;
import org.dndp.dndc.engine.item.Item;
import org.dndp.dndc.engine.item.Value;

/**
 * Klasa modelująca okulary, soczewki, monokle i inne przyrządy optyczne, które mogą być noszone przez postać by poprawić wzrok i nie tylko.
 * 
 * 
 * @author bambucha
 */
public class Glasses extends Item
{

    public Glasses(String name, Double weight, Value value, Benefit[] benefits)
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
        if(getManager().getGlasses() != null)
            getManager().getGlasses().takeOff();
        getManager().applyItemBenefits(this);
        getManager().setGlasses(this);
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
       if(getManager().getGlasses() != this)
           return;
       getManager().abbandoItemBenefits(this);
       getManager().setGlasses(null);

    }

}
