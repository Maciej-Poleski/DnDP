package org.dndp.dndc.engine.item;

import org.dndp.dndc.engine.benefit.Benefit;
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

public class SimpleItemGenerator
{
	public static Plate getPlate()
	{
		return new Plate("tmp", 1.0, new Value(0, 0, 0, 1), new Benefit[0], 0,
				0.0, 300);
	}

	public static Belt getBelt()
	{
		return new Belt("tmp", 1.0, new Value(0, 0, 0, 1), new Benefit[0]);
	}

	public static Bracer getBracer()
	{
		return new Bracer("tmp", 1.0, new Value(0, 0, 0, 1), new Benefit[0]);
	}

	public static Coat getCoat()
	{
		return new Coat("tmp", 1.0, new Value(0, 0, 0, 1), new Benefit[0]);
	}

	public static Glasses getGlasses()
	{
		return new Glasses("tmp", 1.0, new Value(0, 0, 0, 1), new Benefit[0]);
	}

	public static Gloves getGloves()
	{
		return new Gloves("tmp", 1.0, new Value(0, 0, 0, 1), new Benefit[0]);
	}

	public static Helmet getHelmet()
	{
		return new Helmet("tmp", 1.0, new Value(0, 0, 0, 1), new Benefit[0]);
	}

	public static Necklace getNacklace()
	{
		return new Necklace("tmp", 1.0, new Value(0, 0, 0, 1), new Benefit[0]);
	}

	public static Ring getRing()
	{
		return new Ring("tmp", 1.0, new Value(0, 0, 0, 1), new Benefit[0]);
	}

	public static Shirt getShirt()
	{
		return new Shirt("tmp", 1.0, new Value(0, 0, 0, 1), new Benefit[0]);
	}
}
