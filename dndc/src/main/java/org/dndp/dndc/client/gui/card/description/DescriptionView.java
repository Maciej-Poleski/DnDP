package org.dndp.dndc.client.gui.card.description;

import java.util.Observable;
import java.util.Observer;

import org.dndp.dndc.client.gui.SWTResourceManager;
import org.dndp.dndc.engine.PersonalityTypes;
import org.dndp.dndc.engine.card.description.Description;
import org.dndp.dndc.engine.card.description.Sex;
import org.dndp.dndc.engine.card.description.Size;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;

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
    private Combo       personalityTypeCombo;
    private Text        ageText;
    private Text        weightText;
    private Combo       sizeCombo;
    private Text        nameText;
    private Text        playerText;

    private Description model;
    private Combo       ganderCombo;

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
        GridLayout gridLayout = new GridLayout(8, false);
        gridLayout.marginTop = 5;
        setLayout(gridLayout);

        nameText = new Text(this, SWT.BORDER);
        nameText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false,
                4, 1));
        nameText.addModifyListener(this);

        playerText = new Text(this, SWT.BORDER);
        playerText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
                false, 4, 1));

        playerText.addModifyListener(this);

        raceText = new Text(this, SWT.BORDER);
        raceText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false,
                1, 1));

        religionText = new Text(this, SWT.BORDER);
        religionText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
                false, 1, 1));

        alignmentText = new Text(this, SWT.BORDER);
        alignmentText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
                false, 1, 1));

        personalityTypeCombo = new Combo(this, SWT.READ_ONLY);
        personalityTypeCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER,
                true, false, 1, 1));
        for(PersonalityTypes t : PersonalityTypes.values())
            personalityTypeCombo.add(t.getName());

        ageText = new Text(this, SWT.BORDER);
        ageText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false,
                1, 1));
        ageText.addModifyListener(this);

        weightText = new Text(this, SWT.BORDER);
        weightText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
                false, 1, 1));
        weightText.addModifyListener(this);

        sizeCombo = new Combo(this, SWT.READ_ONLY);
        sizeCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false,
                1, 1));
        for(Size s : Size.values())
            sizeCombo.add(s.name());

        ganderCombo = new Combo(this, SWT.READ_ONLY);
        ganderCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
                false, 1, 1));
        for(Sex s : Sex.values())
            ganderCombo.add(s.getName());

        setModel(model);
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
            // alignmentText.setText(tmp.getPersonality().getName());
            // tmp.
            // FIXME Dojść co to jest za pole ^^
            personalityTypeCombo.select(tmp.getPersonality().ordinal());
            ageText.setText(Integer.toString(tmp.getAge()));
            weightText.setText(Integer.toString(tmp.getWeight()));
            sizeCombo.select(tmp.getSize().ordinal());
            ganderCombo.select(tmp.getSex().ordinal());
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
        if(personalityTypeCombo.getSelectionIndex() > 0)
            model.setPersonality(PersonalityTypes.values()[personalityTypeCombo
                    .getSelectionIndex()]);
        if(sizeCombo.getSelectionIndex() > 0)
            model.setSize(Size.values()[sizeCombo.getSelectionIndex()]);
        if(ganderCombo.getSelectionIndex() > 0)
            model.setSex(Sex.values()[ganderCombo.getSelectionIndex()]);
    }

    public void setModel(Description model)
    {
        this.model = model;
        this.model.addDescriptionObserver(this);
    }
}
