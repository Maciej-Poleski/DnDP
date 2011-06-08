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
public class GrappleAtackTest
{
    static Character main = new Character();
    static GrappleAttack    dupa = new GrappleAttack(main);

    public GrappleAtackTest()
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
        GrappleAttack instance = dupa;
        assertEquals(3,instance.countAttacksModifier());
    }

    @Test
    public void testGetAttacks()
    {
        System.out.println("getAttacks");
        BaseAttack instance = dupa;
        TotalBonusToAttack expResult = new TotalBonusToAttack(new int[] { 3 });
        TotalBonusToAttack result = instance.getAttacks();
        assertEquals(instance.countAttacksModifier(), 3);
        assertArrayEquals(result.getMainHand(),expResult.getMainHand());
    }

}
