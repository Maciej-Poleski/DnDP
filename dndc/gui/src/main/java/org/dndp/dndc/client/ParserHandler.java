package org.dndp.dndc.client;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.dndp.dndc.engine.chat.Chat;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;


/**
 * Klasa obsługująca wydarzenia na parserze :)
 * 
 * @author bambucha
 */
public class ParserHandler extends DefaultHandler
{

    private Chat    toChat;
    private Integer state;

    public ParserHandler(Chat toChat)
    {
        super();
        this.toChat = toChat;
        this.state = 0;
    }

    @Override
    public void endDocument() throws SAXException
    {
        Logger.getLogger("Rozmowa").log(Level.INFO, "Koniec rozmowy");
    }

    @Override
    public void endElement(String uri, String localName, String qName)
            throws SAXException
    {
        if (localName.equals("message"))
            toChat.showText("\n", 3);
        state = 0;
    }

    @Override
    public void startDocument() throws SAXException
    {
        Logger.getLogger("Rozmowa").log(Level.INFO, "Początek Rozmowy");
    }

    @Override
    public void startElement(String uri, String localName, String qName,
            Attributes attributes) throws SAXException
    {
        if (localName.equals("time"))
            state = 1;
        if (localName.equals("nick"))
            state = 2;
        if (localName.equals("message"))
            state = 3;

    }

    @Override
    public void characters(char[] ch, int start, int length)
            throws SAXException
    {
        StringBuilder output = new StringBuilder();
        for (int i = start; i < start + length; i++)
            output.append(ch[i]);
        output.append(" ");
        toChat.showText(output.toString(), state);
    }

    @Override
    public void error(SAXParseException saxpe) throws SAXException
    {
        super.error(saxpe);
        Logger.getLogger("parser")
                .log(Level.WARNING, "Błąd parsowania ", saxpe);
    }
}
