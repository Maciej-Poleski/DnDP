package org.dndp.dndc.engine.card.attack;

import java.util.List;

/**
 * Klasa kapsułkująca informacje o całkowitym ataku postaci danego typu
 * Uwzględnia dwuręczność , chodz nie do końca.
 * 
 * @author bambucha
 */
public class TotalBonusToAttack extends BaseBonusToAttack
{
	private int[]	mainHand;

	@Deprecated
	public TotalBonusToAttack(int[] temp)
	{
		if(temp.length > 4)
			throw new IllegalArgumentException("Za dużo ataków");
		this.mainHand = temp;
	}

	public TotalBonusToAttack(BaseBonusToAttack base,
			OffhandBonusToAttack offhand, BaseAttack attack)
	{
		throw new UnsupportedOperationException("Brak implementacji");
	}

	/**
	 * Zwraca atak główną ręką.
	 * 
	 * @return
	 */
	@Deprecated
	public int[] getMainHand()
	{
		return mainHand;
	}

	public Integer firstOffhand()
	{
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Brak implementacji");
	}

	public Integer secondOffhand()
	{
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Brak implementacji");
	}

	public Integer thridOffhand()
	{
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Brak implementacji");
	}

	public Integer getNumberOffhandAttacks()
	{
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Brak implementacji");
	}

	public List<Integer> getOffhand()
	{
		// Użyć Collections.unmodifiableList(list); jako wraper nad tym
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Brak implementacji");
	}
}
