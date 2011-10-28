package org.dndp.dndc.engine.card.abilities;

import static org.fest.assertions.Assertions.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Test klasy przechowującej umiejętności.
 * 
 * @author bambucha
 */
public class AbilitiTest
{
	private Abiliti	abiliti;

	@Before
	public void before()
	{
		abiliti = new Abiliti();
	}

	@Test
	public void testGetModifier()
	{
		assertThat(abiliti.getModifier()).isEqualTo(0);
	}

	@Test
	public void testGetValue()
	{
		assertThat(abiliti.getValue()).isEqualTo(10);
	}

	@Test
	public void testSetValue() throws Exception
	{
		abiliti.setValue(12);
		assertThat(abiliti.getValue()).isEqualTo(12);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetValueException() throws Exception
	{
		abiliti.setValue(-12);
	}

	@Test
	public void testSetAndGetValue() throws Exception
	{
		abiliti.setValue(14);
		assertThat(abiliti.getModifier()).isEqualTo(2);
	}

	@Test
	public void testSetBonus()
	{
		abiliti.setBonus(4);
		assertThat(abiliti.getModifier()).isEqualTo(
				(abiliti.getValue() - 10) / 2);
	}

}
