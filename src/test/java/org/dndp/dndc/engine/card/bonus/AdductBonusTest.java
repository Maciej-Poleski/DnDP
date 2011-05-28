package org.dndp.dndc.engine.card.bonus;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * 
 * @author bambucha
 */
public class AdductBonusTest
{

    public AdductBonusTest()
    {

    }

    @Test
    public void testAddBonus()
    {
        System.out.println("addBonus");
        Integer bonus1 = 2;
        Integer bonus2 = 4;
        Integer bonus3 = 1;
        AdductBonus instance = new AdductBonus();
        instance.addBonus(bonus1);
        assertEquals(instance.getBonus(), bonus1);
        instance.addBonus(bonus2);
        assertEquals(instance.getBonus(), new Integer(bonus1 + bonus2));
        instance.addBonus(bonus3);
        assertEquals(instance.getBonus(), new Integer(bonus1 + bonus2 + bonus3));
    }

    @Test
    public void testRemoveBonus()
    {
        System.out.println("removeBonus");
        Integer bonus1 = 2;
        Integer bonus2 = 4;
        Integer bonus3 = 1;
        AdductBonus instance = new AdductBonus();
        instance.addBonus(bonus1);
        instance.addBonus(bonus2);
        instance.addBonus(bonus3);
        assertEquals(instance.getBonus(), new Integer(bonus1 + bonus2 + bonus3));
        instance.removeBonus(bonus2);
        assertEquals(instance.getBonus(), new Integer(bonus1 + bonus3));
        instance.removeBonus(bonus1);
        assertEquals(instance.getBonus(), new Integer(bonus3));
        instance.addBonus(bonus2);
        assertEquals(instance.getBonus(), new Integer(bonus2 + bonus3));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveBonusException()
    {
        System.out.println("removeBonus");
        Integer bonus1 = 2;
        Integer bonus2 = 4;
        Integer bonus3 = 1;
        AdductBonus instance = new AdductBonus();
        instance.addBonus(bonus1);
        instance.addBonus(bonus2);
        instance.addBonus(bonus3);
        assertEquals(instance.getBonus(), new Integer(bonus1 + bonus2 + bonus3));
        instance.removeBonus(bonus2);
        assertEquals(instance.getBonus(), new Integer(bonus1 + bonus3));
        instance.removeBonus(bonus2);
        assertEquals(instance.getBonus(), new Integer(bonus3));
        instance.addBonus(bonus2);
        assertEquals(instance.getBonus(), new Integer(bonus2 + bonus3));
    }
}
