/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */

package org.dndp.dndc.engine.card.st;

import static org.fest.assertions.Assertions.assertThat;

import org.dndp.dndc.engine.card.abilities.AbilityType;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 * @author bambucha
 */
public class WillThrowTest
{

	WillThrow	test;

	@Before
	public void before()
	{
		test = new WillThrow();
	}

	@Test
	public void willUseWisdomModifier() throws Exception
	{
		assertThat(test.getAbilityName()).isEqualTo(AbilityType.WISDOM);
	}
}
