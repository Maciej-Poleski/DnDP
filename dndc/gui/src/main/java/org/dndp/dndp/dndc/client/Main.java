package org.dndp.dndc.client;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.dndp.dndc.client.gui.MainWindow;
import org.dndp.dndc.engine.chat.Chat;

/**
 * Najważniejsza klasa w programie.
 * 
 * @par TODO Na koniec przejrzeć i sprawdzić inicjalizację Zrobić jak należy @code run() @endcode czyli shutdown hook uruchamiający closeConnection w handle
 * @author bambucha
 */
public class Main extends Thread
{
    MainWindow    window;
    FrontToServer handle;
    Chat          chatHeandler;

    public Main()
    {
        Properties prop = new Properties();
        try
        {
            prop.load(new FileInputStream(new File("setting.ini")));
        }
        catch(IOException ex)
        {
            Logger.getLogger("Main-start").log(Level.INFO, "Błąd czytania pliku, bądz plik nie istnieje", ex);
            prop.clear();
            prop.setProperty("DB URL", "193.193.65.227");
            prop.setProperty("DB PORT", "31117");
            prop.setProperty("DB USER", "dndtest");
            prop.setProperty("DB PASSWORD", "dupad12");
            prop.setProperty("SERVER URL", "users.v-lo.krakow.pl");
            prop.setProperty("SERVER PORT", "31116");
        }
        finally
        {
            FrontToDB.getInstance(prop);
            handle = new FrontToServer(prop);
            chatHeandler = new Chat(handle);
        }

        //window = new MainWindow(chatHeandler);
        //window.start();

    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException
    {
        Runtime.getRuntime().addShutdownHook(new Main());
    }

}
