package org.dndp.dndc.client.gui;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.dndp.dndc.client.gui.action.FantasyCharacterSave;
import org.dndp.dndc.client.gui.card.abilities.AbilitiesView;
import org.dndp.dndc.client.gui.card.armor.ArmorView;
import org.dndp.dndc.client.gui.card.attack.AttackView;
import org.dndp.dndc.client.gui.card.classes.ClassesView;
import org.dndp.dndc.client.gui.card.description.DescriptionView;
import org.dndp.dndc.client.gui.card.fleats.FleatsView;
import org.dndp.dndc.client.gui.card.hp.HpView;
import org.dndp.dndc.client.gui.card.skills.SkillsView;
import org.dndp.dndc.engine.FantasyCharacter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Layout;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;

/**
 * Głowne okno programu.
 * 
 * @author bambucha
 */
public class MainWindow extends Thread
{
    private Display              display;
    private Shell                shell;
    private FantasyCharacter     fantasyCharacter;

    private ClassesView          classesView;
    private DescriptionView      descriptionView;
    private AbilitiesView        abilitiesView;
    private HpView               hpView;
    private ArmorView            armorView;
    private AttackView           attackView;
    private FleatsView           fleatsView;
    private SkillsView           skillsView;

    private FantasyCharacterSave saveAction;

    public MainWindow()
    {
        // this.chat = chat;
        fantasyCharacter = new FantasyCharacter();
    }

    private void build()
    {
        Layout gl_shell = new FormLayout();

        shell.setLayout(gl_shell);
        shell.setText("DnDC - 0.1");
        FormData data;

        descriptionView = new DescriptionView(shell, SWT.NONE, fantasyCharacter);
        abilitiesView = new AbilitiesView(shell, SWT.NONE, fantasyCharacter);
        hpView = new HpView(shell, SWT.NONE, fantasyCharacter);
        classesView = new ClassesView(shell, SWT.NONE, fantasyCharacter);
        armorView = new ArmorView(shell, SWT.NONE, fantasyCharacter);
        attackView = new AttackView(shell, SWT.NONE, fantasyCharacter);
        fleatsView = new FleatsView(shell, SWT.NONE, fantasyCharacter);
        skillsView = new SkillsView(shell, SWT.NONE, fantasyCharacter);
        skillsView.setLayoutData(new FormData());

        data = new FormData(SWT.DEFAULT, SWT.DEFAULT);
        data.top = new FormAttachment(0);
        data.left = new FormAttachment(0);
        data.right = new FormAttachment(classesView, 0, SWT.RIGHT);
        descriptionView.setLayoutData(data);

        data = new FormData(SWT.DEFAULT, SWT.DEFAULT);
        data.top = new FormAttachment(descriptionView);
        data.left = new FormAttachment(0);
        abilitiesView.setLayoutData(data);

        data = new FormData(SWT.DEFAULT, SWT.DEFAULT);
        data.top = new FormAttachment(0);
        data.left = new FormAttachment(descriptionView);
        data.right = new FormAttachment(armorView, 0, SWT.RIGHT);
        hpView.setLayoutData(data);

        data = new FormData(SWT.DEFAULT, SWT.DEFAULT);
        data.top = new FormAttachment(descriptionView);
        data.left = new FormAttachment(abilitiesView);
        // data.right = new FormAttachment(100);
        classesView.setLayoutData(data);

        data = new FormData(SWT.DEFAULT, SWT.DEFAULT);
        data.top = new FormAttachment(hpView);
        data.left = new FormAttachment(classesView);
        data.right = new FormAttachment(100);
        data.bottom = new FormAttachment(classesView, 0, SWT.BOTTOM);
        armorView.setLayoutData(data);

        data = new FormData(SWT.DEFAULT, SWT.DEFAULT);
        data.top = new FormAttachment(classesView);
        data.left = new FormAttachment(abilitiesView);
        attackView.setLayoutData(data);

        data = new FormData(SWT.DEFAULT, SWT.DEFAULT);
        data.top = new FormAttachment(abilitiesView);
        data.left = new FormAttachment(0);
        data.right = new FormAttachment(attackView);
        data.bottom = new FormAttachment(100);
        fleatsView.setLayoutData(data);

        skillsView = new SkillsView(shell, SWT.NONE, fantasyCharacter);
        data = new FormData(SWT.DEFAULT, SWT.DEFAULT);
        data.top = new FormAttachment(classesView);
        data.left = new FormAttachment(attackView);
        data.right = new FormAttachment(100);
        data.bottom = new FormAttachment(100);
        skillsView.setLayoutData(data);

        saveAction = new FantasyCharacterSave(this);

        Menu menu = new Menu(shell, SWT.BAR);
        shell.setMenuBar(menu);

        MenuItem FileCascadeMenuItem = new MenuItem(menu, SWT.CASCADE);
        FileCascadeMenuItem.setText("Plik");

        Menu menu_1 = new Menu(FileCascadeMenuItem);
        FileCascadeMenuItem.setMenu(menu_1);

        MenuItem mntmWczytaj = new MenuItem(menu_1, SWT.NONE);
        mntmWczytaj.setText("Wczytaj");

        MenuItem mntmZapisz = new MenuItem(menu_1, SWT.NONE);
        mntmZapisz.setText("Zapisz");
        mntmZapisz.addSelectionListener(new SelectionListener()
        {

            @Override
            public void widgetSelected(SelectionEvent arg0)
            {
                saveAction.run();
            }

            @Override
            public void widgetDefaultSelected(SelectionEvent arg0)
            {
                saveAction.run();
            }
        });

        new MenuItem(menu_1, SWT.SEPARATOR);

        MenuItem mntmZakocz = new MenuItem(menu_1, SWT.NONE);
        mntmZakocz.setText("Zakończ");

        // shell.pack();
        shell.open();
    }

    public FantasyCharacter getFantasyCharacter()
    {
        return fantasyCharacter;
    }

    public Shell getShell()
    {
        return shell;
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
        while(!shell.isDisposed())
            if(!display.readAndDispatch())
                display.sleep();
        display.dispose();
    }

    public static void main(String args[])
    {
        Logger.getLogger("").setLevel(Level.WARNING);

        new MainWindow().start();
    }
}
