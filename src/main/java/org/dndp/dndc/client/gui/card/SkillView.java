package org.dndp.dndc.client.gui.card;

import java.util.Observable;
import java.util.Observer;

import org.dndp.dndc.engine.card.skills.CharacterSkill;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

/**
 * Klasa będąca widokiem jednej umiejętności postaci.
 * 
 * @author bambucha
 */
public class SkillView extends Composite implements Observer
{
    private Label name;
    private Label all;
    private Label rank;
    private Label bonus;
    private Label sig;
    private Label plus;

    public SkillView(Composite parent, int style,CharacterSkill skill)
    {
        super(parent, style);
        skill.addObserver(this);
        
        RowLayout layout = new RowLayout();
        layout.marginTop = 5;
        layout.marginBottom = 5;
        layout.marginLeft = 5;
        layout.marginRight = 5;
        this.setLayout(layout);

        name = new Label(this, SWT.LEFT);
        all = new Label(this, SWT.CENTER);
        sig = new Label(this, SWT.CENTER);
        rank = new Label(this, SWT.CENTER);
        plus = new Label(this, SWT.CENTER);
        bonus = new Label(this, SWT.CENTER);

        name.setText(skill.getSkil().getName());
        all.setText(String.valueOf(skill.getRank() + skill.getBonus()));
        sig.setText(" = ");
        rank.setText(skill.getRank().toString());
        plus.setText(" + ");
        bonus.setText(skill.getRank().toString());
        
        
        this.setSize(300,300);
    }

    @Override
    public void update(Observable o, Object arg)
    {
        CharacterSkill source = (CharacterSkill)o;
        rank.setText(source.getRank().toString());
        bonus.setText(source.getRank().toString());
        all.setText(String.valueOf(source.getRank() + source.getBonus()));
    }
}
