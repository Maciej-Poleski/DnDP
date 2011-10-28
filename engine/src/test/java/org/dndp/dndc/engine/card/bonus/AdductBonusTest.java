package org.dndp.dndc.engine.card.bonus;

import static org.fest.assertions.Assertions.*;

import org.junit.Before;
import org.junit.Test;

/**
 * 
 * @author bambucha
 */
public class AdductBonusTest
{
	private AdductBonus	adductBonus;

	public AdductBonusTest()
	{

	}

	@Before
	public void before()
	{
		adductBonus = new AdductBonus();
	}

	@Test
	public void testAddBonus()
	{
		adductBonus.addBonus(6);
		assertThat(adductBonus.getBonus()).isEqualTo(6);
		adductBonus.addBonus(3);
		assertThat(adductBonus.getBonus()).isEqualTo(9);
		adductBonus.addBonus(11);
		assertThat(adductBonus.getBonus()).isEqualTo(20);
	}

	@Test
	public void testDoubleSameBonus()
	{
		adductBonus.addBonus(6);
		assertThat(adductBonus.getBonus()).isEqualTo(6);
		adductBonus.addBonus(6);
		assertThat(adductBonus.getBonus()).isEqualTo(12);
	}

	@Test
	public void testRemoveBonus()
	{
		adductBonus.addBonus(2);
		adductBonus.addBonus(4);
		adductBonus.addBonus(1);
		assertThat(adductBonus.getBonus()).isEqualTo(7);
		adductBonus.removeBonus(2);
		assertThat(adductBonus.getBonus()).isEqualTo(5);
		adductBonus.removeBonus(4);
		assertThat(adductBonus.getBonus()).isEqualTo(1);
		adductBonus.addBonus(1);
		assertThat(adductBonus.getBonus()).isEqualTo(2);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testRemoveBonusException()
	{
		adductBonus.addBonus(2);
		adductBonus.addBonus(4);
		adductBonus.addBonus(1);
		assertThat(adductBonus.getBonus()).isEqualTo(7);
		adductBonus.removeBonus(2);
		assertThat(adductBonus.getBonus()).isEqualTo(5);
		adductBonus.removeBonus(2);
	}
}
