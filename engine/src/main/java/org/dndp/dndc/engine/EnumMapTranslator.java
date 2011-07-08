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
        @SuppressWarnings("unchecked")
        EnumMap<BonusType, BaseBonusHandler> out = (EnumMap<BonusType, BaseBonusHandler>)arg1;
        @SuppressWarnings("unchecked")
        TreeMap<BonusType, BaseBonusHandler> raw = (TreeMap<BonusType, BaseBonusHandler>)arg2;
        for(Entry<BonusType, BaseBonusHandler> en : raw.entrySet())
            out.put(en.getKey(), en.getValue());
    }

    @Override
    public Object onStore(ObjectContainer arg0, Object arg1)
    {
        @SuppressWarnings("unchecked")
        EnumMap<BonusType, Object> in = (EnumMap<BonusType, Object>)arg1;
        TreeMap<BonusType, Object> out = new TreeMap<BonusType, Object>();
        for(Entry<BonusType, Object> en : in.entrySet())
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
        return new EnumMap<BonusType, BaseBonusHandler>(BonusType.class);
    }

}
