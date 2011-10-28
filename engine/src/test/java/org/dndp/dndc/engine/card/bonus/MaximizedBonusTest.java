/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */

package org.dndp.dndc.engine.card.bonus;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

/**
 * 
 * @author bambucha
 */
public class MaximizedBonusTest
{

	MaximizedBonus	maximizedBonus;

	@Before
	public void setUpClass() throws Exception
	{
		maximizedBonus = new MaximizedBonus();
	}

	@Test
	public void testAddBonus()
	{
		maximizedBonus.addBonus(2);
		assertThat(maximizedBonus.getBonus()).isEqualTo(2);
		maximizedBonus.addBonus(4);
		assertThat(maximizedBonus.getBonus()).isEqualTo(4);
		maximizedBonus.addBonus(1);
		assertThat(maximizedBonus.getBonus()).isEqualTo(4);
	}

	@Test
	public void testPenty()
	{
		maximizedBonus.addBonus(-2);
		assertThat(maximizedBonus.getBonus()).isEqualTo(-2);
	}

	@Test
	public void testAddAndRemoveMany()
	{
		maximizedBonus.addBonus(2);
		maximizedBonus.addBonus(2);
		maximizedBonus.addBonus(2);
		maximizedBonus.addBonus(2);
		assertThat(maximizedBonus.getBonus()).isEqualTo(2);
		maximizedBonus.removeBonus(2);
		maximizedBonus.removeBonus(2);
		maximizedBonus.removeBonus(2);
		assertThat(maximizedBonus.getBonus()).isEqualTo(0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testAddAnnyEqualAndRemoveTooMany()
	{
		maximizedBonus.addBonus(2);
		maximizedBonus.addBonus(2);
		maximizedBonus.addBonus(2);
		maximizedBonus.addBonus(2);
		maximizedBonus.removeBonus(2);
		maximizedBonus.removeBonus(2);
		maximizedBonus.removeBonus(2);
		maximizedBonus.removeBonus(2);
	}

	@Test
	public void testRemoveBonus()
	{
		maximizedBonus.addBonus(2);
		maximizedBonus.addBonus(4);
		maximizedBonus.addBonus(1);
		assertThat(maximizedBonus.getBonus()).isEqualTo(4);
		maximizedBonus.removeBonus(4);
		assertThat(maximizedBonus.getBonus()).isEqualTo(2);
		maximizedBonus.removeBonus(2);
		assertThat(maximizedBonus.getBonus()).isEqualTo(1);
		maximizedBonus.removeBonus(1);
		assertThat(maximizedBonus.getBonus()).isEqualTo(0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testRemoveBonusException()
	{

		maximizedBonus.addBonus(2);
		maximizedBonus.addBonus(4);
		maximizedBonus.addBonus(1);
		assertThat(maximizedBonus.getBonus()).isEqualTo(4);
		maximizedBonus.removeBonus(4);
		assertThat(maximizedBonus.getBonus()).isEqualTo(2);
		maximizedBonus.removeBonus(4);
		assertThat(maximizedBonus.getBonus()).isEqualTo(1);
		maximizedBonus.removeBonus(1);
		assertThat(maximizedBonus.getBonus()).isEqualTo(0);
	}

}
