package org.dndp.dndc.engine.item;

import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.dndp.dndc.engine.benefit.Benefit;
import org.dndp.dndc.engine.item.things.Belt;
import org.dndp.dndc.engine.item.things.Coat;
import org.dndp.dndc.engine.item.things.Shoes;
import org.fest.assertions.Delta;
import org.junit.Before;
import org.junit.Test;

public class InventoryTest
{
	Item		belt;
	Item		coat;
	Item		second;
	Inventory	testInventory;
	Inventory	inventory;

	@Before
	public void before()
	{
		belt = mock(Belt.class);
		when(belt.getName()).thenReturn("belt");
		when(belt.getWeight()).thenReturn(0.5);
		when(belt.getValue()).thenReturn(new Value(0, 1, 2, 3));

		coat = mock(Coat.class);
		when(coat.getName()).thenReturn("coat");
		when(coat.getWeight()).thenReturn(1.3);
		when(coat.getValue()).thenReturn(new Value(1, 0, 0, 7));

		second = mock(Shoes.class);
		when(second.getName()).thenReturn("second");
		when(second.getWeight()).thenReturn(1.0);
		when(second.getValue()).thenReturn(new Value(1, 1, 1, 0));

		inventory = new Inventory("inv", 1.0, new Value(0, 0, 0, 5),
				new Benefit[0]);
		inventory.add(second);

		testInventory = new Inventory("a", 2.0, new Value(0, 0, 0, 5),
				new Benefit[0]);
	}

	@Test
	public void testGetInventory()
	{
		assertThat(testInventory.getInventory()).isNotNull();
	}

	@Test
	public void testAdd()
	{
		testInventory.add(belt);
		assertThat(testInventory.getWeight().doubleValue()).isEqualTo(2.5,
				Delta.delta(0.0001));
		assertThat(testInventory.getValue()).isEqualTo(new Value(0, 1, 2, 8));
		testInventory.add(coat);
		assertThat(testInventory.getWeight().doubleValue()).isEqualTo(3.8,
				Delta.delta(0.0001));
		assertThat(testInventory.getValue()).isEqualTo(new Value(1, 1, 3, 5));
	}

	@Test
	public void testRemove()
	{
		testInventory.add(belt);
		testInventory.add(coat);
		testInventory.add(inventory);
		assertThat(testInventory.getWeight()).isEqualTo(5.8);
		assertThat(testInventory.getValue()).isEqualTo(new Value(2, 2, 5, 0));
		testInventory.remove(inventory);
		assertThat(testInventory.getWeight()).isEqualTo(3.8);
		assertThat(testInventory.getValue()).isEqualTo(new Value(1, 1, 3, 5));
		testInventory.remove(coat);
		assertThat(testInventory.getWeight()).isEqualTo(2.5);
		assertThat(testInventory.getValue()).isEqualTo(new Value(1, 1, 3, 5));
		testInventory.remove(belt);
		assertThat(testInventory.getWeight()).isEqualTo(2.0);
		assertThat(testInventory.getValue()).isEqualTo(new Value(0, 0, 0, 5));

	}

	@Test
	public void testContainsByName()
	{
		testInventory.add(belt);
		testInventory.add(coat);
		testInventory.add(inventory);

		assertThat(testInventory.containsByName("second")).isTrue();

		assertThat(testInventory.containsByName("belt")).isTrue();
		assertThat(testInventory.containsByName("coat")).isTrue();
	}

	@Test
	public void testContainsByExample()
	{
		testInventory.add(belt);
		testInventory.add(coat);
		testInventory.add(inventory);

		assertThat(testInventory.containsByExample(second)).isTrue();
		assertThat(testInventory.containsByExample(belt)).isTrue();
		assertThat(testInventory.containsByExample(coat)).isTrue();
	}

}
