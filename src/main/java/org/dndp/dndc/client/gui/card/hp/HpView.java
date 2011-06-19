package org.dndp.dndc.client.gui.card.hp;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class HpView extends Group
{
    private Text hpText;
    private Text maxHpText;

    /**
     * Create the composite.
     * @param parent
     * @param style
     */
    public HpView(Composite parent, int style)
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

    }

    @Override
    protected void checkSubclass()
    {
        // Disable the check that prevents subclassing of SWT components
    }

}
