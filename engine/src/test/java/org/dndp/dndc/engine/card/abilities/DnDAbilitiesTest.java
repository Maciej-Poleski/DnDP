/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */

package org.dndp.dndc.engine.card.abilities;

import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Mockito.mock;

import org.dndp.dndc.engine.card.bonus.BonusManager;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 * @author bambucha
 */
public class DnDAbilitiesTest
{
	Abilities	abilities;

	@Before
	public void setUpClass() throws Exception
	{
		BonusManager bonusManager = mock(BonusManager.class);
		abilities = new DnDAbilities(bonusManager);
	}

	/**
	 * Test of getStrenght method, of class DnDAbilities.
	 */
	@Test
	public void testGetStrenght()
	{
		assertThat(abilities.getStrenght()).isNotNull();
	}

	/**
	 * Test of getDexterity method, of class DnDAbilities.
	 */
	@Test
	public void testGetDexterity()
	{
		assertThat(abilities.getDexterity()).isNotNull();
	}

	/**
	 * Test of getConstitution method, of class DnDAbilities.
	 */
	@Test
	public void testGetConstitution()
	{
		assertThat(abilities.getConstitution()).isNotNull();
	}

	/**
	 * Test of getInteligence method, of class DnDAbilities.
	 */
	@Test
	public void testGetInteligence()
	{
		assertThat(abilities.getInteligence()).isNotNull();
	}

	/**
	 * Test of getWisdom method, of class DnDAbilities.
	 */
	@Test
	public void testGetWisdom()
	{
		assertThat(abilities.getWisdom()).isNotNull();
	}

	/**
	 * Test of getCharisma method, of class DnDAbilities.
	 */
	@Test
	public void testGetCharisma()
	{
		assertThat(abilities.getCharisma()).isNotNull();
	}

}
