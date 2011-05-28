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
    Integer[] main       = new Integer[] { 10, 5, 0 };
    Integer[] off        = new Integer[] { 2 };
    Integer[] fail       = new Integer[] { -6, -4, -2 };
    Integer[] zero       = new Integer[] { 0 };
    Integer[] Null       = null;
    Integer[] OutOfRange = new Integer[] { 1, 12, 3, 4, 5, 1, 2, 4 };

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
        Integer[] expResult = main;
        Integer[] result = instance.getMainHand();
        assertArrayEquals(expResult, result);

    }
}
