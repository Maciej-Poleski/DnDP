/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */

package org.dndp.dndc.engine.card.attack;

import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Mockito.mock;

import org.dndp.dndc.engine.card.abilities.AbilityType;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 * @author bambucha
 */
public class RangeAtackTest
{

	Attack		attack;
	RangeAttack	test;

	@Before
	public void setUpClass() throws Exception
	{
		attack = mock(Attack.class);
		test = new RangeAttack(attack);
	}

	@Test
	public void testName() throws Exception
	{
		assertThat(test.getAbilityName()).isEqualTo(AbilityType.DEXTERITY);
	}

}
