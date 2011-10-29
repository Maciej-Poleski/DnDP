package org.dndp.dndc.engine.card.bonus;

import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.util.MissingResourceException;

import org.dndp.dndc.engine.card.abilities.Abiliti;
import org.dndp.dndc.engine.card.abilities.Abilities;
import org.dndp.dndc.engine.card.description.Description;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 * @author bambucha
 */
public class BonusManagerTest
{
	BonusManager	bonusManager;

	@Before
	public void before()
	{
		Abilities abilities = mock(Abilities.class);
		Description description = mock(Description.class);
		bonusManager = new DnDBonusManager(abilities, description);
	}

	@Test
	public void registrationBonus() throws Exception
	{
		// given
		Abiliti tester = mock(Abiliti.class);
		// when
		bonusManager.registerBonus("test", tester);
		// then
		verify(tester).setBonus(anyInt());
		assertThat(bonusManager.getBonusHandler("test")).isNotNull().isEqualTo(
				tester);
	}

	@Test(expected = IllegalArgumentException.class)
	public void secondRegistrationException() throws Exception
	{
		// given
		Abiliti tester = mock(Abiliti.class);
		// when
		bonusManager.registerBonus("test", tester);
		bonusManager.registerBonus("test", tester);
		// then
	}

	@Test(expected = MissingResourceException.class)
	public void testGetBonsuException()
	{
		bonusManager.getBonusHandler("Armor");
	}
}
