package org.dndp.dndc.engine.item.things;

import org.dndp.dndc.engine.benefit.Benefit;
import org.dndp.dndc.engine.item.Item;
import org.dndp.dndc.engine.item.Value;

/**
 * Klasa na pierścienie.
 * 
 * @par TODO Wymaga specyficznego putOn i takeOff. W szególności specyficzne problemy będa przy zamianie przedmiotów.
 * 
 * @author bambucha
 */
public class Ring extends Item
{

    public Ring(String name, Double weight, Value value, Benefit[] benefits)
    {
        super(name, weight, value, benefits);
    }

    /* (non-Javadoc)
     * @see engine.item.Wearable#putOn()
     */
    @Override
    public void putOn()
    {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Brak implementacji");

    }

    /* (non-Javadoc)
     * @see engine.item.Wearable#takeOff()
     */
    @Override
    public void takeOff()
    {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Brak implementacji");

    }

}
