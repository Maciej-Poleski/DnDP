/*
 * To change this template, choose Tools | Templates and open the template in the editor.
 */

package org.dndp.dndc.engine.card.attack;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.dndp.dndc.engine.Character;
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
    static Character t    = new Character();
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
        assertArrayEquals(new Integer[] { 5 }, result.getAttacks().getMainHand());

    }

    @Test
    public void testGetRangeAttack()
    {
        System.out.println("getRangeAttack");
        DnDAttack instance = dupa;
        BaseAttack result = instance.getRangeAttack();
        assertArrayEquals(new Integer[] { 2 }, result.getAttacks().getMainHand());
    }

    @Test
    public void testGetGrappleAttack()
    {
        System.out.println("getGrappleAttack");
        DnDAttack instance = dupa;
        BaseAttack result = instance.getGrappleAttack();
        assertArrayEquals(new Integer[] { 10 }, result.getAttacks().getMainHand());
    }

    @Test
    public void testGetInitiativeModifier()
    {
        System.out.println("getInitiativeModifier");
        DnDAttack instance = dupa;
        Integer expResult = t.getDexterity().getModifier();
        Integer result = instance.getInitiativeModifier();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetInitiativeModifier()
    {
        System.out.println("setInitiativeModifier");
        Integer newValue = 2;
        DnDAttack instance = dupa;
        instance.setInitiativeModifier(newValue);
        assertTrue(newValue + t.getDexterity().getModifier() == instance.getInitiativeModifier());
    }

    @Test(expected = NullPointerException.class)
    public void testSetInitiativeModifierNull()
    {
        System.out.println("setInitiativeModifier null");
        Integer newValue = null;
        DnDAttack instance = dupa;
        instance.setInitiativeModifier(newValue);
    }

    @Test
    public void testGetSpeed()
    {
        System.out.println("getSpeed");
        DnDAttack instance = dupa;
        Double expResult = 9D;
        Double result = instance.getSpeed();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetSpeed()
    {
        System.out.println("setSpeed");
        Double newValue = 6D;
        DnDAttack instance = dupa;
        instance.setSpeed(newValue);
        assertEquals(newValue, instance.getSpeed());
    }

    @Test(expected = NullPointerException.class)
    public void testSetSpeedNull()
    {
        System.out.println("setSpeed");
        Double newValue = null;
        DnDAttack instance = dupa;
        instance.setSpeed(newValue);
        assertEquals(newValue, instance.getSpeed());
    }

    @Test
    public void testGetBaseAttack()
    {
        System.out.println("getBaseAttack");
        DnDAttack instance = dupa;
        BaseBonusToAttack expResult = new BaseBonusToAttack(new Integer[] { 0 });
        BaseBonusToAttack result = instance.getBaseAttack();
        assertArrayEquals(expResult.getBonus(), result.getBonus());

    }

    @Test
    public void testSetBaseAttack()
    {
        System.out.println("setBaseAttack");
        BaseBonusToAttack baseAtack = new BaseBonusToAttack(new Integer[] { 6, 1 });
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
