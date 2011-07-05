package org.dndp.dndc.engine.card.fleats;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.dndp.dndc.client.FrontToDB;

import com.db4o.ObjectSet;

/**
 * Globalny Menadżer Atutów.
 * 
 * @author evil, bambucha
 */
public final class FleatManager
{

    private static FleatManager fleatManager;
    private Map<String, Fleat>  fleats;

    /**
     * Konstruktor. Czyta z bazy danych wszystkie atuty.
     */
    private FleatManager()
    {
        fleats = new HashMap<String, Fleat>();
        ObjectSet<Fleat> query = FrontToDB.getInstance().getDB().query(Fleat.class);
        for(Fleat fleat : query)
            fleats.put(fleat.getName(), fleat);
    }

    /**
     * Zwraca instancję singletonu.
     * 
     * @return Instancja Menadżera Atutów.
     */
    public static synchronized FleatManager getInstance()
    {
        if (fleatManager == null)
            fleatManager = new FleatManager();
        return fleatManager;
    }

    /**
     * Pobiera Atut na podstawie jego nazwy.
     * 
     * @param key
     *            Nazwa atutu.
     * @return Atut
     */
    public Fleat getFleat(Object key)
    {
        return fleats.get(key);
    }

    /**
     * Zwraca wszystkie atuty z bazy.
     * 
     * @return
     */
    public Collection<Fleat> getAllFleats()
    {
        return fleats.values();
    }

}
