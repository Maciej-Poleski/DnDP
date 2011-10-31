package org.dndp.dndc.engine.card.attack;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

public class OffhandBonusToAttackTest
{
	OffhandBonusToAttack	test;

	@Before
	public void setUp() throws Exception
	{
		test = new OffhandBonusToAttack(1, 2, 3);
	}

	@Test
	public void construction() throws Exception
	{
		test = new OffhandBonusToAttack(1);
		test = new OffhandBonusToAttack(1, 2);
		test = new OffhandBonusToAttack(1, 2, 3);
	}

	@Test
	public void first() throws Exception
	{
		assertThat(test.first()).isNotNull();
	}

	@Test
	public void second() throws Exception
	{
		assertThat(test.second()).isNotNull();
	}

	@Test
	public void third() throws Exception
	{
		assertThat(test.third()).isNotNull();
	}
}
