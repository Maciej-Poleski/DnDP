/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */

package org.dndp.dndc.engine.card.attack;

import static org.fest.assertions.Assertions.*;
import static org.mockito.Mockito.*;

import org.dndp.dndc.engine.FantasyCharacter;
import org.dndp.dndc.engine.card.bonus.BonusManager;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 * @author bambucha
 */
public class DnDAttackTest
{
	private static DnDAttack	test;

	@Before
	public void setUp() throws Exception
	{
		BonusManager bonus = mock(BonusManager.class);
		test = new DnDAttack(bonus);
	}

	@Test
	public void testName() throws Exception
	{
		// given

		// when

		// then

		throw new RuntimeException("Not implemented yet!");

	}

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
		assertTrue(newValue + t.getDexterity().getModifier() == instance
				.getInitiativeModifier());
	}

	@Test
	public void testGetSpeed()
	{
		System.out.println("getSpeed");
		DnDAttack instance = dupa;
		double expResult = 9D;
		double result = instance.getSpeed();
		assertEquals(expResult, result, 0.01);
	}

	@Test
	public void testSetSpeed()
	{
		System.out.println("setSpeed");
		double newValue = 6D;
		DnDAttack instance = dupa;
		instance.setSpeed(newValue);
		assertEquals(newValue, instance.getSpeed(), 0.01);
	}

	@Test
	public void testGetBaseAttack()
	{
		System.out.println("getBaseAttack");
		DnDAttack instance = dupa;
		BaseBonusToAttack expResult = new BaseBonusToAttack().setFirst(0);
		BaseBonusToAttack result = instance.getBaseAttack();
		assertThat(expResult.compareTo(result)==0);

	}

	@Test
	public void testSetBaseAttack()
	{
		System.out.println("setBaseAttack");
		BaseBonusToAttack baseAtack = new BaseBonusToAttack().setFirst(6).setSecond(1);
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
