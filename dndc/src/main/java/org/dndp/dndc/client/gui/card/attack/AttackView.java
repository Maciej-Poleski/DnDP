package org.dndp.dndc.client.gui.card.attack;

import java.util.Arrays;
import java.util.Observable;
import java.util.Observer;

import org.dndp.dndc.client.gui.SWTResourceManager;
import org.dndp.dndc.engine.card.attack.Attack;
import org.dndp.dndc.engine.card.attack.BaseAttack;
import org.dndp.dndc.engine.card.attack.BaseBonusToAttack;
import org.dndp.dndc.engine.card.attack.GrappleAttack;
import org.dndp.dndc.engine.card.attack.Initiative;
import org.dndp.dndc.engine.card.attack.MeleeAttack;
import org.dndp.dndc.engine.card.attack.RangeAttack;
import org.dndp.dndc.engine.card.attack.Speed;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

/**
 * Widok ataku. Wyświetla bazow prewmie oraz premie dla wszystkich typw ataku.
 * 
 * @author evil,bambucha
 */
public class AttackView extends Composite implements Observer, ModifyListener
{
    private Text   baseAttack3Text;
    private Text   baseAttack2Text;
    private Text   baseAttack1Text;
    private Text   meleeSumAttack3Text;
    private Text   baseAttack4Text;
    private Text   meleeSumAttack1Text;
    private Text   meleeSumAttack2Text;
    private Text   meleeSumAttack4Text;
    private Text   distanceAttack1Text;
    private Text   distanceAttack2Text;
    private Text   distanceAttack3Text;
    private Text   distanceAttack4Text;
    private Label  lblInicjatywa;
    private Text   initiativeText;
    private Label  lblSzybko;
    private Text   speedText;

    private Attack model;
    private Group  grpBazowy;
    private Group  grpWrcz;
    private Group  grpDystansowe;
    private Group  grpZwarcie;
    private Text   grappleAttackText;
    private Label  label;
    private Label  label_1;

