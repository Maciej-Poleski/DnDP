package org.dndp.dndc.client.gui.card.abilities;

import org.dndp.dndc.engine.card.abilities.Abilities;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;

/**
 * Widok atrybutów.
 * 
 * Grupuje Abilitie View, by dać pełny mechanizm.
 * 
 * @author bambucha
 * 
 */
public class AbilitiesView extends Group
{

    private final AbilitiView strenght;
    private AbilitiView       dextarity;
    private AbilitiView       construction;
    private final AbilitiView inteligence;
    private AbilitiView       wisdom;
    private AbilitiView       charisma;

    /**
     * Create the composite.
     * 
     * @param parent
     * @param style
     */
    public AbilitiesView(Composite parent, int style, Abilities model)
    {
        super(parent, style);
        FillLayout fillLayout = new FillLayout(SWT.VERTICAL);
        fillLayout.marginHeight = 5;
        setLayout(fillLayout);
        setText("Atrybuty");

        strenght = new AbilitiView(this, SWT.NONE, "Siła", model.getStrenght());
        dextarity = new AbilitiView(this, SWT.NONE, "Zręczność",
                model.getDexterity());
        construction = new AbilitiView(this, SWT.NONE, "Budowa",
                model.getConstitution());
        inteligence = new AbilitiView(this, SWT.NONE, "Inteligęncja",
                model.getInteligence());
        wisdom = new AbilitiView(this, SWT.NONE, "Roztropność",
                model.getWisdom());
        charisma = new AbilitiView(this, SWT.NONE, "Charyzma",
                model.getCharisma());
    }

    @Override
    protected void checkSubclass()
    {
        // Disable the check that prevents subclassing of SWT components
    }

    public void setModel(Abilities model)
    {
        strenght.setModel(model.getStrenght());
        dextarity.setModel(model.getDexterity());
        construction.setModel(model.getConstitution());
        inteligence.setModel(model.getConstitution());
        wisdom.setModel(model.getConstitution());
        charisma.setModel(model.getConstitution());
    }
}
