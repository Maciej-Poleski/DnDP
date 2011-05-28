package org.dndp.dndc.engine.item.things;

import org.dndp.dndc.engine.benefit.Benefit;
import org.dndp.dndc.engine.item.Item;
import org.dndp.dndc.engine.item.Value;

/**
 * Opisuje opończe, płaszcze , peleryny lub koszule noszona na zbroji.
 * 
 * @author bambucha
 */
public class Coat extends Item
{

    public Coat(String name, Double weight, Value value, Benefit[] benefits)
    {
        super(name, weight, value, benefits);
    }

    /* (non-Javadoc)
     * @see engine.item.Wearable#putOn()
     */
    @Override
    public void putOn()
    {
        if(getManager().getCoat() != null)
            getManager().getCoat().takeOff();
        getManager().applyItemBenefits(this);
        getManager().setCoat(this);
        if(getParent() != null)
            getParent().remove(this);

    }

    /* (non-Javadoc)
     * @see engine.item.Wearable#takeOff()
     */
    @Override
    public void takeOff()
    {
        if(getManager().getCoat() != this)
            return;
        getManager().abbandoItemBenefits(this);
        getManager().setCoat(null);
            

    }

}
