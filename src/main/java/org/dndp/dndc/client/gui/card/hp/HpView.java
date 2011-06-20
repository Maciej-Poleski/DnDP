package org.dndp.dndc.client.gui.card.hp;

import java.util.Observable;
import java.util.Observer;

import org.dndp.dndc.engine.card.hp.HitPoints;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;

public class HpView extends Group implements Observer, ModifyListener
{
    private Text hpText;
    private Text maxHpText;
    private HitPoints model;

    /**
     * Create the composite.
     * @param parent
     * @param style
     * @param model TODO
     */
    public HpView(Composite parent, int style, HitPoints model)
    {
        super(parent, style);
        setText("PŻ");
        setLayout(new GridLayout(2, false));
        
        Label lblNewLabel = new Label(this, SWT.NONE);
        lblNewLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
        lblNewLabel.setText("PŻ");
        
        hpText = new Text(this, SWT.BORDER);
        hpText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
        
        Label lblNewLabel_1 = new Label(this, SWT.NONE);
        lblNewLabel_1.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
        lblNewLabel_1.setText("MAX PŻ");
        
        maxHpText = new Text(this, SWT.BORDER);
        maxHpText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

        setModel(model);
        hpText.addModifyListener(this);
        maxHpText.addModifyListener(this);
        
    }

    /**
     * @param model the model to set
     */
    public void setModel(HitPoints model)
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
        if(o instanceof HitPoints)
        {
            HitPoints tmp=(HitPoints)o;
            hpText.setText(Integer.toString(tmp.getHP()));
            maxHpText.setText(Integer.toString(tmp.getMaxHP()));
        }
    }
    
    @Override
    public void modifyText(ModifyEvent e)
    {
        try
        {
            model.setHP(Integer.parseInt(hpText.getText()));
            hpText.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
        }
        catch(NumberFormatException e1)
        {
            hpText.setBackground(SWTResourceManager.getColor(SWT.COLOR_RED));
        }
        
        try
        {
            model.setMaxHP(Integer.parseInt(maxHpText.getText()));
            maxHpText.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
        }
        catch(NumberFormatException e1)
        {
            maxHpText.setBackground(SWTResourceManager.getColor(SWT.COLOR_RED));
        }
    }
}
