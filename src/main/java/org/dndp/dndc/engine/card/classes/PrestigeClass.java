package org.dndp.dndc.engine.card.classes;

import org.dndp.dndc.engine.benefit.Benefit;
import org.dndp.dndc.engine.card.skills.Skill;
import org.dndp.dndc.engine.check.Checkable;

/**
 * 
 * 
 * @author bambucha
 */
public class PrestigeClass extends BaseClass
{
    private final Checkable[] conditions;

    public PrestigeClass(String name, Benefit[][] levelBenefitsList, AttackBonusLevel bonusType, boolean highFortitudeBonus,
            boolean highReflexeBonus, boolean highWillBonus, Skill[] classFleats, Checkable[] conditions)
    {
        super(name, levelBenefitsList, bonusType, highFortitudeBonus, highReflexeBonus, highWillBonus, classFleats);
        this.conditions = conditions;
    }

    @Override
    public boolean isUseInMulticlass()
    {
        return false;
    }

    @Override
    public Checkable[] getConditions()
    {
        return conditions;
    }

}
