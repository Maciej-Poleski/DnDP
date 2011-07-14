package org.dndp.dndc.engine.database;

import java.util.List;

import org.dndp.dndc.engine.card.classes.BaseClass;
import org.dndp.dndc.engine.card.description.God;
import org.dndp.dndc.engine.card.description.Race;
import org.dndp.dndc.engine.card.fleats.Fleat;
import org.dndp.dndc.engine.card.skills.Skill;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.config.EmbeddedConfiguration;
import com.db4o.query.Predicate;

/**
 * @author bambucha
 * 
 */
public class Database
{
    private static Database instance;

    public static Database get()
    {
        if(instance == null)
            instance = new Database();
        return instance;
    }

    private ObjectContainer db;

    private Database()
    {
        EmbeddedConfiguration config = Db4oEmbedded.newConfiguration();
        // config.file().readOnly(true);
        config.file().lockDatabaseFile(false);
        db = Db4oEmbedded.openFile(config, "main.db");
    }

    @Override
    protected void finalize() throws Throwable
    {
        db.close();
        super.finalize();
    }

    public List<Fleat> getFleats()
    {
        ObjectSet<Fleat> tmp = db.query(Fleat.class);
        return tmp;
    }

    public List<Skill> getSkills()
    {
        ObjectSet<Skill> tmp = db.query(Skill.class);
        return tmp;
    }

    public List<God> getGods()
    {
        ObjectSet<God> tmp = db.query(God.class);
        return tmp;
    }

    public List<Race> getRaces()
    {
        ObjectSet<Race> tmp = db.query(Race.class);
        return tmp;
    }

    public List<BaseClass> getFantasyClass()
    {
        ObjectSet<BaseClass> tmp = db.query(BaseClass.class);
        return tmp;
    }

    public <E> List<E> getByPredicate(Predicate<E> predicate)
    {
        ObjectSet<E> tmp = db.query(predicate);
        return tmp;
    }
}
