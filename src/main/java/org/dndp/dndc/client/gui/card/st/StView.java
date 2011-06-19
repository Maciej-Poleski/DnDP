package org.dndp.dndc.client.gui.card.st;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class StView extends Group
{
    private Text fortitudeText;
    private Text reflexesTest;
    private Text willText;
    private Text spellResistanceText;

    /**
     * Create the composite.
     * @param parent
     * @param style
     */
    public StView(Composite parent, int style)
    {
        super(parent, style);
        setLayout(new GridLayout(2, false));
        
        Label lblWytrzymao = new Label(this, SWT.NONE);
        lblWytrzymao.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
        lblWytrzymao.setText("Wytrzymałoś");
        
        fortitudeText = new Text(this, SWT.BORDER);
        fortitudeText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
        
        Label lblRefleks = new Label(this, SWT.NONE);
        lblRefleks.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
        lblRefleks.setText("Refleks");
        
        reflexesTest = new Text(this, SWT.BORDER);
        reflexesTest.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
        
        Label lblWola = new Label(this, SWT.NONE);
        lblWola.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
        lblWola.setText("Wola");
        
        willText = new Text(this, SWT.BORDER);
        willText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
        
        Label lblOdpornoNaCzary = new Label(this, SWT.NONE);
        lblOdpornoNaCzary.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
        lblOdpornoNaCzary.setText("Odpornoś na czary");
        
        spellResistanceText = new Text(this, SWT.BORDER);
        spellResistanceText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

    }

    @Override
    protected void checkSubclass()
    {
        // Disable the check that prevents subclassing of SWT components
    }

}
