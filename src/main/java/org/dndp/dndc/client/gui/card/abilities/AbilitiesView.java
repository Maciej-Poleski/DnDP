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

    /**
     * Create the composite.
     * 
     * @param parent
     * @param style
     */
    public AbilitiesView(Composite parent, int style, Abilities model)
    {
        super(parent, style);
        setLayout(new FillLayout(SWT.VERTICAL));
        setText("Atrybuty");

        new AbilitiView(this, SWT.NONE, "Siła", model.getStrenght());
        new AbilitiView(this, SWT.NONE, "Zręczność", model.getDexterity());
        new AbilitiView(this, SWT.NONE, "Budowa", model.getConstitution());
        new AbilitiView(this, SWT.NONE, "Inteligęncja", model.getInteligence());
        new AbilitiView(this, SWT.NONE, "Roztropność", model.getWisdom());
        new AbilitiView(this, SWT.NONE, "Charyzma", model.getCharisma());
    }

    @Override
    protected void checkSubclass()
    {
        // Disable the check that prevents subclassing of SWT components
    }
}
