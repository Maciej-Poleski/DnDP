/*
 * To change this template, choose Tools | Templates and open the template in the editor.
 */

package org.dndp.dndc.engine.card.attack;

import static org.junit.Assert.assertArrayEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * 
 * @author bambucha
 */
public class BaseBonusToAtackTest
{
    Integer[] main       = new Integer[] { 10, 5, 0 };
    Integer[] off        = new Integer[] { 2 };
    Integer[] fail       = new Integer[] { -6, -4, -2 };
    Integer[] zero       = new Integer[] { 0 };
    Integer[] Null       = null;
    Integer[] OutOfRange = new Integer[] { 1, 12, 3, 4, 5, 1, 2, 4 };

    public BaseBonusToAtackTest()
    {}

    @BeforeClass
    public static void setUpClass() throws Exception
    {}

    @AfterClass
    public static void tearDownClass() throws Exception
    {}

    @Test
    public void testGetBonus()
    {
        System.out.println("getBonus");
        BaseBonusToAttack instance = new BaseBonusToAttack(main);
        Integer[] expResult = main;
        Integer[] result = instance.getBonus();
        assertArrayEquals(expResult, result);
    }

    @Test
    public void testSetBonus()
    {
        System.out.println("setBonus");
        Integer[] bonus = off;
        BaseBonusToAttack instance = new BaseBonusToAttack(main);
        instance.setBonus(bonus);
        assertArrayEquals(instance.getBonus(), bonus);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetBonusException()
    {
        System.out.println("setBonus exceptrion");
        Integer[] bonus = fail;
        BaseBonusToAttack instance = new BaseBonusToAttack(main);
        instance.setBonus(bonus);
        instance.setBonus(bonus);
        assertArrayEquals(instance.getBonus(), bonus);
    }

    @Test(expected = NullPointerException.class)
    public void testSetBonusToNull()
    {
        System.out.println("setBonus to null");
        Integer[] bonus = Null;
        BaseBonusToAttack instance = new BaseBonusToAttack(main);
        instance.setBonus(bonus);
        assertArrayEquals(instance.getBonus(), bonus);
    }

    @Test
    public void testSetBonusToZero()
    {
        System.out.println("setBonus to zero");
        Integer[] bonus = zero;
        BaseBonusToAttack instance = new BaseBonusToAttack(main);
        instance.setBonus(bonus);
        assertArrayEquals(instance.getBonus(), bonus);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetBonusToOutOfRange()
    {
        System.out.println("setBonus out of range");
        Integer[] bonus = OutOfRange;
        BaseBonusToAttack instance = new BaseBonusToAttack(main);
        instance.setBonus(bonus);
        assertArrayEquals(instance.getBonus(), bonus);
    }
}
