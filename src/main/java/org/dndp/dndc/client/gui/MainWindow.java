package org.dndp.dndc.client.gui;

import org.dndp.dndc.client.gui.card.abilities.AbilitiesView;
import org.dndp.dndc.client.gui.chat.ChatPanel;
import org.dndp.dndc.engine.card.abilities.DnDAbilities;
import org.dndp.dndc.engine.card.bonus.BaseBonusHandler;
import org.dndp.dndc.engine.card.bonus.BonusManager;
import org.dndp.dndc.engine.card.bonus.Bonusable;
import org.dndp.dndc.engine.chat.Chat;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

/**
 * Głowne okno programu.
 *
 * @author bambucha
 */
public class MainWindow extends Thread
{
    private Display display;
    private Shell   shell;
    private ChatPanel chatPanel;
    private Chat chat;

    public MainWindow(Chat chat)
    {
        this.chat = chat;
    }

    private void build()
    {
        shell.setLayout(new FormLayout());
        chatPanel = new ChatPanel(shell, SWT.NO_FOCUS, chat );
        chat.setGui(chatPanel);
        FormData data = new FormData();
        data.top = new FormAttachment(0);
        data.bottom = new FormAttachment(100);
        data.left = new FormAttachment(0);
        data.right = new FormAttachment(100);
        chatPanel.setLayoutData(data);
        
        shell.pack();
        shell.open();
    }

    @Override
    public void run()
    {
        display = new Display();
        shell = new Shell(display);
        build();
        while (!shell.isDisposed())
            if(!display.readAndDispatch())
                display.sleep();
        display.dispose();
    }

    public ChatPanel getChat()
    {
        return chatPanel;
    }
    
    public static void main(String args[])
    {
        Display display = new Display();
        Shell shell = new Shell(display);
        shell.setLayout(new FormLayout());
        FormData data = new FormData();
        data.top = new FormAttachment(0);
        data.bottom = new FormAttachment(100);
        data.left = new FormAttachment(0);
        data.right = new FormAttachment(100);
        
        Composite comp = new AbilitiesView(shell, SWT.NONE, new DnDAbilities(new BonusManager()
        {
            
            @Override
            public void registerBonus(String name, Bonusable newBonus)
            {
                // TODO Auto-generated method stub
                
            }
            
            @Override
            public BaseBonusHandler getBonusHandler(String name)
            {
                // TODO Auto-generated method stub
                return null;
            }
        }));
        
        comp.setLayoutData(data);
        
        shell.pack();
        shell.open();
        
        while (!shell.isDisposed())
            if(!display.readAndDispatch())
                display.sleep();
        display.dispose();
    }
 
}
