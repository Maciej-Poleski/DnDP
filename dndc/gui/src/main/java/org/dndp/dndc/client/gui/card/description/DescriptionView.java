package org.dndp.dndc.client.gui.card.description;

import java.util.Observable;
import java.util.Observer;

import org.dndp.dndc.engine.card.description.Description;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;

/**
 * Klasa widok dla opisu postaci.
 * 
 * @author bambucha
 */
public class DescriptionView extends Group implements Observer, ModifyListener
{
    private Text        raceText;
    private Text        religionText;
    private Text        alignmentText;
    private Text        personalityTypeText;
    private Text        ageText;
    private Text        weightText;
    private Text        sizeText;
    private Text        genderText;
    private Text        nameText;
    private Text        playerText;

    private Description model;

    /**
     * Create the composite.
     * 
     * @param parent
     * @param style
     */
    public DescriptionView(Composite parent, int style, Description model)
    {
        super(parent, style);
        setText("Opis");
        setLayout(new GridLayout(8, false));

        nameText = new Text(this, SWT.BORDER);
        nameText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false,
                4, 1));

        playerText = new Text(this, SWT.BORDER);
        playerText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
                false, 4, 1));

        raceText = new Text(this, SWT.BORDER);
        raceText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false,
                1, 1));

        religionText = new Text(this, SWT.BORDER);
        religionText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
                false, 1, 1));

        alignmentText = new Text(this, SWT.BORDER);
        alignmentText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
                false, 1, 1));

        personalityTypeText = new Text(this, SWT.BORDER);
        personalityTypeText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER,
                true, false, 1, 1));

        ageText = new Text(this, SWT.BORDER);
        ageText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false,
                1, 1));

        weightText = new Text(this, SWT.BORDER);
        weightText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
                false, 1, 1));

        sizeText = new Text(this, SWT.BORDER);
        sizeText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false,
                1, 1));

        genderText = new Text(this, SWT.BORDER);
        genderText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
                false, 1, 1));

        playerText.addModifyListener(this);
        nameText.addModifyListener(this);
        ageText.addModifyListener(this);
        weightText.addModifyListener(this);
        setModel(model);
    }

    /**
     * @param model
     *            the model to set
     */
    public void setModel(Description model)
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
        if(o instanceof Description)
        {
            Description tmp = (Description)o;
            nameText.setText(tmp.getName());
            playerText.setText(tmp.getPlayer());
            raceText.setText(tmp.getRase().getName());
            religionText.setText(tmp.getGod().getName());
            alignmentText.setText(tmp.getPersonality().getName());
            // FIXME Dojść co to jest za pole ^^
            personalityTypeText.setText(tmp.getPersonality().toString());
            ageText.setText(Integer.toString(tmp.getAge()));
            weightText.setText(Integer.toString(tmp.getWeight()));
            sizeText.setText(tmp.getSize().name());
            genderText.setText(tmp.getSex().getName());
        }
    }

    /**
     * Zwraca zawartość pola, a w razie błędu koloruje je na czerowono.
     * 
     * @param field
     *            Pole do parsowania
     * @return zawartość pola
     */
    private int parseField(Text field)
    {
        try
        {
            field.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
            return Integer.parseInt(field.getText());
        }
        catch(NumberFormatException e)
        {
            field.setBackground(SWTResourceManager.getColor(SWT.COLOR_RED));
            return -1;
        }
    }

    @Override
    public void modifyText(ModifyEvent arg0)
    {
        updateModel();
    }

    private void updateModel()
    {
        // FIXME god, race, personalytyType, size, gender #55
        model.setName(nameText.getText());
        model.setPlayer(playerText.getText());
        if(parseField(ageText) > 0)
            model.setAge(parseField(ageText));
        if(parseField(weightText) > 0)
            model.setWeight(parseField(weightText));

    }
}
