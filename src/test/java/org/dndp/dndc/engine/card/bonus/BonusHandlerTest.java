/*
 * To change this template, choose Tools | Templates and open the template in the editor.
 */

package org.dndp.dndc.engine.card.bonus;

import static org.junit.Assert.assertEquals;

import org.dndp.dndc.engine.Character;
import org.dndp.dndc.engine.card.abilities.Abiliti;
import org.junit.Test;

/**
 * Z racji że w zorze określającym modyfikator jest użuta podłoga( nie
 * formalnie) to określenie wartości staje się cięższe.
 * 
 * @author bambucha
 */
public class BonusHandlerTest {
	Character x = new Character();
	Abiliti t = new Abiliti();
	BaseBonusHandler test = new BaseBonusHandler(t, x, x);

	public BonusHandlerTest() {

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
	private Integer getModifier(Integer bonus, Abiliti t) {
		return new Integer(((bonus - t.getValue()) + 10) / 2);
	}

	@Test
	public void testAddBonus() {
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
	public void testRemoveBonus() {
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
	public void testRemoveBonusException() {
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

}
