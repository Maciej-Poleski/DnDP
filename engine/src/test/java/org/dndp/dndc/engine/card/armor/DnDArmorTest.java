/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */

package org.dndp.dndc.engine.card.armor;

import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.dndp.dndc.engine.card.abilities.Abiliti;
import org.dndp.dndc.engine.card.abilities.Abilities;
import org.dndp.dndc.engine.card.bonus.ArmorBonusHandler;
import org.dndp.dndc.engine.card.bonus.BonusManager;
import org.dndp.dndc.engine.item.EquipmentManager;
import org.dndp.dndc.engine.item.armor.Plate;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 * @author bambucha
 */
public class DnDArmorTest
{
	BonusManager		bonus;
	Abilities			abilities;
	Abiliti				dexterity;
	EquipmentManager	manager;
	ArmorBonusHandler	armorBonusHandler;
	DnDArmor			armor;
	Plate				plate;
	Plate				nd;

	public DnDArmorTest()
	{}

	@Before
	public void dupa()
	{

		bonus = mock(BonusManager.class);
		armorBonusHandler = mock(ArmorBonusHandler.class);
		when(bonus.getBonusHandler("Armor")).thenReturn(armorBonusHandler);
		when(armorBonusHandler.getACBonus()).thenReturn(0);
		manager = mock(EquipmentManager.class);
		plate = mock(Plate.class);
		when(manager.getArmor()).thenReturn(plate);
		abilities = mock(Abilities.class);
		dexterity = mock(Abiliti.class);
		when(abilities.getDexterity()).thenReturn(dexterity);
		armor = new DnDArmor(abilities, manager, bonus);
	}

	/**
	 * Test of getAC method, of class DnDArmor.
	 */
	@Test
	public void testGetAC()
	{
		assertThat(armor.getAC()).isEqualTo(10);
	}

	/**
	 * Test of getAC method, of class DnDArmor.
	 */
	@Test
	public void testGetACDex()
	{
		when(dexterity.getModifier()).thenReturn(5);
		when(manager.getMaximumDexterityACBonus()).thenReturn(10);
		assertThat(armor.getAC()).isEqualTo(15);
	}

	/**
	 * Test of getAC method, of class DnDArmor.
	 */
	@Test
	public void testGetACPlate()
	{
		abilities.getDexterity().setValue(20);
		manager.putOn(plate);
		assertThat(armor.getAC()).isEqualTo(10);
	}

}
