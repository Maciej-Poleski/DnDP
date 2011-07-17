package org.dndp.dndc.engine.database;

import java.util.EnumMap;
import java.util.Map.Entry;
import java.util.TreeMap;

import org.dndp.dndc.engine.card.bonus.Bonus;
import org.dndp.dndc.engine.card.bonus.BonusType;

import com.db4o.ObjectContainer;
import com.db4o.config.ObjectConstructor;

/**
 * Klasa tłumacząca EnumMapa na normalny Map który da się radę storować.
 * 
 * Napisan brzydko. FIXME: Przepisać lepiej.
 * 
 * @author bambucha
 * 
 */
public class EnumMapTranslator implements ObjectConstructor
{

    @Override
    public void onActivate(ObjectContainer arg0, Object arg1, Object arg2)
    {
        @SuppressWarnings("unchecked")
        EnumMap<BonusType, Bonus> out = (EnumMap<BonusType, Bonus>)arg1;
        @SuppressWarnings("unchecked")
        TreeMap<BonusType, Bonus> raw = (TreeMap<BonusType, Bonus>)arg2;
        for(Entry<BonusType, Bonus> en : raw.entrySet())
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

    @SuppressWarnings("rawtypes")
    @Override
    public Class storedClass()
    {
        return TreeMap.class;
    }

    @Override
    public Object onInstantiate(ObjectContainer arg0, Object arg1)
    {
        return new EnumMap<BonusType, Bonus>(BonusType.class);
    }

}
