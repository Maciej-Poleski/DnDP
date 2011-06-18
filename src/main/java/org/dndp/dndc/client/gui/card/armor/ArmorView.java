package org.dndp.dndc.client.gui.card.armor;

import java.util.Observable;
import java.util.Observer;

import org.dndp.dndc.engine.card.armor.Armor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class ArmorView extends Composite implements Observer
{
    private Text kpText;
    private Text flatFootedText;
    private Text touchText;

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
        
        kpText = new Text(grpKlasaPancerza, SWT.BORDER);
        kpText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
        
        Label lblNieprzygotowany = new Label(grpKlasaPancerza, SWT.NONE);
        lblNieprzygotowany.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
        lblNieprzygotowany.setText("Nieprzygotowany");
        
        flatFootedText = new Text(grpKlasaPancerza, SWT.BORDER);
        flatFootedText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
        
        Label lblDotykowy = new Label(grpKlasaPancerza, SWT.NONE);
        lblDotykowy.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
        lblDotykowy.setText("Dotykowy");
        
        touchText = new Text(grpKlasaPancerza, SWT.BORDER);
        touchText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
        
    }
    
    @Override
    public void update(Observable o, Object arg)
    {
        if(o instanceof Armor)
        {
            Armor tmp = (Armor)o;
            kpText.setText(tmp.getAC().toString());
            flatFootedText.setText(tmp.getFlatFootetAC().toString());
            touchText.setText(tmp.getTouchAttaksAC().toString());
        }
    }

    @Override
    protected void checkSubclass()
    {
        // Disable the check that prevents subclassing of SWT components
    }
}
