/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */

package org.dndp.dndc.engine.card.bonus;

import static org.junit.Assert.assertEquals;

import org.dndp.dndc.engine.FantasyCharacter;
import org.dndp.dndc.engine.card.abilities.Abiliti;
import org.dndp.dndc.engine.card.abilities.AbilityType;
import org.dndp.dndc.engine.card.attack.GrappleAttack;
import org.dndp.dndc.engine.card.description.Size;
import org.junit.Before;
import org.junit.Test;

/**
 * Z racji że w zorze określającym modyfikator jest użuta podłoga( nie
 * formalnie) to określenie wartości staje się cięższe.
 * 
 * @author bambucha
 */
public class BonusHandlerTest
{
	FantasyCharacter	x		= new FantasyCharacter();
	Abiliti				t		= new Abiliti();
	BaseBonusHandler	test	= new BaseBonusHandler(t, x, x);

	public BonusHandlerTest()
	{

	}

	@Before
	public void init()
	{

	}

	/**
	 * Zwraca modyfilator jaki powinnien mieć atrybiut, przyz konkretynym
	 * bonusie.
	 * 
	 * @param bonus
	 *            Bonus
	 * @param t
	 *            Atrubut
	 * @return Modyfikator
	 */
	private Integer getModifier(Integer bonus, Abiliti t)
	{
		return new Integer(((bonus - t.getValue()) + 10) / 2);
	}

	@Test
	public void testAddBonus()
	{
		Integer bonus1 = 3;
		Integer bonus2 = 5;
		Integer bonus3 = 1;
		test.addBonus(BonusType.MORALE, bonus3);
		test.addBonus(BonusType.ENHANCEMENT, bonus2);
		assertEquals(getModifier(bonus3 + bonus2, t), t.getModifier());
		test.addBonus(BonusType.LUCK, bonus1);
		assertEquals(getModifier(bonus3 + bonus2 + bonus1, t), t.getModifier());

	}

	@Test
	public void testRemoveBonus()
	{
		Integer bonus1 = 3;
		Integer bonus2 = 5;
		Integer bonus3 = 1;
		test.addBonus(BonusType.MORALE, bonus3);
		test.addBonus(BonusType.ENHANCEMENT, bonus2);
		assertEquals(getModifier(bonus3 + bonus2, t), t.getModifier());
		test.addBonus(BonusType.LUCK, bonus1);
		assertEquals(getModifier(bonus3 + bonus2 + bonus1, t), t.getModifier());
		test.removeBonus(BonusType.MORALE, bonus3);
		assertEquals(getModifier(bonus2 + bonus1, t), t.getModifier());
		test.removeBonus(BonusType.LUCK, bonus1);
		assertEquals(getModifier(bonus2, t), t.getModifier());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testRemoveBonusException()
	{
		Integer bonus1 = 3;
		Integer bonus2 = 5;
		Integer bonus3 = 1;
		test.addBonus(BonusType.MORALE, bonus3);
		test.addBonus(BonusType.ENHANCEMENT, bonus2);
		assertEquals(getModifier(bonus3 + bonus2, t), t.getModifier());
		test.addBonus(BonusType.LUCK, bonus1);
		assertEquals(getModifier(bonus3 + bonus2 + bonus1, t), t.getModifier());
		test.removeBonus(BonusType.ALCHEMICAL, bonus3);
		assertEquals(getModifier(bonus2 + bonus1, t), t.getModifier());
		test.removeBonus(BonusType.LUCK, bonus1);
		assertEquals(getModifier(bonus2, t), t.getModifier());
	}

	// @Test
	// public void testSizeBonus()
	// {
	// x.setSize(Size.COLOSSAL);
	// Bonusable bonusalbeMock = createMock(Bonusable.class);
	// expect(bonusalbeMock.getAbilityName()).andReturn(AbilityType.NONE)
	// .anyTimes();
	// expect(bonusalbeMock.isSizeImportant()).andReturn(true).anyTimes();
	// bonusalbeMock.setBonus(-8);
	// bonusalbeMock.setBonus(0);
	// replay(bonusalbeMock);
	// BaseBonusHandler bonus = new BaseBonusHandler(bonusalbeMock, x, x);
	// assertEquals(-8, bonus.countBonus().intValue());
	// x.setSize(Size.MEDIUM);
	// assertEquals(0, bonus.countBonus().intValue());
	//
	// reset(bonusalbeMock);
	// GrappleAttack tmpAttack = createMock(GrappleAttack.class);
	//
	// expect(tmpAttack.getAbilityName()).andReturn(AbilityType.STRENGHT)
	// .anyTimes();
	// expect(tmpAttack.isSizeImportant()).andReturn(true).anyTimes();
	// tmpAttack.setBonus(0);
	// tmpAttack.setBonus(16);
	// tmpAttack.setBonus(-4);
	// replay(tmpAttack);
	// BaseBonusHandler gBonus = new BaseBonusHandler(tmpAttack, x, x);
	//
	// assertEquals(0, gBonus.countBonus().intValue());
	// x.setSize(Size.COLOSSAL);
	// assertEquals(16, gBonus.countBonus().intValue());
	// x.setSize(Size.SMALL);
	// assertEquals(-4, gBonus.countBonus().intValue());
	// }
}
