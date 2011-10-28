package org.dndp.dndc.engine.item;

import static org.fest.assertions.Assertions.*;
import static org.mockito.Mockito.*;
import static org.dndp.dndc.engine.item.SimpleItemGenerator.*;

import org.dndp.dndc.engine.FantasyCharacter;
import org.dndp.dndc.engine.item.armor.Plate;
import org.dndp.dndc.engine.item.things.Belt;
import org.dndp.dndc.engine.item.things.Bracer;
import org.dndp.dndc.engine.item.things.Coat;
import org.dndp.dndc.engine.item.things.Glasses;
import org.dndp.dndc.engine.item.things.Gloves;
import org.dndp.dndc.engine.item.things.Helmet;
import org.dndp.dndc.engine.item.things.Necklace;
import org.dndp.dndc.engine.item.things.Ring;
import org.dndp.dndc.engine.item.things.Shirt;
import org.junit.Before;
import org.junit.Test;

public class ItemsTest
{
	private EquipmentManager	equipmentManager;

	@Before
	public void before()
	{
		FantasyCharacter owner = mock(FantasyCharacter.class);
		equipmentManager = new DnDEquipmentManager(owner);
	}

	@Test
	public void armorTest()
	{
		assertThat(equipmentManager.getArmor()).isNull();
		Plate plate = getPlate();
		equipmentManager.putOn(plate);
		assertThat(equipmentManager.getArmor()).isEqualTo(plate);
	}

	@Test
	public void beltTest()
	{
		assertThat(equipmentManager.getBelt()).isNull();
		Belt t = getBelt();
		equipmentManager.putOn(t);
		assertThat(equipmentManager.getBelt()).isEqualTo(t);
	}

	@Test
	public void bracerTest()
	{
		assertThat(equipmentManager.getBracer()).isNull();
		Bracer bracer = getBracer();
		equipmentManager.putOn(bracer);
		assertThat(equipmentManager.getBracer()).isEqualTo(bracer);
	}

	@Test
	public void coatTest()
	{
		assertThat(equipmentManager.getCoat()).isNull();
		Item coat = getCoat();
		equipmentManager.putOn(coat);
		assertThat(equipmentManager.getCoat()).isEqualTo(coat);
	}

	@Test
	public void glassesTest()
	{
		assertThat(equipmentManager.getGlasses()).isNull();
		Item glasses = getGlasses();
		equipmentManager.putOn(glasses);
		assertThat(equipmentManager.getGlasses()).isEqualTo(glasses);
	}

	@Test
	public void glovesTest()
	{
		assertThat(equipmentManager.getGloves()).isNull();
		Item gloves = getGloves();
		equipmentManager.putOn(gloves);
		assertThat(equipmentManager.getGloves()).isEqualTo(gloves);
	}

	@Test
	public void helmetTest()
	{
		assertThat(equipmentManager.getHelmet()).isNull();
		Item helmet = getHelmet();
		equipmentManager.putOn(helmet);
		assertThat(equipmentManager.getHelmet()).isEqualTo(helmet);
	}

	@Test
	public void necklaceTest()
	{
		assertThat(equipmentManager.getNecklace());
		Item necklace = getNacklace();
		equipmentManager.putOn(necklace);
		assertThat(equipmentManager.getNecklace()).isEqualTo(necklace);
	}

	// @Test
	public void firstSecondRingTest()
	{
		assertThat(equipmentManager.getFirstRing()).isNull();
		assertThat(equipmentManager.getSecondRing()).isNull();
		Item ring = getRing();
		Item sring = getRing();
		equipmentManager.putOn(ring);
		assertThat(equipmentManager.getFirstRing()).isEqualTo(ring);
		assertThat(equipmentManager.getSecondHand()).isNull();
		equipmentManager.putOn(sring);
		assertThat(equipmentManager.getFirstRing()).isEqualTo(ring);
		assertThat(equipmentManager.getSecondHand()).isEqualTo(sring);
	}

	@Test
	public void shirtTest()
	{
		assertThat(equipmentManager.getShirt()).isNull();
		Item shirt = getShirt();
		equipmentManager.putOn(shirt);
		assertThat(equipmentManager.getShirt()).isEqualTo(shirt);
	}
}
