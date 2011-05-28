package org.dndp.dndc.engine.item;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.dndp.dndc.engine.benefit.Benefit;
import org.dndp.dndc.engine.item.things.Belt;
import org.dndp.dndc.engine.item.things.Coat;
import org.dndp.dndc.engine.item.things.Helmet;
import org.dndp.dndc.engine.item.things.Shirt;
import org.dndp.dndc.engine.item.things.Shoes;
import org.junit.Test;


public class InventoryTest
{
    Benefit[] benefits      = new Benefit[0];
    Item      belt          = new Belt("belt", 0.5, new Value(0, 1, 2, 3), benefits);
    Item      coat          = new Coat("coat", 1.3, new Value(1, 0, 0, 7), benefits);
    Item      shoes         = new Shoes("shoes", 0.4, new Value(0, 0, 7, 5), benefits);

    Item      dupa          = new Shirt("sss", 1.0, new Value(1, 1, 1, 1), benefits);
    Item      dupa2         = new Helmet("ss", 1.0, new Value(1, 1, 1, 1), benefits);
    Inventory testInventory = new Inventory("sd", 3.0, new Value(5, 5, 5, 5), benefits);

    Inventory inventory     = new Inventory("inv", 1.3, new Value(0, 0, 0, 5), benefits);

    public InventoryTest()
    {
        testInventory.add(dupa);
        testInventory.add(dupa2);
    }

    @Test
    public void testGetInventory()
    {
        assertNotNull(inventory.getInventory());
    }

    @Test
    public void testAdd()
    {
        inventory.add(belt);
        assertEquals(1.8, inventory.getWeight().doubleValue(), 0.1);
        assertEquals(new Value(0, 1, 2, 8).toString(), inventory.getValue().toString());
        inventory.add(coat);
        assertEquals(3.1, inventory.getWeight().doubleValue(), 0.1);
        assertEquals(new Value(1, 1, 3, 5).toString(), inventory.getValue().toString());
        inventory.add(shoes);
        assertEquals(3.5, inventory.getWeight().doubleValue(), 0.1);
        assertEquals(new Value(1, 2, 1, 0).toString(), inventory.getValue().toString());
        inventory.add(testInventory);
        assertEquals(8.5, inventory.getWeight().doubleValue(), 0.1);
        assertEquals(new Value(8, 9, 8, 7).toString(), inventory.getValue().toString());
    }

    @Test
    public void testRemove()
    {
        inventory.add(belt);
        inventory.add(coat);
        inventory.add(shoes);
        inventory.add(testInventory);
        assertEquals(8.5, inventory.getWeight().doubleValue(), 1);
        assertEquals(new Value(8, 9, 8, 7).toString(), inventory.getValue().toString());
        inventory.remove(testInventory);
        assertEquals(3.5, inventory.getWeight().doubleValue(), 1);
        assertEquals(new Value(1, 2, 1, 0).toString(), inventory.getValue().toString());
        inventory.remove(shoes);
        assertEquals(3.1, inventory.getWeight().doubleValue(), 1);
        assertEquals(new Value(1, 1, 3, 5).toString(), inventory.getValue().toString());
        inventory.remove(coat);
        assertEquals(1.8, inventory.getWeight().doubleValue(), 1);
        assertEquals(new Value(0, 1, 2, 8).toString(), inventory.getValue().toString());
        inventory.remove(belt);
        assertEquals(1.3, inventory.getWeight().doubleValue(), 1);
        assertEquals(new Value(0, 0, 0, 5).toString(), inventory.getValue().toString());

    }

    @Test
    public void testContainsByName()
    {
        inventory.add(belt);
        inventory.add(coat);
        inventory.add(shoes);
        inventory.add(testInventory);

        assertTrue(inventory.containsByName("ss"));
        assertTrue(inventory.containsByName("sss"));

        assertTrue(inventory.containsByName("belt"));
        assertTrue(inventory.containsByName("coat"));
    }

    @Test
    public void testContainsByExample()
    {
        inventory.add(belt);
        inventory.add(coat);
        inventory.add(shoes);
        inventory.add(testInventory);

        assertTrue(inventory.containsByExample(dupa));
        assertTrue(inventory.containsByExample(dupa2));

        assertTrue(inventory.containsByExample(belt));
        assertTrue(inventory.containsByExample(coat));
    }

}
