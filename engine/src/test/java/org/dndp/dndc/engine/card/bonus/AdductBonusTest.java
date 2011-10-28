package org.dndp.dndc.engine.card.bonus;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

/**
 * 
 * @author bambucha
 */
public class AdductBonusTest
{
	private AdductBonus	adductBonus;

	@Before
	public void before()
	{
		adductBonus = new AdductBonus();
	}

	@Test
	public void AddBonus()
	{
		adductBonus.addBonus(6);
		assertThat(adductBonus.getBonus()).isEqualTo(6);
		adductBonus.addBonus(3);
		assertThat(adductBonus.getBonus()).isEqualTo(9);
		adductBonus.addBonus(11);
		assertThat(adductBonus.getBonus()).isEqualTo(20);
	}

	@Test
	public void AddManyBonus()
	{
		adductBonus.addBonus(6);
		adductBonus.addBonus(3);
		adductBonus.addBonus(11);
		assertThat(adductBonus.getBonus()).isEqualTo(20);
	}

	@Test
	public void DoubleSameBonus()
	{
		adductBonus.addBonus(6);
		adductBonus.addBonus(6);
		assertThat(adductBonus.getBonus()).isEqualTo(12);
	}

	@Test
	public void AddDobuleSameAndRemoveIt()
	{
		adductBonus.addBonus(6);
		adductBonus.addBonus(6);
		adductBonus.removeBonus(6);
		adductBonus.removeBonus(6);
		assertThat(adductBonus.getBonus()).isEqualTo(0);
	}

	@Test
	public void RemoveBonus()
	{
		adductBonus.addBonus(2);
		adductBonus.removeBonus(2);
		assertThat(adductBonus.getBonus()).isEqualTo(0);
	}

	@Test
	public void RemoveManyBonus()
	{
		adductBonus.addBonus(2);
		adductBonus.addBonus(4);
		adductBonus.addBonus(1);
		adductBonus.removeBonus(2);
		adductBonus.removeBonus(4);
		assertThat(adductBonus.getBonus()).isEqualTo(1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void RemoveBonusException()
	{
		adductBonus.addBonus(2);
		adductBonus.addBonus(4);
		adductBonus.addBonus(1);
		adductBonus.removeBonus(2);
		adductBonus.removeBonus(2);
	}
}
