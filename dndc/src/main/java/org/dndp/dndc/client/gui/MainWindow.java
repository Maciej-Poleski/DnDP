package org.dndp.dndc.client.gui;

import org.dndp.dndc.client.gui.card.abilities.AbilitiesView;
import org.dndp.dndc.client.gui.card.armor.ArmorView;
import org.dndp.dndc.client.gui.card.attack.AttackView;
import org.dndp.dndc.client.gui.card.classes.ClassesView;
import org.dndp.dndc.client.gui.card.description.DescriptionView;
import org.dndp.dndc.client.gui.card.fleats.FleatsView;
import org.dndp.dndc.client.gui.card.hp.HpView;
import org.dndp.dndc.client.gui.card.skills.SkillsView;
import org.dndp.dndc.engine.FantasyCharacter;
import org.eclipse.jface.window.ApplicationWindow;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Layout;

/**
 * Głowne okno programu.
 * 
 * @author bambucha
 */
public class MainWindow extends ApplicationWindow
{

    // FIXME: Usunięcie pola i danie przez wstrzykiwaniem konstrukotrem/seterem
    private FantasyCharacter fantasyCharacter;

    private ClassesView      classesView;
    private DescriptionView  descriptionView;
    private AbilitiesView    abilitiesView;
    private HpView           hpView;
    private ArmorView        armorView;
    private AttackView       attackView;
    private FleatsView       fleatsView;
    private SkillsView       skillsView;

    public MainWindow(FantasyCharacter model)
    {
        super(null);
        this.fantasyCharacter = model;
        addMenuBar();
    }

    /**
     * @wbp.parser.constructor
     */
    public MainWindow()
    {
        super(null);
        this.fantasyCharacter = new FantasyCharacter();
    }

    @Override
    protected Control createContents(Composite parent)
    {
        Composite shell = new Composite(parent, SWT.NONE);
        Layout gl_shell = new FormLayout();

        shell.setLayout(gl_shell);
        FormData data;

        descriptionView = new DescriptionView(shell, SWT.NONE, fantasyCharacter);
        abilitiesView = new AbilitiesView(shell, SWT.NONE, fantasyCharacter);
        hpView = new HpView(shell, SWT.NONE, fantasyCharacter);
        classesView = new ClassesView(shell, SWT.NONE, fantasyCharacter);
        armorView = new ArmorView(shell, SWT.NONE, fantasyCharacter);
        attackView = new AttackView(shell, SWT.NONE, fantasyCharacter);
        fleatsView = new FleatsView(shell, SWT.NONE, fantasyCharacter);

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

        return shell;
    }

    public FantasyCharacter getFantasyCharacter()
    {

        return fantasyCharacter;
    }

    public void setFantasyCharacter(FantasyCharacter fantasyCharacter)
    {
        descriptionView.setModel(fantasyCharacter);
        hpView.setModel(fantasyCharacter);
        abilitiesView.setModel(fantasyCharacter);
        armorView.setModel(fantasyCharacter);
        attackView.setModel(fantasyCharacter);
        classesView.setModel(fantasyCharacter);
        fleatsView.setModel(fantasyCharacter);
        skillsView.setModel(fantasyCharacter);
        this.fantasyCharacter = fantasyCharacter;
    }
}
