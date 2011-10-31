/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */

package org.dndp.dndc.engine.card.attack;

import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Matchers.eq;
import static org.mockito.Matchers.isNull;
import static org.mockito.Matchers.notNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Observer;

import org.dndp.dndc.engine.card.abilities.AbilityType;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 * @author bambucha
 */
public class MeleeAtackTest
{
	MeleeAttack	test;
	Attack		attack;

	public MeleeAtackTest()
	{

	}

	@Before
	public void setUpClass() throws Exception
	{
		attack = mock(Attack.class);
		test = new MeleeAttack(attack);
	}

	@Test
	public void meleeAttackUseStrenght() throws Exception
	{
		assertThat(test.getAbilityName()).isEqualTo(AbilityType.STRENGHT);
	}

	@Test
	public void getAttacks() throws Exception
	{
		assertThat(test.getAttacks()).isNotNull();
	}

	@Test
	public void secondSetingSameBonusDontMakeNotification() throws Exception
	{
		test.setBonus(15);
		Observer tester = mock(Observer.class);
		test.addObserver(tester);
		test.setBonus(15);
		verify(tester, never()).update(eq(test), notNull());
	}

	@Test
	public void update() throws Exception
	{
		Observer tester = mock(Observer.class);
		test.addObserver(tester); // Dodanie go generuje notyfikację
		test.update();
		verify(tester, times(2)).update(eq(test), isNull());
	}

	@Test
	public void importentSize() throws Exception
	{
		assertThat(test.isSizeImportant()).isTrue();
	}

	@Test
	public void getCharacterBaseAttack() throws Exception
	{
		when(attack.getBaseAttack()).thenReturn(mock(BaseBonusToAttack.class));
		assertThat((Object)test.getBaseAttack()).isNotNull();
		verify(attack).getBaseAttack();
	}
}
