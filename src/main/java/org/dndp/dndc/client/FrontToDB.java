package org.dndp.dndc.client;

import java.util.Properties;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.cs.Db4oClientServer;

/**
 * Fasada do bazy danych Wzorze projektowy singleton Przeglądnąć na koniec
 * 
 * @author bambucha
 */
public class FrontToDB
{

    static private FrontToDB instance = null;
    private ObjectContainer  DB;

    /**
     * Konstruktor w celach testowych
     */
    protected FrontToDB()
    {
        DB = Db4oEmbedded.openFile("dnd.db");
    }

    /**
     * Buduje fasadę na bazie pracującej na standardowym porcie
     * 
     * @param url
     *            Adres bazy
     * @param user
     *            Użytkownik
     * @param password
     *            Hasło
     */
    protected FrontToDB(String url, String user, String password)
    {
        DB = Db4oClientServer.openClient(url, 31117, user, password);
    }

    /**
     * Buduje fasadę do bazy danych zgodnie z ustawieniami.
     * 
     * @param prop
     */
    protected FrontToDB(Properties prop)
    {
        DB = Db4oClientServer.openClient(prop.getProperty("DB URL"),
                Integer.parseInt(prop.getProperty("DB PORT")),
                prop.getProperty("DB USER"), prop.getProperty("DB PASSWORD"));
    }

    /**
     * Zwraca referencję do fasady bazy dancyh, jeśli ona istnieje, w przeciwmym
     * wypadku rzuca wyjątkiem
     * 
     * @return Referencje fasady do bazy danych
     * @throws IllegalStateException
     *             gdy jeszcze nie zbudowany
     */
    public static FrontToDB getInstance() throws IllegalStateException
    {

        if (instance == null)
            // /Odkomentować na koniec
            // throw new IllegalStateException("Brak obiektu");
            instance = new FrontToDB();
        return instance;
    }

    /**
     * Buduje fasadę z podanych danych, lub zwraca istniejący egzęplaż.
     * 
     * @param url
     *            Adres bazy danych
     * @param user
     *            Użytkownik do bazy danych
     * @param password
     *            Hasło użytkownika bazy danych
     * @return Referencję do fasady
     */
    public static FrontToDB getInstance(String url, String user, String password)
    {

        if (instance == null)
            instance = new FrontToDB(url, user, password);
        return instance;
    }

    /**
     * Buduje fasadę bazy danych z podanych ustwawień. Ustawienia
     * <ul>
     * <li>DB URL-Adres do bazy dancyh</li>
     * <li>DB PORT-Numer portu na którym pracuje baza</li>
     * <li>DB USER-Użytkownik w bazie danych</li>
     * <li>DB PASSWORD-Hasło użytkownika
     * <li>
     * </ul>
     * Zwraca referęcję do fasady bazy dancyh
     * 
     * @param props
     *            Ustawienia połącznia do bazy dancych
     * @return Referencje fasady do bazy danych
     */
    public static FrontToDB getInstance(Properties props)
    {

        if (instance == null)
            instance = new FrontToDB(props);
        return instance;
    }

    /**
     * Zwraca uchwyt do bazy dancyh
     * 
     * @return Baza dancyh
     */
    public ObjectContainer getDB()
    {
        return DB;
    }
}
