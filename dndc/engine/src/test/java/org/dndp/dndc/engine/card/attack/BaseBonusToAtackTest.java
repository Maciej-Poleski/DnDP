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
    int[] main       = new int[] { 10, 5, 0 };
    int[] off        = new int[] { 2 };
    int[] fail       = new int[] { -6, -4, -2 };
    int[] zero       = new int[] { 0 };
    int[] Null       = null;
    int[] OutOfRange = new int[] { 1, 12, 3, 4, 5, 1, 2, 4 };

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
        int[] expResult = main;
        int[] result = instance.getBonus();
        assertArrayEquals(expResult, result);
    }

    @Test
    public void testSetBonus()
    {
        System.out.println("setBonus");
        int[] bonus = off;
        BaseBonusToAttack instance = new BaseBonusToAttack(main);
        instance.setBonus(bonus);
        assertArrayEquals(instance.getBonus(), bonus);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetBonusException()
    {
        System.out.println("setBonus exceptrion");
        int[] bonus = fail;
        BaseBonusToAttack instance = new BaseBonusToAttack(main);
        instance.setBonus(bonus);
        instance.setBonus(bonus);
        assertArrayEquals(instance.getBonus(), bonus);
    }

    @Test(expected = NullPointerException.class)
    public void testSetBonusToNull()
    {
        System.out.println("setBonus to null");
        int[] bonus = Null;
        BaseBonusToAttack instance = new BaseBonusToAttack(main);
        instance.setBonus(bonus);
        assertArrayEquals(instance.getBonus(), bonus);
    }

    @Test
    public void testSetBonusToZero()
    {
        System.out.println("setBonus to zero");
        int[] bonus = zero;
        BaseBonusToAttack instance = new BaseBonusToAttack(main);
        instance.setBonus(bonus);
        assertArrayEquals(instance.getBonus(), bonus);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetBonusToOutOfRange()
    {
        System.out.println("setBonus out of range");
        int[] bonus = OutOfRange;
        BaseBonusToAttack instance = new BaseBonusToAttack(main);
        instance.setBonus(bonus);
        assertArrayEquals(instance.getBonus(), bonus);
    }
}
