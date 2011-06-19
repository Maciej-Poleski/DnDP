package org.dndp.dndc.client.gui.card.abilities;

import java.util.Observable;
import java.util.Observer;

import org.dndp.dndc.engine.card.abilities.Abiliti;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;

/**
 * Pojedynczy kompozyt zajmujacy się pokazaniem pojedynczego atrybuty.
 * @author evil,bambucha
 */
public class AbilitiView extends Composite implements Observer, ModifyListener
{
    private Text value;
    private Text modifier;
    private Abiliti model;
    
    /**
     * Create the composite.
     * @param parent
     * @param style
     */
    public AbilitiView(Composite parent, int style, String name, Abiliti model)
    {
        super(parent, style);
        setLayout(new GridLayout(3, false));
        
        model.addObserver(this);
        this.model = model;
        
        
        Label lblNewLabel = new Label(this, SWT.CENTER);
        lblNewLabel.setText(name);
        lblNewLabel.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, true, 1, 1));
        lblNewLabel.setAlignment(SWT.CENTER);
        
        
        value = new Text(this, SWT.BORDER | SWT.RIGHT);
        GridData gd_value = new GridData(SWT.CENTER, SWT.CENTER, false, true, 1, 1);
        gd_value.widthHint = 27;
        value.setLayoutData(gd_value);
        value.addModifyListener(this);
        
        
        modifier = new Text(this, SWT.BORDER | SWT.RIGHT);
        modifier.setEditable(false);
        GridData gd_modifier = new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1);
        gd_modifier.widthHint = 30;
        modifier.setLayoutData(gd_modifier);

    }

    @Override
    protected void checkSubclass()
    {
        // Disable the check that prevents subclassing of SWT components
    }

    /**
     * Updateuje z modelu potrzebne
     * @throw ClassCastException gdy obserwuje coś co nie jest atrybutem
     */
    @Override
    public void update(Observable o, Object arg)
    {
        Abiliti ab = (Abiliti)arg;
        value.setText(ab.getValue().toString());
        modifier.setText(ab.getModifier().toString());
    }

    /**
     * Zmienia wygląda pola, gdy zostają wprowadzone błędne dane.
     * Obsługuje zmiany i wpycha je na model.
     */
    @Override
    public void modifyText(ModifyEvent arg0)
    {
        try
        {
            model.setValue(Integer.parseInt(value.getText()));
            value.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
        }
        catch(NumberFormatException e)
        {
            value.setBackground(SWTResourceManager.getColor(SWT.COLOR_RED));
        }
    }
}
