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
public class GrappleAtackTest
{
	GrappleAttack	test;

	@Before
	public void setUp() throws Exception
	{
		Attack attack = mock(Attack.class);
		test = new GrappleAttack(attack);
	}

	@Test
	public void GrappleAttakUseStrenght() throws Exception
	{
		assertThat(test.getAbilityName()).isEqualTo(AbilityType.STRENGHT);
	}
}
