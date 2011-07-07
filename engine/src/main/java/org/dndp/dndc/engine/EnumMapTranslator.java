package org.dndp.dndc.engine;

import java.util.EnumMap;
import java.util.Map.Entry;
import java.util.TreeMap;

import org.dndp.dndc.engine.card.bonus.BaseBonusHandler;
import org.dndp.dndc.engine.card.bonus.BonusType;

import com.db4o.ObjectContainer;
import com.db4o.config.ObjectConstructor;

public class EnumMapTranslator implements ObjectConstructor
{

    @Override
    public void onActivate(ObjectContainer arg0, Object arg1, Object arg2)
    {
        // TODO Auto-generated method stub

    }

    @Override
    public Object onStore(ObjectContainer arg0, Object arg1)
    {
        EnumMap<BonusType, BaseBonusHandler> in = (EnumMap<BonusType, BaseBonusHandler>)arg1;
        TreeMap<BonusType, BaseBonusHandler> out = new TreeMap<BonusType, BaseBonusHandler>();
        for(Entry<BonusType, BaseBonusHandler> en : in.entrySet())
            out.put(en.getKey(), en.getValue());
        return out;
    }

    @Override
    public Class storedClass()
    {
        return TreeMap.class;
    }

    @Override
    public Object onInstantiate(ObjectContainer arg0, Object arg1)
    {
        EnumMap<BonusType, BaseBonusHandler> out = new EnumMap<BonusType, BaseBonusHandler>(
                BonusType.class);
        TreeMap<BonusType, BaseBonusHandler> raw = (TreeMap<BonusType, BaseBonusHandler>)arg1;
        for(Entry<BonusType, BaseBonusHandler> en : raw.entrySet())
            out.put(en.getKey(), en.getValue());
        return out;
    }

}
