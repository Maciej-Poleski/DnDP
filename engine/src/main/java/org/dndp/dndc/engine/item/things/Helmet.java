package org.dndp.dndc.engine.item.things;

import org.dndp.dndc.engine.benefit.Benefit;
import org.dndp.dndc.engine.item.Item;
import org.dndp.dndc.engine.item.Value;

/**
 * Klasa przechowująca hełmy, czapki, szlafmyce i inne cuda, które mogą znaleźć się na głowie w formie ubioru.
 * 
 * @author bambucha
 */
public class Helmet extends Item
{

    public Helmet(String name, Double weight, Value value, Benefit[] benefits)
    {
        super(name, weight, value, benefits);
    }

    /* (non-Javadoc)
     * @see engine.item.Wearable#putOn()
     */
    @Override
    public void putOn()
    {
        if(getManager().getHelmet() != null)
            getManager().getHelmet().takeOff();
        getManager().applyItemBenefits(this);
        getManager().setHelmet(this);
        if(getParent() != null)
            getParent().remove(this);

    }

    /* (non-Javadoc)
     * @see engine.item.Wearable#takeOff()
     */
    @Override
    public void takeOff()
    {
        if(getManager().getHelmet() != this)
            return;
        getManager().abbandoItemBenefits(this);
        getManager().setHelmet(null);

    }

}
