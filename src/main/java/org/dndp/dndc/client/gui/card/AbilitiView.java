package org.dndp.dndc.client.gui.card;

import java.util.Observable;
import java.util.Observer;

import org.dndp.dndc.engine.card.abilities.Abiliti;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;


/**
 * Widok jednego atrybutu.
 * 
 * @author bambucha
 */
public class AbilitiView extends Composite implements Observer
{
    private Label nameLabel;
    private Label valueLable;
    private Label modifierLabel;

    public AbilitiView(Composite parent, int style, String name)
    {
        super(parent, style);

        this.setLayout(new GridLayout(3, false));

        this.nameLabel = new Label(this, SWT.LEFT);
        this.valueLable = new Label(this, SWT.CENTER);
        this.modifierLabel = new Label(this, SWT.CENTER);

        nameLabel.setLayoutData(new GridData(SWT.FILL, SWT.CENTER,true,true));
        valueLable.setLayoutData(new GridData(35, 25));
        modifierLabel.setLayoutData(new GridData(35, 25));

        //Do tworzenia layoutu
        nameLabel.setText(name);
        valueLable.setText("0");
        modifierLabel.setText("0");
    }

    /*
     * (non-Javadoc)
     * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
     */
    @Override
    public void update(Observable o, Object arg)
    {
        Abiliti temp = (Abiliti)arg;
        valueLable.setText(temp.getValue().toString());
        modifierLabel.setText(temp.getModifier().toString());
    }

}
