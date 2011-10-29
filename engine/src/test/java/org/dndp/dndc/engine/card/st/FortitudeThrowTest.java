/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */

package org.dndp.dndc.engine.card.st;

import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Matchers.eq;
import static org.mockito.Matchers.notNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

import java.util.Observer;

import org.dndp.dndc.engine.card.abilities.AbilityType;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 * @author bambucha
 */
public class FortitudeThrowTest
{

	FortitudeThrow	test;

	@Before
	public void before()
	{
		test = new FortitudeThrow();
	}

	@Test
	public void foritudeUseStrenghtForBonus() throws Exception
	{
		assertThat(test.getAbilityName()).isEqualTo(AbilityType.STRENGHT);
	}

	@Test
	public void throwTest() throws Exception
	{
		for(int q = 0; q < 20; q++)
			assertThat(test.getThrow()).isGreaterThan(-1).isLessThan(21);
	}

	@Test
	public void getBaseModifier() throws Exception
	{
		assertThat(test.getBaseModifier()).isNotNull().isGreaterThan(-1);
	}

	@Test
	public void getTotalModifierIsSumOfBaseAndBonus() throws Exception
	{
		assertThat(test.getTotalModifier()).isEqualTo(
				test.getBaseModifier() + test.getBonus());
	}

	@Test
	public void testSetBaseBonus() throws Exception
	{
		test.setBaseModifier(2);
		// then
		assertThat(test.getBaseModifier()).isEqualTo(2);
	}

	@Test(expected = IllegalArgumentException.class)
	public void negativeForBaseBonus() throws Exception
	{
		test.setBaseModifier(-2);
	}

	@Test
	public void setSecondTimeBaseModifierDontMakeNotification()
			throws Exception
	{
		// given
		int value = 5;
		test.setBaseModifier(value);
		Observer tester = mock(Observer.class);
		test.addObserver(tester);
		// when
		test.setBaseModifier(value);
		// then
		verify(tester, never()).update(eq(test), notNull());
	}

}
