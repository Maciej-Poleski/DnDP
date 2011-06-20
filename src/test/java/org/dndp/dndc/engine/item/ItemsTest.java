package org.dndp.dndc.engine.item;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNull;
import static junit.framework.Assert.fail;

import org.dndp.dndc.engine.FantasyCharacter;
import org.dndp.dndc.engine.benefit.Benefit;
import org.dndp.dndc.engine.item.armor.Plate;
import org.dndp.dndc.engine.item.things.Belt;
import org.dndp.dndc.engine.item.things.Bracer;
import org.dndp.dndc.engine.item.things.Coat;
import org.dndp.dndc.engine.item.things.Glasses;
import org.dndp.dndc.engine.item.things.Gloves;
import org.dndp.dndc.engine.item.things.Helmet;
import org.dndp.dndc.engine.item.things.Necklace;
import org.dndp.dndc.engine.item.things.Ring;
import org.dndp.dndc.engine.item.things.Shirt;
import org.junit.Test;


public class ItemsTest
{
    static FantasyCharacter           fantasyCharacter        = new FantasyCharacter();
    static DnDEquipmentManager equipmentManager = new DnDEquipmentManager(fantasyCharacter);

    static Value               value            = new Value(0, 1, 2, 0);
    static Benefit[]           benefits         = new Benefit[0];
    static Double              weight           = 1.0;

    @Test
    public void armorTest()
    {
        assertNull(equipmentManager.getArmor());
        Plate plate = new Plate("lekka", 1.0, value, new Benefit[0], 5, 1.0, 8);
        equipmentManager.putOn(plate);
        assertEquals(plate, equipmentManager.getArmor());
    }

    @Test
    public void beltTest()
    {
        assertNull(equipmentManager.getBelt());
        Belt t = new Belt("Pas", 2.0, value, new Benefit[0]);
        equipmentManager.putOn(t);
        assertEquals(t, equipmentManager.getBelt());
    }

    @Test
    public void bracerTest()
    {
        assertNull(equipmentManager.getBracer());
        Bracer bracer = new Bracer("dupa", weight, value, benefits);
        equipmentManager.putOn(bracer);
        assertEquals(bracer, equipmentManager.getBracer());
    }

    @Test
    public void coatTest()
    {
        assertNull(equipmentManager.getCoat());
        Item coat = new Coat("xx", weight, value, benefits);
        equipmentManager.putOn(coat);
        assertEquals(coat, equipmentManager.getCoat());
    }

    @Test
    public void glassesTest()
    {
        assertNull(equipmentManager.getGlasses());
        Item glasses = new Glasses("ggg", weight, value, benefits);
        equipmentManager.putOn(glasses);
        assertEquals(glasses, equipmentManager.getGlasses());
    }

    @Test
    public void glovesTest()
    {
        assertNull(equipmentManager.getGloves());
        Item gloves = new Gloves("dupa", weight, value, benefits);
        equipmentManager.putOn(gloves);
        assertEquals(gloves, equipmentManager.getGloves());
    }

    @Test
    public void helmetTest()
    {
        assertNull(equipmentManager.getHelmet());
        Item helmet = new Helmet("xxt", weight, value, benefits);
        equipmentManager.putOn(helmet);
        assertEquals(helmet, equipmentManager.getHelmet());
    }

    @Test
    public void nacklaceTest()
    {
        assertNull(equipmentManager.getNecklace());
        Item necklace = new Necklace("necklace", weight, value, benefits);
        equipmentManager.putOn(necklace);
        assertEquals(necklace, equipmentManager.getNecklace());
    }

    @Test
    public void firstSecondRingTest()
    {
        assertNull(equipmentManager.getFirstRing());
        Item ring = new Ring("sss", weight, value, benefits);
        Item sring = new Ring("sss", weight, value, benefits);
        equipmentManager.putOn(ring);
        if(!(ring.equals(equipmentManager.getFirstRing()) || ring.equals(equipmentManager.getSecondRing())))
            fail();
        equipmentManager.putOn(sring);
        if(!(ring.equals(equipmentManager.getFirstRing()) || ring.equals(equipmentManager.getSecondRing())))
            fail();
        if(!(sring.equals(equipmentManager.getFirstRing()) || sring.equals(equipmentManager.getSecondRing())))
            fail();
    }

    @Test
    public void shirtTest()
    {
        assertNull(equipmentManager.getShirt());
        Item shirt = new Shirt("sdaf", weight, value, benefits);
        equipmentManager.putOn(shirt);
        assertEquals(shirt, equipmentManager.getShirt());
    }
}