    /**
     * Create the composite.
     * 
     * @param parent
     * @param style
     */
    public AttackView(Composite parent, int style, Attack model)
    {
        super(parent, style);
        setLayout(new FillLayout(SWT.HORIZONTAL));

        Group grpWalka = new Group(this, SWT.NONE);
        grpWalka.setText("Walka");
        grpWalka.setLayout(new GridLayout(4, false));

        grpBazowy = new Group(grpWalka, SWT.NONE);
        grpBazowy.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false,
                false, 1, 1));
        grpBazowy.setText("Bazowy");
        grpBazowy.setLayout(new FillLayout(SWT.VERTICAL));

        baseAttack1Text = new Text(grpBazowy, SWT.BORDER);

        baseAttack2Text = new Text(grpBazowy, SWT.BORDER);

        baseAttack3Text = new Text(grpBazowy, SWT.BORDER);

        baseAttack4Text = new Text(grpBazowy, SWT.BORDER);
        baseAttack4Text.addModifyListener(this);
        baseAttack3Text.addModifyListener(this);
        baseAttack2Text.addModifyListener(this);

        baseAttack1Text.addModifyListener(this);

        grpWrcz = new Group(grpWalka, SWT.NONE);
        grpWrcz.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false,
                1, 1));
        grpWrcz.setText("Wręcz");
        grpWrcz.setLayout(new FillLayout(SWT.VERTICAL));

        meleeSumAttack1Text = new Text(grpWrcz, SWT.BORDER);
        meleeSumAttack1Text.setEditable(false);

        meleeSumAttack2Text = new Text(grpWrcz, SWT.BORDER);
        meleeSumAttack2Text.setEditable(false);

        meleeSumAttack3Text = new Text(grpWrcz, SWT.BORDER);
        meleeSumAttack3Text.setEditable(false);

        meleeSumAttack4Text = new Text(grpWrcz, SWT.BORDER);
        meleeSumAttack4Text.setEditable(false);

        grpDystansowe = new Group(grpWalka, SWT.NONE);
        grpDystansowe.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false,
                false, 1, 1));
        grpDystansowe.setText("Dystansowe");
        grpDystansowe.setLayout(new FillLayout(SWT.VERTICAL));

        distanceAttack1Text = new Text(grpDystansowe, SWT.BORDER);
        distanceAttack1Text.setEditable(false);

        distanceAttack2Text = new Text(grpDystansowe, SWT.BORDER);
        distanceAttack2Text.setEditable(false);

        distanceAttack3Text = new Text(grpDystansowe, SWT.BORDER);
        distanceAttack3Text.setEditable(false);

        distanceAttack4Text = new Text(grpDystansowe, SWT.BORDER);
        distanceAttack4Text.setEditable(false);

        grpZwarcie = new Group(grpWalka, SWT.NONE);
        grpZwarcie.setLayout(new GridLayout(1, false));
        grpZwarcie.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false,
                1, 1));
        grpZwarcie.setText("Zwarcie");

        label = new Label(grpZwarcie, SWT.NONE);
        label.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, true, 1,
                1));

        grappleAttackText = new Text(grpZwarcie, SWT.BORDER);
        grappleAttackText.setEditable(false);
        grappleAttackText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER,
                true, false, 1, 2));

        label_1 = new Label(grpZwarcie, SWT.NONE);
        label_1.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, true,
                1, 1));

        lblInicjatywa = new Label(grpWalka, SWT.NONE);
        lblInicjatywa.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false,
                false, 1, 1));
        lblInicjatywa.setText("Inicjatywa");

        initiativeText = new Text(grpWalka, SWT.BORDER);
        initiativeText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
                false, 1, 1));

        lblSzybko = new Label(grpWalka, SWT.NONE);
        lblSzybko.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false,
                false, 1, 1));
        lblSzybko.setText("Szybkość");

        speedText = new Text(grpWalka, SWT.BORDER);
        speedText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false,
                1, 1));

        setModel(model);
    }

    @Override
    public void update(Observable o, Object arg)
    {
        if(o instanceof MeleeAttack)
        {
            meleeSumAttack1Text.setText("");
            meleeSumAttack2Text.setText("");
            meleeSumAttack3Text.setText("");
            meleeSumAttack4Text.setText("");
            int[] x = ((BaseAttack)o).getAttacks().getMainHand();
            if(x.length > 0)
                meleeSumAttack1Text.setText(Integer.toString(x[0]));
            if(x.length > 1)
                meleeSumAttack2Text.setText(Integer.toString(x[1]));
            if(x.length > 2)
                meleeSumAttack3Text.setText(Integer.toString(x[2]));
            if(x.length > 3)
                meleeSumAttack4Text.setText(Integer.toString(x[3]));
        }
        if(o instanceof RangeAttack)
        {

            distanceAttack1Text.setText("");
            distanceAttack2Text.setText("");
            distanceAttack3Text.setText("");
            distanceAttack4Text.setText("");
            int[] x = ((BaseAttack)o).getAttacks().getMainHand();
            if(x.length > 0)
                distanceAttack1Text.setText(Integer.toString(x[0]));
            if(x.length > 1)
                distanceAttack2Text.setText(Integer.toString(x[1]));
            if(x.length > 2)
                distanceAttack3Text.setText(Integer.toString(x[2]));
            if(x.length > 3)
                distanceAttack4Text.setText(Integer.toString(x[3]));
        }
        if(o instanceof GrappleAttack)
        {
            int[] x = ((BaseAttack)o).getAttacks().getMainHand();
            if(x.length > 0)
                grappleAttackText.setText(Integer.toString(x[0]));
        }
        if(o instanceof Initiative)
            initiativeText.setText(arg.toString());
        if(o instanceof Speed)
            speedText.setText(arg.toString());
    }

    @Override
    public void modifyText(ModifyEvent arg0)
    {
        updateModel();
    }

    /**
     * Nakłada zmianny z GUI na model.
     */
    private void updateModel()
    {
        int[] tmp = new int[4];
        if((tmp[0] = parseField(baseAttack1Text)) < 0)
        {
            model.setBaseAttack(new BaseBonusToAttack(Arrays.copyOf(tmp, 0)));
            return;
        }
        if((tmp[1] = parseField(baseAttack2Text)) < 0)
        {
            model.setBaseAttack(new BaseBonusToAttack(Arrays.copyOf(tmp, 1)));
            return;
        }
        if((tmp[2] = parseField(baseAttack3Text)) < 0)
        {
            model.setBaseAttack(new BaseBonusToAttack(Arrays.copyOf(tmp, 2)));
            return;
        }
        if((tmp[3] = parseField(baseAttack4Text)) < 0)
        {
            model.setBaseAttack(new BaseBonusToAttack(Arrays.copyOf(tmp, 3)));
            return;
        }
        model.setBaseAttack(new BaseBonusToAttack(tmp));
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
            if(field.getText().equals(""))
                return -1;
            return Integer.parseInt(field.getText());
        }
        catch(NumberFormatException e)
        {
            field.setBackground(SWTResourceManager.getColor(SWT.COLOR_RED));
            return -1;
        }
    }

    @Override
    protected void checkSubclass()
    {
        // Disable the check that prevents subclassing of SWT components
    }

    /**
     * Ustawia model.
     * 
     * @param model
     */
    public void setModel(Attack model)
    {
        this.model = model;
        this.model.addAttackObserver(this);
    }
}
