package org.dndp.dndc.client.gui.card;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.dndp.dndc.engine.card.skills.SkillManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;



/**
 * Widok wszystkich umiejętności postaci
 *
 * 
 * @author bambucha
 */
public class SkillsView extends Composite
{
    private List<SkillView> skillList;
    
    public SkillsView(Composite parent, int style,SkillManager skillManager)
    {
        super(parent,style);
        skillList = new ArrayList<SkillView>();
        
        this.setLayout(new GridLayout(1,true));
        
        Set<String> nameSet = skillManager.getSkilNameSet();
        for(String name:nameSet)
            skillList.add(new SkillView(this, SWT.NONE,skillManager.getSkil(name)));
    }
}
