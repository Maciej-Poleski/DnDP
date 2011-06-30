package org.dndp.dndc.engine.card.classes;

import org.dndp.dndc.engine.benefit.Benefit;
import org.dndp.dndc.engine.card.skills.Skill;
import org.dndp.dndc.engine.check.Checkable;

/**
 * Przedstawia pojedynczą klasę postaci.
 * 
 * @author bambucha
 */
public class BaseClass
{
    private final String           name;
    private final AttackBonusLevel bonusType;
    private final boolean          highFortitudeBonus;
    private final boolean          highReflexeBonus;
    private final boolean          highWillBonus;
    private final Skill[]           classFleats;
    private final Benefit[][]      levelBenefitsList;

    /**
     * Standardowy konstruktor klasy postaci.
     * 
     * @param name
     *            Nazwa klasy postaci.
     * @param levelBenefitsList
     *            Lista premi w zależności od lvl.
     * @param bonusType
     *            Wysokość bazowej premi do ataku.
     * @param highFortitudeBonus
     *            Czy klasa ma wyski rzut na wytrzymałość.
     * @param highReflexeBonus
     *            Czy klasa ma wysoki rzut na refleks.
     * @param highWillBonus
     *            Czy klasa ma wysoki rzut na wolę.
     * @param classList
     *            Lista
     */
    public BaseClass(String name, Benefit[][] levelBenefitsList, AttackBonusLevel bonusType, boolean highFortitudeBonus,
            boolean highReflexeBonus, boolean highWillBonus, Skill[] classFleats)
    {
        super();
        this.name = name;
        this.levelBenefitsList = levelBenefitsList;
        this.bonusType = bonusType;
        this.highFortitudeBonus = highFortitudeBonus;
        this.highReflexeBonus = highReflexeBonus;
        this.highWillBonus = highWillBonus;
        this.classFleats = classFleats;
    }

    /**
     * Zwraca nazwę klasy postaci
     * @return Nazwa klasy postaci
     */
    public String getName()
    {
        return name;
    }

    /**
     * Zwraca tablicę premi wynikających z levelu
     * Pierwszy indeks to level
     * @return
     */
    public Benefit[][] getLevelBenefitsList()
    {
        return levelBenefitsList;
    }

    /**
     * Zwraca poziom przyrostu premi do ataku
     * @return
     */
    public AttackBonusLevel getBonusType()
    {
        return bonusType;
    }

    /**
     * Odpowiada czy dana klasa ma wysoką premię do testu na wytrzymałość.
     * @return
     */
    public boolean isHighFortitudeBonus()
    {
        return highFortitudeBonus;
    }

    /**
     * Odpowiada czy dana klasa ma wysoką premię do testu na refleks.
     * @return
     */
    public boolean isHighReflexeBonus()
    {
        return highReflexeBonus;
    }

    /**
     * Odpowiada czy dana klasa ma wysoką premię do testu na wolę.
     * @return
     */
    public boolean isHighWillBonus()
    {
        return highWillBonus;
    }

    /**
     * Zwraca listę umiejętności klasowych.
     * @return
     */
    public Skill[] getClassFleats()
    {
        return classFleats;
    }

    /**
     * Odpowiada na pytanie czy poziom w tej klasie jest brany podczas liczenia multiklasowości
     * @return
     */
    public boolean isUseInMulticlass()
    {
        return true;
    }

    /**
     * Zwraca warunki potrzebne by móc levelować w danej klasie.
     * @return
     */
    public Checkable[] getConditions()
    {
        return new Checkable[0];
    }
}
