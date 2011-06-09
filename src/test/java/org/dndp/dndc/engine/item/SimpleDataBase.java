package org.dndp.dndc.engine.item;

import org.dndp.dndc.client.FrontToDB;
import org.dndp.dndc.engine.benefit.Benefit;
import org.dndp.dndc.engine.benefit.BonusBenefit;
import org.dndp.dndc.engine.card.bonus.BonusType;
import org.dndp.dndc.engine.item.things.Belt;
import org.dndp.dndc.engine.item.things.Bracer;
import org.dndp.dndc.engine.item.things.Coat;

import com.db4o.ObjectContainer;

public class SimpleDataBase
{
    static void createSimpleDB()
    {
        ObjectContainer db = FrontToDB.getInstance().getDB();
        db.store(new Belt("Pas", 1.1, new Value(0, 0, 0, 1), new Benefit[0]));
        db.store(new Belt("Pas siły", 1.1, new Value(0, 0, 0, 1), new Benefit[]{new BonusBenefit("Strenght", BonusType.COMPETENCE, 2)}));
        db.store(new Bracer("Krwasze lekkie", 5.0, new Value(1, 4, 44, 22), new Benefit[]{new BonusBenefit("Armor", BonusType.DEFLECTION, 1)}));
        db.store(new Bracer("Krwasze", 5.0, new Value(1, 4, 44, 22), new Benefit[]{new BonusBenefit("Armor", BonusType.DEFLECTION, 3)}));
        db.store(new Coat("Normalny plaszcz", 0.5, new Value(0, 0, 0, 5), new Benefit[0]));
        db.store(new Coat("Plaszcz elfów", 1.5, new Value(0, 40, 50, 0), new Benefit[]{new BonusBenefit("Armor", BonusType.ARMOR, 3)}));
    }
}