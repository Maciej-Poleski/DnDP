package org.dndp.dndc.client.gui.card.armor;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.wb.swt.layout.grouplayout.GroupLayout;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.FillLayout;

public class ArmorView extends Composite
{
    private Text text;
    private Text text_1;
    private Text text_2;

    /**
     * Create the composite.
     * @param parent
     * @param style
     */
    public ArmorView(Composite parent, int style)
    {
        super(parent, style);
        setLayout(new FillLayout(SWT.HORIZONTAL));
        
        Group grpKlasaPancerza = new Group(this, SWT.NONE);
        grpKlasaPancerza.setText("Klasa Pancerza");
        grpKlasaPancerza.setLayout(new GridLayout(2, false));
        
        Label lblKp = new Label(grpKlasaPancerza, SWT.NONE);
        lblKp.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
        lblKp.setText("KP");
        
        text = new Text(grpKlasaPancerza, SWT.BORDER);
        text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
        
        Label lblNieprzygotowany = new Label(grpKlasaPancerza, SWT.NONE);
        lblNieprzygotowany.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
        lblNieprzygotowany.setText("Nieprzygotowany");
        
        text_1 = new Text(grpKlasaPancerza, SWT.BORDER);
        text_1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
        
        Label lblDotykowy = new Label(grpKlasaPancerza, SWT.NONE);
        lblDotykowy.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
        lblDotykowy.setText("Dotykowy");
        
        text_2 = new Text(grpKlasaPancerza, SWT.BORDER);
        text_2.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
        
    }

    @Override
    protected void checkSubclass()
    {
        // Disable the check that prevents subclassing of SWT components
    }
}
