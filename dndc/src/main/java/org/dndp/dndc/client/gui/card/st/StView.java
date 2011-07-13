package org.dndp.dndc.client.gui.card.st;

import java.util.Observable;
import java.util.Observer;

import org.dndp.dndc.client.gui.SWTResourceManager;
import org.dndp.dndc.engine.card.st.SavingThrow;
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
public class StView extends Group implements Observer
{
    private Text         fortitudeText;
    private Text         reflexesTest;
    private Text         willText;
    private Text         spellResistanceText;
    private Text         baseFortitudeText;
    private Text         baseReflexesText;
    private Text         baseWillText;

    private SavingThrows model;

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
        setText("Rzuty Obronne");

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
        addListeners();
    }

    private void addListeners()
    {
        baseFortitudeText.addModifyListener(new ModifyListener()
        {
            @Override
            public void modifyText(ModifyEvent arg0)
            {
                pareseField(model.getForttiude(), baseFortitudeText);
            }
        });
        baseReflexesText.addModifyListener(new ModifyListener()
        {
            @Override
            public void modifyText(ModifyEvent arg0)
            {
                pareseField(model.getReflex(), baseReflexesText);
            }
        });
        baseWillText.addModifyListener(new ModifyListener()
        {
            @Override
            public void modifyText(ModifyEvent arg0)
            {
                pareseField(model.getWill(), baseWillText);
            }
        });
    }

    /**
     * @param model
     *            the model to set
     */
    public void setModel(SavingThrows model)
    {

        this.model = model;
        this.model.addSavingThrowObserver(this);
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

            fortitudeText.setText(tmp.getForttiude().getTotalModifier()
                    .toString());
            willText.setText(tmp.getWill().getTotalModifier().toString());
            reflexesTest.setText(tmp.getReflex().getTotalModifier().toString());
            spellResistanceText.setText(Double.toString(tmp
                    .getSpellResistance()));
            clear();
            baseWillText.setText(tmp.getWill().getBaseModifier().toString());
            baseFortitudeText.setText(tmp.getForttiude().getBaseModifier()
                    .toString());
            baseReflexesText.setText(tmp.getReflex().getBaseModifier()
                    .toString());
        }

    }

    private void pareseField(SavingThrow model, Text field)
    {
        try
        {
            model.setBaseModifier(Integer.parseInt(field.getText()));
            field.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
        }
        catch(NumberFormatException e)
        {
            field.setBackground(SWTResourceManager.getColor(SWT.COLOR_RED));
        }
    }

    public void clear()
    {
        baseFortitudeText.setText("");
        baseReflexesText.setText("");
        baseWillText.setText("");
    }
}
