/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */

package org.dndp.dndc.engine.card.attack;

import static org.fest.assertions.Assertions.*;
import static org.mockito.Mockito.*;

import org.dndp.dndc.engine.card.bonus.BonusManager;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 * @author bambucha
 */
public class DnDAttackTest
{
	private DnDAttack	test;

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
		assertThat(test.getMeleeAttack()).isNotNull();
	}

	@Test
	public void testGetRangeAttack()
	{
		throw new RuntimeException("Not implemented yet!");
	}

	@Test
	public void testGetGrappleAttack()
	{
		throw new RuntimeException("Not implemented yet!");
	}

	@Test
	public void testGetInitiativeModifier()
	{
		throw new RuntimeException("Not implemented yet!");
	}

	@Test
	public void testSetInitiativeModifier()
	{
		throw new RuntimeException("Not implemented yet!");
	}

	@Test
	public void testGetSpeed()
	{
		throw new RuntimeException("Not implemented yet!");
	}

	@Test
	public void testSetSpeed()
	{
		throw new RuntimeException("Not implemented yet!");
	}

	@Test
	public void testGetBaseAttack()
	{
		throw new RuntimeException("Not implemented yet!");
	}

	@Test
	public void testSetBaseAttack()
	{
		throw new RuntimeException("Not implemented yet!");
	}

	@Test(expected = NullPointerException.class)
	public void testSetBaseAttackNull()
	{
		throw new RuntimeException("Not implemented yet!");
	}

}
