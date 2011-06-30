package org.dndp.dndc.client.gui.chat;

import org.dndp.dndc.engine.chat.Chat;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;


/**
 * 
 * 
 * @author bambucha
 */
public class ChatPanel extends Composite
{
    private final Button     sendButton;
    private final Text       typeField;
    private final StyledText chatArea;
    private final Chat       chat;

    /**
     * 
     * @param parent
     *            Obiekt nadrzędny
     * @param style
     *            Styl
     */
    public ChatPanel(final Composite parent, int style, Chat chat)
    {
        super(parent, style);

        this.chat = chat;

        FormLayout layout = new FormLayout();
        layout.marginTop = 10;
        layout.marginBottom = 10;
        layout.marginLeft = 10;
        layout.marginRight = 10;
        this.setLayout(layout);

        final int margin = 10;

        sendButton = new Button(this, SWT.PUSH);
        typeField = new Text(this, SWT.LEFT);
        chatArea = new StyledText(this, SWT.READ_ONLY | SWT.WRAP);

        final FormData chatAreaFormData = new FormData(290, 50);
        chatAreaFormData.top = new FormAttachment(0, 0);
        chatAreaFormData.left = new FormAttachment(0);
        chatAreaFormData.right = new FormAttachment(100);
        chatAreaFormData.bottom = new FormAttachment(typeField, -margin);
        chatArea.setLayoutData(chatAreaFormData);

        final FormData typeFieldFormData = new FormData(200, 25);
        typeFieldFormData.right = new FormAttachment(sendButton, -5);
        typeFieldFormData.left = new FormAttachment(0);
        typeFieldFormData.bottom = new FormAttachment(100);
        typeField.setLayoutData(typeFieldFormData);

        final FormData sendButtonFormData = new FormData(80, 25);
        sendButtonFormData.top = new FormAttachment(chatArea, margin);
        sendButtonFormData.right = new FormAttachment(100);
        sendButtonFormData.bottom = new FormAttachment(100);
        sendButton.setLayoutData(sendButtonFormData);
        sendButton.setText("Send"); //$NON-NLS-1$

        sendButton.addListener(SWT.Selection, new Listener()
        {
            public void handleEvent(Event event)
            {
                sendMessage();
            }
        });

        typeField.addKeyListener(new KeyListener()
        {

            public void keyReleased(KeyEvent e)
            {}

            public void keyPressed(KeyEvent e)
            {
                if(e.keyCode == SWT.CR)
                    sendMessage();
            }
        });

        this.setSize(500, 500);
        this.pack();
    }

    private void sendMessage()
    {
        if(typeField.getText().length() > 0)
            chat.sendMessage(typeField.getText());
    }

    public void showMessage(String date, String name, String message)
    {
        int begin = chatArea.getCharCount();
        chatArea.append(date + ' ');
        StyleRange dateStyle = new StyleRange();
        dateStyle.fontStyle = SWT.ITALIC;
        dateStyle.start = begin;
        dateStyle.length = date.length();
        chatArea.setStyleRange(dateStyle);

        begin = chatArea.getCharCount();
        chatArea.append(name + ' ');
        StyleRange nickStyle = new StyleRange();
        nickStyle.fontStyle = SWT.BOLD;
        nickStyle.start = begin;
        nickStyle.length = name.length();
        chatArea.setStyleRange(nickStyle);

        begin = chatArea.getCharCount();
        chatArea.append(message + '\n');
        StyleRange messageStyle = new StyleRange();
        messageStyle.start = begin;
        messageStyle.length = message.length();
        chatArea.setStyleRange(messageStyle);
    }

}
