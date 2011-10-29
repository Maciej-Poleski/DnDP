package org.dndp.dndc.engine.card.bonus;

import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.dndp.dndc.engine.FantasyCharacter;
import org.dndp.dndc.engine.card.abilities.Abilities;
import org.dndp.dndc.engine.card.abilities.AbilityType;
import org.dndp.dndc.engine.card.attack.GrappleAttack;
import org.dndp.dndc.engine.card.description.Description;
import org.dndp.dndc.engine.card.description.DnDDescription;
import org.dndp.dndc.engine.card.description.Size;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 * @author bambucha
 */
public class BonusHandlerTest
{
	FantasyCharacter	character;
	Description			description;
	BaseBonusHandler	bonusHandler;
	Bonusable			tester;
	Abilities			abilities;

	@Before
	public void init()
	{
		tester = mock(Bonusable.class);
		when(tester.getAbilityName()).thenReturn(AbilityType.NONE);
		character = mock(FantasyCharacter.class);
		abilities = mock(Abilities.class);
		description = mock(DnDDescription.class);
		bonusHandler = new BaseBonusHandler(tester, abilities, description);
	}

	@Test
	public void testAddBonus()
	{
		bonusHandler.addBonus(BonusType.MORALE, 3);
		verify(tester).setBonus(3);
		bonusHandler.addBonus(BonusType.ENHANCEMENT, 5);
		verify(tester).setBonus(8);
		bonusHandler.addBonus(BonusType.LUCK, 2);
		verify(tester).setBonus(10);
	}

	@Test
	public void removeBonus() throws Exception
	{
		bonusHandler.addBonus(BonusType.MORALE, 3);
		bonusHandler.removeBonus(BonusType.MORALE, 3);

		assertThat(bonusHandler.countBonus()).isEqualTo(0);

	}

	@Test
	public void testRemoveManyBonus()
	{
		bonusHandler.addBonus(BonusType.MORALE, 3);
		bonusHandler.addBonus(BonusType.ENHANCEMENT, 3);
		bonusHandler.addBonus(BonusType.LUCK, 3);
		bonusHandler.removeBonus(BonusType.MORALE, 3);
		bonusHandler.removeBonus(BonusType.LUCK, 3);
		verify(tester).setBonus(9);
		verify(tester, times(2)).setBonus(6);
		verify(tester, times(2)).setBonus(3);
	}

	@Test(expected = IllegalArgumentException.class)
	public void bonusHandlerRemoveBonusException()
	{
		bonusHandler.removeBonus(BonusType.ALCHEMICAL, 3);
	}

	@Test
	public void testColossalModifier() throws Exception
	{
		// when
		when(description.getSize()).thenReturn(Size.COLOSSAL);
		when(tester.isSizeImportant()).thenReturn(true);
		// then
		assertThat(bonusHandler.countBonus()).isEqualTo(-8);
	}

	@Test
	public void testMediumSizeBonusToArmor()
	{
		when(tester.isSizeImportant()).thenReturn(true);
		when(description.getSize()).thenReturn(Size.MEDIUM);

		assertThat(bonusHandler.countBonus()).isEqualTo(0);
	}

	@Test
	public void testSizeBonusToGrappleAttack()
	{
		GrappleAttack tester = mock(GrappleAttack.class);
		bonusHandler = new BaseBonusHandler(tester, abilities, description);
		when(tester.getAbilityName()).thenReturn(AbilityType.STRENGHT);
		when(tester.isSizeImportant()).thenReturn(true);
		when(description.getSize()).thenReturn(Size.COLOSSAL);
		assertThat(bonusHandler.countBonus()).isEqualTo(16);
		verify(tester).setBonus(16);
	}

	@Test
	public void mediumBonusToGrappleAttack() throws Exception
	{
		// given
		GrappleAttack tester = mock(GrappleAttack.class);
		bonusHandler = new BaseBonusHandler(tester, abilities, description);
		when(tester.getAbilityName()).thenReturn(AbilityType.STRENGHT);
		when(tester.isSizeImportant()).thenReturn(true);
		// when
		when(description.getSize()).thenReturn(Size.MEDIUM);
		// then
		assertThat(bonusHandler.countBonus()).isEqualTo(0);
		verify(tester).setBonus(0);
	}

	@Test
	public void smallBonusToGrappleAttack() throws Exception
	{
		// given
		GrappleAttack tester = mock(GrappleAttack.class);
		bonusHandler = new BaseBonusHandler(tester, abilities, description);
		when(tester.getAbilityName()).thenReturn(AbilityType.STRENGHT);
		when(tester.isSizeImportant()).thenReturn(true);
		// when
		when(description.getSize()).thenReturn(Size.SMALL);
		// then
		assertThat(bonusHandler.countBonus()).isEqualTo(-4);
		verify(tester).setBonus(-4);
	}
}
