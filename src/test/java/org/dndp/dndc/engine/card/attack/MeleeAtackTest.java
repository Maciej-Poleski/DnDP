/*
 * To change this template, choose Tools | Templates and open the template in the editor.
 */

package org.dndp.dndc.engine.card.attack;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import org.dndp.dndc.engine.Character;

/**
 * 
 * @author bambucha
 */
public class MeleeAtackTest
{
    static Character main = new Character();
    static MeleeAttack      dupa = new MeleeAttack(main);

    public MeleeAtackTest()
    {
        main.getStrenght().setValue(16);
        main.getDexterity().setValue(13);
    }

    @BeforeClass
    public static void setUpClass() throws Exception
    {}

    @AfterClass
    public static void tearDownClass() throws Exception
    {

    }

    @Test
    public void testCountAttacksModifier()
    {
        System.out.println("countAttacksModifier");
        MeleeAttack instance = dupa;
        instance.countAttacksModifier();
        assertEquals(instance.atackModifier, new Integer(3));
    }

    @Test
    public void testGetAttacks()
    {
        System.out.println("getAttacks");
        BaseAttack instance = dupa;
        TotalBonusToAttack expResult = new TotalBonusToAttack(new Integer[] { 3 });
        TotalBonusToAttack result = instance.getAttacks();
        assertEquals(instance.atackModifier, new Integer(3));
        assertArrayEquals(expResult.getMainHand(), result.getMainHand());
    }

}
