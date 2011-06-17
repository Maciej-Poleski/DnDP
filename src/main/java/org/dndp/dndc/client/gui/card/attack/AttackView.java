package org.dndp.dndc.client.gui.card.attack;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.layout.GridData;

public class AttackView extends Composite
{
    private Text text;
    private Text text_1;
    private Text text_2;
    private Text text_3;
    private Text text_4;
    private Text text_5;
    private Text text_6;
    private Text text_7;
    private Text text_8;
    private Text text_9;
    private Text text_10;
    private Text text_11;
    private Text text_12;
    private Text text_13;
    private Text text_14;
    private Text text_15;
    private Text text_16;
    private Text text_17;
    private Text text_18;
    private Text text_19;
    private Label lblInicjatywa;
    private Text text_20;
    private Label lblSzybko;
    private Text text_21;

    /**
     * Create the composite.
     * @param parent
     * @param style
     */
    public AttackView(Composite parent, int style)
    {
        super(parent, style);
        setLayout(new FillLayout(SWT.HORIZONTAL));
        
        Group grpWalka = new Group(this, SWT.NONE);
        grpWalka.setText("Walka");
        grpWalka.setLayout(new GridLayout(11, false));
        new Label(grpWalka, SWT.NONE);
        new Label(grpWalka, SWT.NONE);
        
        text_4 = new Text(grpWalka, SWT.BORDER);
        text_4.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
        
        text_8 = new Text(grpWalka, SWT.BORDER);
        text_8.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
        new Label(grpWalka, SWT.NONE);
        new Label(grpWalka, SWT.NONE);
        
        text_12 = new Text(grpWalka, SWT.BORDER);
        text_12.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
        new Label(grpWalka, SWT.NONE);
        new Label(grpWalka, SWT.NONE);
        new Label(grpWalka, SWT.NONE);
        new Label(grpWalka, SWT.NONE);
        
        text = new Text(grpWalka, SWT.BORDER);
        text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 2));
        
        text_1 = new Text(grpWalka, SWT.BORDER);
        text_1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 2));
        
        text_3 = new Text(grpWalka, SWT.BORDER);
        text_3.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
        
        text_9 = new Text(grpWalka, SWT.BORDER);
        text_9.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
        
        text_6 = new Text(grpWalka, SWT.BORDER);
        text_6.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 2));
        
        text_11 = new Text(grpWalka, SWT.BORDER);
        text_11.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 2));
        
        text_13 = new Text(grpWalka, SWT.BORDER);
        text_13.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
        
        text_16 = new Text(grpWalka, SWT.BORDER);
        text_16.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 2));
        
        text_17 = new Text(grpWalka, SWT.BORDER);
        text_17.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 2));
        
        text_18 = new Text(grpWalka, SWT.BORDER);
        text_18.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 2));
        
        text_19 = new Text(grpWalka, SWT.BORDER);
        text_19.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 2));
        
        text_2 = new Text(grpWalka, SWT.BORDER);
        text_2.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
        
        text_5 = new Text(grpWalka, SWT.BORDER);
        text_5.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
        
        text_14 = new Text(grpWalka, SWT.BORDER);
        text_14.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
        new Label(grpWalka, SWT.NONE);
        new Label(grpWalka, SWT.NONE);
        
        text_7 = new Text(grpWalka, SWT.BORDER);
        text_7.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
        
        text_10 = new Text(grpWalka, SWT.BORDER);
        text_10.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
        new Label(grpWalka, SWT.NONE);
        new Label(grpWalka, SWT.NONE);
        
        text_15 = new Text(grpWalka, SWT.BORDER);
        text_15.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
        new Label(grpWalka, SWT.NONE);
        new Label(grpWalka, SWT.NONE);
        new Label(grpWalka, SWT.NONE);
        new Label(grpWalka, SWT.NONE);
        
        lblInicjatywa = new Label(grpWalka, SWT.NONE);
        lblInicjatywa.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 2, 1));
        lblInicjatywa.setText("Inicjatywa");
        
        text_20 = new Text(grpWalka, SWT.BORDER);
        text_20.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
        new Label(grpWalka, SWT.NONE);
        
        lblSzybko = new Label(grpWalka, SWT.NONE);
        lblSzybko.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 2, 1));
        lblSzybko.setText("Szybkoś");
        
        text_21 = new Text(grpWalka, SWT.BORDER);
        text_21.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
        new Label(grpWalka, SWT.NONE);
        new Label(grpWalka, SWT.NONE);
        new Label(grpWalka, SWT.NONE);
        new Label(grpWalka, SWT.NONE);

    }

    @Override
    protected void checkSubclass()
    {
        // Disable the check that prevents subclassing of SWT components
    }

}
