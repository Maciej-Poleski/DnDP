package org.dndp.dndc.engine.card.attack;

import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Mockito.mock;

import org.junit.Before;
import org.junit.Test;

/**
 * 
 * @author bambucha
 */
public class TotalBonusToAttackTest
{
	TotalBonusToAttack	test;

	@Before
	public void setUp() throws Exception
	{
		BaseBonusToAttack base = mock(BaseBonusToAttack.class);
		OffhandBonusToAttack offhand = mock(OffhandBonusToAttack.class);
		BaseAttack attack = mock(BaseAttack.class);
		test = new TotalBonusToAttack(base, offhand, attack);
	}

	@Test
	public void getFirst() throws Exception
	{
		assertThat(test.first()).isNotNull();
	}

	@Test
	public void getSecond()
	{
		assertThat(test.second()).isNotNull();
	}

	@Test
	public void getFourth()
	{
		assertThat(test.second()).isNotNull();
	}

	@Test
	public void getThird() throws Exception
	{
		assertThat(test.second()).isNotNull();
	}

	@Test
	public void getFirstOffhand() throws Exception
	{
		assertThat(test.firstOffhand()).isNotNull();
	}

	@Test
	public void getSecondOffhand() throws Exception
	{
		assertThat(test.secondOffhand()).isNotNull();
	}

	@Test
	public void getThridOffhand() throws Exception
	{
		assertThat(test.thridOffhand()).isNotNull();
	}

	@Test
	public void setNegativeForAttacks() throws Exception
	{
		switch(test.getNumberOfAttacks())
		{
			case 4:
				test.setFourth(-2);
				assertThat(test.fourth()).isEqualTo(-2);
			case 3:
				test.setThird(-2);
				assertThat(test.third()).isEqualTo(-2);
			case 2:
				test.setSecond(-2);
				assertThat(test.second()).isEqualTo(-2);
			case 1:
				test.setFirst(-2);
				assertThat(test.first()).isEqualTo(-2);
		}
	}

	@Test
	public void getNumberOfOffhandsAttacks() throws Exception
	{
		assertThat(test.getNumberOffhandAttacks()).isGreaterThanOrEqualTo(0);
	}

	@Test
	public void offhandIsIterable() throws Exception
	{
		for(int a : test.getOffhand())
			assertThat(a).isNotNull();
	}
}
