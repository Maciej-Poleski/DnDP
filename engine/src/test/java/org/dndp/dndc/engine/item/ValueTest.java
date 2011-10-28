package org.dndp.dndc.engine.item;

import static org.fest.assertions.Assertions.*;

import org.junit.Before;
import org.junit.Test;

/**
 * 
 * @author bambucha
 */
public class ValueTest
{

	Value	x;

	public ValueTest()
	{
		x = new Value(4, 132, 22, 33);
	}

	@Before
	public void before()
	{
		x = new Value(4, 132, 22, 33);
	}

	@Test
	public void testAdd()
	{
		System.out.println("add");
		Value b = new Value(3, 90, 90, 90);
		Value instance = new Value(4, 132, 22, 33);
		Value expResult = new Value(30, 4, 4, 3);
		assertThat(Value.add(instance, b)).isEqualTo(expResult);
	}

	@Test
	public void testGetCopper()
	{
		assertThat(x.getCopper()).isEqualTo(3);
	}

	@Test
	public void testSetCopper()
	{
		x.setCopper(10);
		assertThat(x.getCopper().intValue()).isEqualTo(0);
	}

	@Test
	public void testGetGold()
	{
		assertThat(x.getGold()).isEqualTo(4);
	}

	@Test
	public void testSetGold()
	{
		x.setGold(21);
		assertThat(x.getGold()).isEqualTo(1);
	}

	@Test
	public void testGetPlatinum()
	{
		assertThat(x.getPlatinum()).isEqualTo(17);
	}

	@Test
	public void testSetPlatinum()
	{
		x.setPlatinum(5);
		assertThat(x.getPlatinum()).isEqualTo(5);
	}

	@Test
	public void testGetSilver()
	{
		assertThat(x.getSilver()).isEqualTo(5);
	}

	@Test
	public void testSetSilver()
	{
		x.setSilver(30);
		assertThat(x.getSilver()).isEqualTo(0);
	}

	@Test
	public void testToString()
	{
		System.out.println("toString");
		String expResult = "17 pp 4 gp 5 sp 3 cp";
		assertThat(x.toString()).isEqualTo(expResult);
	}

	@Test
	public void compareToTest()
	{
		Value a = new Value(0, 0, 1, 5);
		assertThat(a.compareTo(a)).isEqualTo(0);
		Value b = new Value(0, 0, 1, 6);
		assertThat(a.compareTo(b)).isNegative();
		assertThat(b.compareTo(a)).isPositive();
		a = Value.add(a, new Value(0, 0, 0, 1));
		assertThat(a.compareTo(b)).isZero();
		a = Value.add(a, new Value(0, 0, 0, 1));
		assertThat(a.compareTo(b)).isPositive();
		assertThat(b.compareTo(a)).isNegative();
	}

}
