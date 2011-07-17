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
public class TotalBonusToAtackTest
{
    int[] main       = new int[] { 10, 5, 0 };
    int[] off        = new int[] { 2 };
    int[] fail       = new int[] { -6, -4, -2 };
    int[] zero       = new int[] { 0 };
    int[] Null       = null;
    int[] OutOfRange = new int[] { 1, 12, 3, 4, 5, 1, 2, 4 };

    public TotalBonusToAtackTest()
    {}

    @BeforeClass
    public static void setUpClass() throws Exception
    {}

    @AfterClass
    public static void tearDownClass() throws Exception
    {}

    @Test(expected = IllegalArgumentException.class)
    public void testInitExceptrionSizeMain()
    {
        System.out.println("init for array out of range in mainheand");
        new TotalBonusToAttack(OutOfRange);
    }

    @Test(expected = NullPointerException.class)
    public void testInitExceptrionNullMain()
    {
        System.out.println("init for null pointer in mainheand");
        new TotalBonusToAttack(null);
    }

    @Test
    public void testGetMainHand()
    {
        System.out.println("getMainHand");
        TotalBonusToAttack instance = new TotalBonusToAttack(main);
        int[] expResult = main;
        int[] result = instance.getMainHand();
        assertArrayEquals(expResult, result);

    }
}
