package org.dndp.dndc.client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.xml.sax.ContentHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

/**
 * Klasa Fasada do serwera Jej zadaniem jest hermetyzacja protokołu Parser SAX Odwołania do każdego elemntu
 * 
 * @author bambucha
 */
public class FrontToServer extends Thread
{

    private Socket         connectionToServer;
    private BufferedWriter output;
    private BufferedReader input;
    private XMLReader      parser;

    /**
     * Tworzy połączenie do serwera wbitego na sztywno do kodu. Przygotowuje strumienie Nie zaczyna parsować
     */
    public FrontToServer(Properties prop)
    {
        this.setDaemon(true);
        try
        {
            parser = XMLReaderFactory.createXMLReader();
            connectionToServer = new Socket(prop.getProperty("SERVER URL"), Integer.parseInt(prop.getProperty("SERVER PORT")));
            output = new BufferedWriter(new OutputStreamWriter(connectionToServer.getOutputStream(), "UTF-8"));
            input = new BufferedReader(new InputStreamReader(connectionToServer.getInputStream(), "UTF-8"));
        }
        catch(SAXException ex)
        {
            Logger.getLogger(FrontToServer.class.getName()).log(Level.SEVERE, "Błąd parsera", ex);
        }
        catch(UnknownHostException ex)
        {
            Logger.getLogger(FrontToServer.class.getName()).log(Level.SEVERE, "Serwer nie odnaleziony", ex);
        }
        catch(IOException ex)
        {
            Logger.getLogger(FrontToServer.class.getName()).log(Level.SEVERE, "Błąd strumieni w init", ex);
        }
    }

    /**
     * Implemetacja wątku parsowania wiadomości.
     */
    @Override
    public void run()
    {
        try
        {
                parser.parse(new InputSource(input));
            

        }
        catch(IOException ex)
        {
            Logger.getLogger(FrontToServer.class.getName()).log(Level.SEVERE, "Błąd IO", ex);
        }
        catch(SAXException ex)
        {
            Logger.getLogger(FrontToServer.class.getName()).log(Level.SEVERE, "Wyleciał wyjątek parsera", ex);
        }
    }

    /**
     * Zwraca status połączenia
     * 
     * @return true jeśli jest połączenie
     */
    public Boolean isConnected()
    {
        return connectionToServer.isConnected();
    }

    /**
     * Zamyka połączenie
     * 
     * @throws IOException
     */
    public synchronized void closeConnection() throws IOException
    {
        output.write("</root>");
        input.close();
        output.close();
        connectionToServer.close();
    }

    /**
     * Implemetacja wysyłania wiadomości
     * 
     * @param nick
     *            - nick użytkowniak chatu
     * @param message
     *            - wiadomość od użytkownika chatu
     * @throws IOException
     *             - Błąd przy wysyłaniu wiadomości
     */
    public void sendMessage(String nick, String message) throws IOException
    {
        output.write("<nick>");
        output.write(nick);
        output.write("</nick>");
        output.write("<message>");
        output.write(message);
        output.write("</message>\n");
        output.flush();
    }

    public void setContentHandlerForParser(ContentHandler x)
    {
        parser.setContentHandler(x);
    }
}
