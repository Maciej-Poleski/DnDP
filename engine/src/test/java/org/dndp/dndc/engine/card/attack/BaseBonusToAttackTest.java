/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */

package org.dndp.dndc.engine.card.attack;

import static org.fest.assertions.Assertions.*;
import static org.junit.Assert.assertArrayEquals;
import static org.mockito.Mockito.*;

import java.util.Observer;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * 
 * @author bambucha
 */
public class BaseBonusToAttackTest
{
	BaseBonusToAttack	test;

	@Before
	public void setUp() throws Exception
	{
		test = new BaseBonusToAttack(1, 1, 1, 1);
	}

	private Observer getObserver()
	{
		Observer observer = mock(Observer.class);
		test.addObserver(observer);
		return observer;
	}

	@Test
	public void constructorWithForeField() throws Exception
	{
		new BaseBonusToAttack(1, 1, 1, 1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void firstNegativeInConstrucktorIsIncoreect() throws Exception
	{
		new BaseBonusToAttack(-1, 1, 1, 1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void secondNegativeInConstrucktorIsIncoreect() throws Exception
	{
		new BaseBonusToAttack(1, -1, 1, 1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void thirdNegativeInConstrucktorIsIncoreect() throws Exception
	{
		new BaseBonusToAttack(1, 1, -1, 1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void furethNegativeInConstrucktorIsIncoreect() throws Exception
	{
		new BaseBonusToAttack(1, 1, 1, -1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void negativeOneAttackInConstructorIsIncorrect() throws Exception
	{
		new BaseBonusToAttack(-1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void negativeTwoAttackInConstructorIsIncorrect() throws Exception
	{
		new BaseBonusToAttack(-1, -1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void negativeThreeAttackInConstructorIsIncorrect() throws Exception
	{
		new BaseBonusToAttack(-1, -1, -1);
	}

	@Test
	public void getFirst() throws Exception
	{
		assertThat(test.first()).isNotNull().isPositive();
	}

	@Test
	public void getSecond() throws Exception
	{
		assertThat(test.second()).isNotNull().isPositive();
	}

	@Test
	public void getThird() throws Exception
	{
		assertThat(test.third()).isNotNull().isPositive();
	}

	@Test
	public void getFourth() throws Exception
	{
		assertThat(test.fourth()).isNotNull().isPositive();
	}

	@Test
	public void hasIterable() throws Exception
	{
		for(int a : test)
			assertThat(a).isPositive();
	}

	@Test
	public void setFirst() throws Exception
	{
		int value = 5;
		test.setFirst(value);
		assertThat(test.first()).isEqualTo(value);
	}

	@Test(expected = IllegalArgumentException.class)
	public void firtMustBePositive() throws Exception
	{
		test.setFirst(-2);
	}

	@Test
	public void secondSetSameFirstMustDontMakeNotification() throws Exception
	{
		// given
		test.setFirst(2);
		Observer tester = getObserver();
		// when
		test.setFirst(2);
		// then
		verify(tester, never()).update(eq(test), notNull());
	}

	@Test
	public void setSecond() throws Exception
	{
		int value = 5;
		test.setSecond(value);
		assertThat(test.second()).isEqualTo(value);
	}

	@Test(expected = IllegalArgumentException.class)
	public void secondMustBePositive() throws Exception
	{
		test.setSecond(-2);
	}

	@Test
	public void secondSetSameSecondMustDontMakeNotification() throws Exception
	{
		// given
		test.setSecond(2);
		Observer tester = getObserver();
		// when
		test.setSecond(2);
		// then
		verify(tester, never()).update(eq(test), notNull());
	}

	@Test
	public void setfourth() throws Exception
	{
		int value = 5;
		test.setFourth(value);
		assertThat(test.fourth()).isEqualTo(value);
	}

	@Test(expected = IllegalArgumentException.class)
	public void fourthMustBePositive() throws Exception
	{
		test.setFourth(-2);
	}

	@Test
	public void fourthSetSameFourthMustDontMakeNotification() throws Exception
	{
		// given
		test.setFourth(2);
		Observer tester = getObserver();
		// when
		test.setFourth(2);
		// then
		verify(tester, never()).update(eq(test), notNull());
	}
}
