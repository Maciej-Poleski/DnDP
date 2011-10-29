/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */

package org.dndp.dndc.engine.card.st;

import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Matchers.eq;
import static org.mockito.Matchers.notNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

import java.util.Observer;

import org.dndp.dndc.engine.card.bonus.BonusManager;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 * @author bambucha
 */
public class DnDSavingThrowsTest
{
	DnDSavingThrows	saving;

	@Before
	public void setUp()
	{
		BonusManager bonus = mock(BonusManager.class);
		saving = new DnDSavingThrows(bonus);
	}

	@Test
	public void testName() throws Exception
	{
		assertThat(saving.getForttiude()).isNotNull();
	}

	@Test
	public void testGetReflex()
	{
		assertThat(saving.getReflex()).isNotNull();
	}

	@Test
	public void testGetWill()
	{
		assertThat(saving.getWill()).isNotNull();
	}

	@Test
	public void testGetSpellResistance()
	{
		assertThat(saving.getSpellResistance()).isEqualTo(0.0);
	}

	@Test
	public void testSetSpellResistance()
	{
		double value = 5.0;
		saving.setSpellResistance(value);
		assertThat(saving.getSpellResistance()).isEqualTo(value);
	}

	@Test(expected = IllegalArgumentException.class)
	public void setNegativeForSpelResistance() throws Exception
	{
		saving.setSpellResistance(-1.0);
	}

	@Test
	public void setSpellResistanceDontMakeNotification() throws Exception
	{
		// given
		double value = 4.0;
		saving.setSpellResistance(value);
		Observer tester = mock(Observer.class);
		saving.addObserver(tester);
		// when
		saving.setSpellResistance(value);
		// then
		verify(tester, never()).update(eq(saving), notNull());
	}
}
