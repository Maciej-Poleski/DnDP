package org.dndp.dndc.engine.card.classes;

import org.dndp.dndc.engine.benefit.Benefit;
import org.dndp.dndc.engine.card.skills.Skill;
import org.dndp.dndc.engine.check.Checkable;

/**
 * Opis klasy prestiżowej.
 * 
 * Opis w podręczniku mistrza podziemi.
 * 
 * @author bambucha
 */
public class PrestigeClass extends BaseClass
{
    private final Checkable[] conditions;

    /**
     * Konstruktor na potrzeby tworzenia i wpychania do bazy danych.
     * @param name Nazwa
     * @param levelBenefitsList list premi na level 
     * @param bonusType poziom wzrostu premi do ataku
     * @param highFortitudeBonus Czy klasa posiada wysoki poziom premi do wytrzymałości 
     * @param highReflexeBonus Czy klasa posiada wysoki poziom premi do refleksu
     * @param highWillBonus Czy klasa posiada wysoki poziom premi do woli
     * @param classSkills Lista umiejętności klasowych.
     * @param conditions Lista warunków do spełnienia by móc levelować.
     */
    public PrestigeClass(String name, Benefit[][] levelBenefitsList, AttackBonusLevel bonusType, boolean highFortitudeBonus,
            boolean highReflexeBonus, boolean highWillBonus, Skill[] classSkills, Checkable[] conditions)
    {
        super(name, levelBenefitsList, bonusType, highFortitudeBonus, highReflexeBonus, highWillBonus, classSkills);
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
