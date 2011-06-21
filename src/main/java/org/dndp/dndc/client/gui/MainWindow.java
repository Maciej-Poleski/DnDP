package org.dndp.dndc.client.gui;

import org.dndp.dndc.client.gui.card.abilities.AbilitiesView;
import org.dndp.dndc.client.gui.card.armor.ArmorView;
import org.dndp.dndc.client.gui.card.attack.AttackView;
import org.dndp.dndc.client.gui.card.classes.ClassesView;
import org.dndp.dndc.client.gui.card.description.DescriptionView;
import org.dndp.dndc.client.gui.card.fleats.FleatsView;
import org.dndp.dndc.client.gui.card.hp.HpView;
import org.dndp.dndc.client.gui.card.skills.SkillsView;
import org.dndp.dndc.client.gui.chat.ChatPanel;
import org.dndp.dndc.engine.FantasyCharacter;
import org.dndp.dndc.engine.chat.Chat;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Layout;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;

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
    //private Chat chat;
    private FantasyCharacter x;

    public MainWindow()
    {
        //this.chat = chat;
        x = new FantasyCharacter();
    }

    private void build()
    {
        Layout gl_shell = new FormLayout();
        //gl_shell.numColumns = 3;
        shell.setLayout(gl_shell);
        //chatPanel = new ChatPanel(shell, SWT.NO_FOCUS, chat );
        //chat.setGui(chatPanel);
        
        AbilitiesView abilitiesView = new AbilitiesView(shell, SWT.NONE, x);
        FormData data = new FormData(SWT.DEFAULT, SWT.DEFAULT);
        data.top = new FormAttachment(0);
        data.left = new FormAttachment(0);
        abilitiesView.setLayoutData(data);
        ArmorView armorView = new ArmorView(shell, SWT.NONE, x);
        AttackView attackView = new AttackView(shell, SWT.NONE, x);
        HpView hpView = new HpView(shell, SWT.NONE, x);
        ArmorView armorView_1 = new ArmorView(shell, SWT.NONE, x);
        DescriptionView descriptionView = new DescriptionView(shell, SWT.NONE, x);

        ClassesView classesView = new ClassesView(shell, SWT.NONE, x);
        FleatsView fleatsView = new FleatsView(shell, SWT.NONE, x);
        SkillsView skillsView = new SkillsView(shell, SWT.NONE, x);
        
        
        
        //shell.pack();
        shell.open();
    }

    /**
     * @wbp.parser.entryPoint
     */
    @Override
    public void run()
    {
        display = new Display();
        shell = new Shell(display);
        shell.setSize(921, 609);
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
        new MainWindow().start();
    }
    
 
}
