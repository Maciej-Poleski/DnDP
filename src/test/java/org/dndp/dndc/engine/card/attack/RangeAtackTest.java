/*
 * To change this template, choose Tools | Templates and open the template in the editor.
 */

package org.dndp.dndc.engine.card.attack;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.dndp.dndc.engine.Character;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * 
 * @author bambucha
 */
public class RangeAtackTest
{
    static Character main = new Character();
    static RangeAttack      dupa = new RangeAttack(main);

    public RangeAtackTest()
    {
        main.getStrenght().setValue(16);
        main.getDexterity().setValue(13);
    }

    @BeforeClass
    public static void setUpClass() throws Exception
    {}

    @AfterClass
    public static void tearDownClass() throws Exception
    {}

    @Test
    public void testCountAttacksModifier()
    {
        System.out.println("countAttacksModifier");
        RangeAttack instance = dupa;
        instance.countAttacksModifier();
        assertEquals(instance.atackModifier, new Integer(1));
    }

    @Test
    public void testGetAttacks()
    {
        System.out.println("getAttacks");
        RangeAttack instance = dupa;
        TotalBonusToAttack expResult = new TotalBonusToAttack(new Integer[] { 1 });
        TotalBonusToAttack result = instance.getAttacks();
        assertEquals(instance.atackModifier, new Integer(1));
        for (Integer x : result.getMainHand())
            System.out.print(x + " ");
        assertArrayEquals(expResult.getMainHand(), result.getMainHand());

    }

}
