package org.dndp.dndc.client.gui.card;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;

public class AbilitiesView extends Composite
{
    private AbilitiView strenght;
    private AbilitiView dexterity;
    private AbilitiView construction;
    private AbilitiView inteligence;
    private AbilitiView wisdom;
    private AbilitiView charisma;

    public AbilitiesView(Composite parent, int style)
    {
        super(parent, style);
        this.setLayout(new GridLayout(1, false));

        this.strenght = new AbilitiView(this, SWT.NONE, "strenght");
        this.dexterity = new AbilitiView(this, SWT.NONE, "dexterity");
        this.construction = new AbilitiView(this, SWT.NONE, "construction");
        this.inteligence = new AbilitiView(this, SWT.NONE, "inteligence");
        this.wisdom = new AbilitiView(this, SWT.NONE, "wisdom");
        this.charisma = new AbilitiView(this, SWT.NONE, "charisma");

        GridDataFactory factory = GridDataFactory.createFrom(new GridData(GridData.FILL, GridData.CENTER, true, true));
        factory.applyTo(strenght);
        factory.applyTo(dexterity);
        factory.applyTo(construction);
        factory.applyTo(inteligence);
        factory.applyTo(wisdom);
        factory.applyTo(charisma);

        this.pack();
    }

    public AbilitiView getStrenght()
    {
        return strenght;
    }

    public AbilitiView getDexterity()
    {
        return dexterity;
    }

    public AbilitiView getConstruction()
    {
        return construction;
    }

    public AbilitiView getInteligence()
    {
        return inteligence;
    }

    public AbilitiView getWisdom()
    {
        return wisdom;
    }

    public AbilitiView getCharisma()
    {
        return charisma;
    }

}
