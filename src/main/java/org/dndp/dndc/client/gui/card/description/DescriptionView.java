package org.dndp.dndc.client.gui.card.description;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;

public class DescriptionView extends Group
{
    private Text raceText;
    private Text religionText;
    private Text alignmentText;
    private Text personalityTypeText;
    private Text ageText;
    private Text weightText;
    private Text sizeText;
    private Text genderText;
    private Text nameText;
    private Text playerText;

    /**
     * Create the composite.
     * @param parent
     * @param style
     */
    public DescriptionView(Composite parent, int style)
    {
        super(parent, style);
        setText("Opis");
        setLayout(new GridLayout(8, false));
        
        nameText = new Text(this, SWT.BORDER);
        nameText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 4, 1));
        
        playerText = new Text(this, SWT.BORDER);
        playerText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 4, 1));
        
        raceText = new Text(this, SWT.BORDER);
        raceText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
        
        religionText = new Text(this, SWT.BORDER);
        religionText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
        
        alignmentText = new Text(this, SWT.BORDER);
        alignmentText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
        
        personalityTypeText = new Text(this, SWT.BORDER);
        personalityTypeText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
        
        ageText = new Text(this, SWT.BORDER);
        ageText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
        
        weightText = new Text(this, SWT.BORDER);
        weightText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
        
        sizeText = new Text(this, SWT.BORDER);
        sizeText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
        
        genderText = new Text(this, SWT.BORDER);
        genderText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

    }

    @Override
    protected void checkSubclass()
    {
        // Disable the check that prevents subclassing of SWT components
    }

}
