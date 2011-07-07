package org.dndp.dndc.client.gui.card.st;

import java.util.Observable;
import java.util.Observer;

import org.dndp.dndc.client.gui.SWTResourceManager;
import org.dndp.dndc.engine.card.st.SavingThrows;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

/**
 * Widok rzutów obronnych postaci.
 * 
 * @author bambucha
 * 
 */
public class StView extends Group implements Observer, ModifyListener
{
    private Text         fortitudeText;
    private Text         reflexesTest;
    private Text         willText;
    private Text         spellResistanceText;
    private SavingThrows model;
    private Text         baseFortitudeText;
    private Text         baseReflexesText;
    private Text         baseWillText;

    /**
     * Create the composite.
     * 
     * @param parent
     * @param style
     */
    public StView(Composite parent, int style, SavingThrows model)
    {
        super(parent, style);
        setLayout(new GridLayout(3, false));

        Label lblWytrzymao = new Label(this, SWT.NONE);
        lblWytrzymao.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false,
                false, 1, 1));
        lblWytrzymao.setText("Wytrzymałoś");

        fortitudeText = new Text(this, SWT.BORDER | SWT.RIGHT);
        fortitudeText.setEditable(false);
        fortitudeText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
                false, 1, 1));

        baseFortitudeText = new Text(this, SWT.BORDER | SWT.RIGHT);
        baseFortitudeText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER,
                true, false, 1, 1));

        Label lblRefleks = new Label(this, SWT.NONE);
        lblRefleks.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false,
                false, 1, 1));
        lblRefleks.setText("Refleks");

        reflexesTest = new Text(this, SWT.BORDER | SWT.RIGHT);
        reflexesTest.setEditable(false);
        reflexesTest.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
                false, 1, 1));

        baseReflexesText = new Text(this, SWT.BORDER | SWT.RIGHT);
        baseReflexesText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
                false, 1, 1));

        Label lblWola = new Label(this, SWT.NONE);
        lblWola.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false,
                1, 1));
        lblWola.setText("Wola");

        willText = new Text(this, SWT.BORDER | SWT.RIGHT);
        willText.setEditable(false);
        willText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false,
                1, 1));

        baseWillText = new Text(this, SWT.BORDER | SWT.RIGHT);
        baseWillText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
                false, 1, 1));

        Label lblOdpornoNaCzary = new Label(this, SWT.NONE);
        lblOdpornoNaCzary.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER,
                false, false, 1, 1));
        lblOdpornoNaCzary.setText("Odpornoś na czary");

        spellResistanceText = new Text(this, SWT.BORDER | SWT.RIGHT);
        spellResistanceText.setEditable(false);
        spellResistanceText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER,
                true, false, 2, 1));

        setModel(model);
        baseFortitudeText.addModifyListener(this);
        baseReflexesText.addModifyListener(this);
        baseWillText.addModifyListener(this);
        model.addSavingThrowObserver(this);

    }

    /**
     * @param model
     *            the model to set
     */
    public void setModel(SavingThrows model)
    {
        this.model = model;
    }

    @Override
    protected void checkSubclass()
    {
        // Disable the check that prevents subclassing of SWT components
    }

    @Override
    public void update(Observable o, Object arg)
    {
        if(o instanceof SavingThrows)
        {
            SavingThrows tmp = (SavingThrows)o;
            fortitudeText.setText(tmp.getForttiude().getBonus().toString());
            baseFortitudeText.setText(tmp.getForttiude().getBaseModifier()
                    .toString());
            reflexesTest.setText(tmp.getReflex().getBonus().toString());
            baseReflexesText.setText(tmp.getReflex().getBaseModifier()
                    .toString());
            willText.setText(tmp.getWill().getBonus().toString());
            baseWillText.setText(tmp.getWill().getBaseModifier().toString());
            spellResistanceText.setText(Double.toString(tmp
                    .getSpellResistance()));
        }

    }

    @Override
    public void modifyText(ModifyEvent ex)
    {
        try
        {
            model.getForttiude().setBaseModifier(
                    Integer.parseInt(baseFortitudeText.getText()));
            baseFortitudeText.setBackground(SWTResourceManager
                    .getColor(SWT.COLOR_WHITE));
        }
        catch(NumberFormatException e)
        {
            baseFortitudeText.setBackground(SWTResourceManager
                    .getColor(SWT.COLOR_RED));
        }

        try
        {
            model.getReflex().setBaseModifier(
                    Integer.parseInt(baseReflexesText.getText()));
            baseReflexesText.setBackground(SWTResourceManager
                    .getColor(SWT.COLOR_WHITE));
        }
        catch(NumberFormatException e)
        {
            baseReflexesText.setBackground(SWTResourceManager
                    .getColor(SWT.COLOR_RED));
        }

        try
        {
            model.getWill().setBaseModifier(
                    Integer.parseInt(baseWillText.getText()));
            baseWillText.setBackground(SWTResourceManager
                    .getColor(SWT.COLOR_WHITE));
        }
        catch(NumberFormatException e)
        {
            baseWillText.setBackground(SWTResourceManager
                    .getColor(SWT.COLOR_RED));
        }
    }
}
