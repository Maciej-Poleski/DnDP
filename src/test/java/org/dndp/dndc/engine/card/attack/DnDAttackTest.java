/*
 * To change this template, choose Tools | Templates and open the template in the editor.
 */

package org.dndp.dndc.engine.card.attack;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.dndp.dndc.engine.FantasyCharacter;
import org.dndp.dndc.engine.card.description.Size;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;



/**
 * 
 * @author bambucha
 */
public class DnDAttackTest
{
    static FantasyCharacter t    = new FantasyCharacter();
    static DnDAttack        dupa = new DnDAttack(t);

    public DnDAttackTest()
    {
        t.getStrenght().setValue(22);
        t.getDexterity().setValue(16);
        t.setSize(Size.LARGE);
    }

    @BeforeClass
    public static void setUpClass() throws Exception
    {}

    @AfterClass
    public static void tearDownClass() throws Exception
    {}

    @Test
    public void testGetMeleeAttack()
    {
        System.out.println("getMeleeAttack");
        DnDAttack instance = dupa;
        BaseAttack result = instance.getMeleeAttack();
        assertArrayEquals(new int[] { 5 }, result.getAttacks().getMainHand());

    }

    @Test
    public void testGetRangeAttack()
    {
        System.out.println("getRangeAttack");
        DnDAttack instance = dupa;
        BaseAttack result = instance.getRangeAttack();
        assertArrayEquals(new int[] { 2 }, result.getAttacks().getMainHand());
    }

    @Test
    public void testGetGrappleAttack()
    {
        System.out.println("getGrappleAttack");
        DnDAttack instance = dupa;
        BaseAttack result = instance.getGrappleAttack();
        assertArrayEquals(new int[] { 10 }, result.getAttacks().getMainHand());
    }

    @Test
    public void testGetInitiativeModifier()
    {
        System.out.println("getInitiativeModifier");
        DnDAttack instance = dupa;
        int expResult = t.getDexterity().getModifier();
        int result = instance.getInitiativeModifier();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetInitiativeModifier()
    {
        System.out.println("setInitiativeModifier");
        int newValue = 2;
        DnDAttack instance = dupa;
        instance.setInitiativeModifier(newValue);
        assertTrue(newValue + t.getDexterity().getModifier() == instance.getInitiativeModifier());
    }

    @Test
    public void testGetSpeed()
    {
        System.out.println("getSpeed");
        DnDAttack instance = dupa;
        double expResult = 9D;
        double result = instance.getSpeed();
        assertEquals(expResult, result,0.01);
    }

    @Test
    public void testSetSpeed()
    {
        System.out.println("setSpeed");
        double newValue = 6D;
        DnDAttack instance = dupa;
        instance.setSpeed(newValue);
        assertEquals(newValue, instance.getSpeed(),0.01);
    }

    @Test
    public void testGetBaseAttack()
    {
        System.out.println("getBaseAttack");
        DnDAttack instance = dupa;
        BaseBonusToAttack expResult = new BaseBonusToAttack(new int[] { 0 });
        BaseBonusToAttack result = instance.getBaseAttack();
        assertArrayEquals(expResult.getBonus(), result.getBonus());

    }

    @Test
    public void testSetBaseAttack()
    {
        System.out.println("setBaseAttack");
        BaseBonusToAttack baseAtack = new BaseBonusToAttack(new int[] { 6, 1 });
        DnDAttack instance = dupa;
        instance.setBaseAttack(baseAtack);

    }

    @Test(expected = NullPointerException.class)
    public void testSetBaseAttackNull()
    {
        System.out.println("setBaseAttack null");
        BaseBonusToAttack baseAtack = null;
        DnDAttack instance = dupa;
        instance.setBaseAttack(baseAtack);
    }

}
