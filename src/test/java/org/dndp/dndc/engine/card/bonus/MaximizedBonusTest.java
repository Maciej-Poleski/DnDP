/*
 * To change this template, choose Tools | Templates and open the template in the editor.
 */

package org.dndp.dndc.engine.card.bonus;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * 
 * @author bambucha
 */
public class MaximizedBonusTest
{

    @BeforeClass
    public static void setUpClass() throws Exception
    {}

    @AfterClass
    public static void tearDownClass() throws Exception
    {}

    @Test
    public void testAddBonus()
    {
        System.out.println("addBonus");
        Integer bonus1 = 2;
        Integer bonus2 = 4;
        Integer bonus3 = 1;
        MaximizedBonus instance = new MaximizedBonus();
        instance.addBonus(bonus1);
        assertEquals(bonus1, instance.getBonus());
        instance.addBonus(bonus2);
        assertEquals(bonus2, instance.getBonus());
        instance.addBonus(bonus3);
        assertEquals(bonus2, instance.getBonus());

    }

    @Test
    public void testRemoveBonus()
    {
        System.out.println("removeBonus");
        Integer bonus1 = 2;
        Integer bonus2 = 4;
        Integer bonus3 = 1;
        MaximizedBonus instance = new MaximizedBonus();
        instance.addBonus(bonus1);
        instance.addBonus(bonus2);
        instance.addBonus(bonus3);
        assertEquals(bonus2, instance.getBonus());
        instance.removeBonus(bonus2);
        assertEquals(bonus1, instance.getBonus());
        instance.removeBonus(bonus1);
        assertEquals(bonus3, instance.getBonus());
        instance.removeBonus(bonus3);
        assertEquals(new Integer(0), instance.getBonus());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveBonusException()
    {
        System.out.println("removeBonus");
        Integer bonus1 = 2;
        Integer bonus2 = 4;
        Integer bonus3 = 1;
        MaximizedBonus instance = new MaximizedBonus();
        instance.addBonus(bonus1);
        instance.addBonus(bonus2);
        instance.addBonus(bonus3);
        assertEquals(instance.getBonus(), bonus2);
        instance.removeBonus(bonus2);
        assertEquals(instance.getBonus(), bonus1);
        instance.removeBonus(bonus1);
        assertEquals(instance.getBonus(), bonus3);
        instance.removeBonus(bonus2);
        assertEquals(instance.getBonus(), new Integer(0));
    }

}
