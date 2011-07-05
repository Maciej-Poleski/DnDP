package org.dndp.dndc.engine.chat;


import java.io.IOException;

import org.dndp.dndc.client.FrontToServer;
import org.dndp.dndc.client.ParserHandler;
import org.dndp.dndc.client.gui.chat.ChatPanel;

/**
 * Klasa parsująca i przygotowująca wiadomość do wyświetlenia oraz wysłania
 * 
 * @author bambucha
 */
public class Chat extends Thread
{
    private ChatPanel     gui;
    private String        nick;
    private FrontToServer handle;

    private String        date;
    private String        name;
    private String        message;

    /**
     * Standarody konstruktor tworzy czas dla bezimiennego.
     */
    public Chat(FrontToServer handle)
    {
        this.nick = "No name ";
        this.handle = handle;
        handle.setContentHandlerForParser(new ParserHandler(this));
        handle.start();
    }

    /**
     * Wyświetla tekst z odpowienim formatem 1 - format czasu 2 - format nick'u 3 - format wiadomości
     * 
     * @param text
     *            teskt do wyświetlenia
     * @param state
     *            jaki format
     */
    public void showText(String text, int state)
    {
        switch (state)
        {
            case 1:
                this.date = text;
                break;
            case 2:
                this.name = text;
                break;
            case 3:
                this.message = text;
                break;
        }
        if(date != null && name != null && message != null)
        {
            gui.getDisplay().asyncExec(new Runnable()
            {
                
                @Override
                public void run()
                {
                    gui.showMessage(date, name, message);
                }
            });
            date = null;
            name = null;
            message = null;
        }

    }

    public void sendMessage(String message)
    {
        try
        {
            handle.sendMessage(nick, prepare(message));
        }
        catch(IOException ex)
        {}
    }

    public void setGui(ChatPanel gui)
    {
        this.gui = gui;
    }

    public String getNick()
    {
        return nick;
    }

    public void setNick(String nick)
    {
        this.nick = prepare(nick);
    }

    /**
     * Zamienia tekst na taki który łyka parser
     * 
     * @param what
     *            Tekst do przygotowania
     * @return Obrobiony tekst
     */
    private String prepare(String what)
    {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < what.length(); i++)
            switch (what.charAt(i))
            {
                case '<':
                    output.append("&lt;");
                    break;
                case '>':
                    output.append("&gt;");
                    break;
                case '&':
                    output.append("&amp;");
                    break;
                default:
                    output.append(what.charAt(i));
                    break;
            }
        return output.toString();
    }
}
