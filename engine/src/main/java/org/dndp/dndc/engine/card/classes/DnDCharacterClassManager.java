package org.dndp.dndc.engine.card.classes;

import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Observable;
import java.util.Observer;
import java.util.SortedSet;
import java.util.TreeSet;

import org.dndp.dndc.engine.FantasyCharacter;
import org.dndp.dndc.engine.benefit.Benefit;
import org.dndp.dndc.engine.card.skills.Skill;
import org.dndp.dndc.engine.check.CheckFailException;
import org.dndp.dndc.engine.check.Checkable;

/**
 * Klasa menadżere klas postaci pojedynaczej postaci.
 * 
 * @author bambucha
 */
public class DnDCharacterClassManager extends Observable implements
        CharacterClassManager
{
    private FantasyCharacter     fantasyCharacter;
    private List<CharacterClass> classList;
    private Integer              level;
    private Integer              experiancePoint;
    private boolean              promoted;

    /**
     * @param fantasyCharacter
     */
    public DnDCharacterClassManager(FantasyCharacter fantasyCharacter)
    {
        super();
        this.fantasyCharacter = fantasyCharacter;
        classList = new LinkedList<CharacterClass>();
    }

    /*
     * (non-Javadoc)
     * @see engine.card.classes.CharacterClassManager#getLevel()
     */
    @Override
    public Integer getLevel()
    {
        return level;
    }

    /**
     * Zwraca ilosć doświadczenia potrzebną do levelu
     * 
     * @param level
     *            argument pytania
     * @return ilość potrzebnego doświadcznia
     */
    private int getXPForLevel(int level)
    {
        return (level * (level + 1)) / 2;
    }

    /*
     * (non-Javadoc)
     * @see engine.card.classes.CharacterClassManager#isMultiClassCharacter()
     */
    @Override
    public boolean isMultiClassCharacter()
    {
        SortedSet<Integer> set = new TreeSet<Integer>();
        for(CharacterClass characterClass : classList)
            if(characterClass.getClasses().isUseInMulticlass())
                set.add(characterClass.getLevel());
        if(set.last() - set.first() > 3)
            return true;
        return false;
    }

    /*
     * (non-Javadoc)
     * @see engine.card.classes.CharacterClassManager#getExperiancePoint()
     */
    @Override
    public Integer getExperiancePoint()
    {
        return experiancePoint;
    }

    /*
     * (non-Javadoc)
     * @see
     * engine.card.classes.CharacterClassManager#setExperiancePoint(java.lang
     * .Integer)
     */
    @Override
    public void setExperiancePoint(Integer experiancePoint)
    {
        if(experiancePoint < 0)
            throw new IllegalArgumentException("Nie może być ujemne ( XP < 0) ");
        this.experiancePoint = experiancePoint;
        if(experiancePoint >= getXPForLevel(level + 1))
            this.promoted = true;
        setChanged();
        notifyObservers(this);
    }

    /*
     * (non-Javadoc)
     * @see engine.card.classes.CharacterClassManager#isPromoted()
     */
    @Override
    public boolean isPromoted()
    {
        return promoted;
    }

    /*
     * (non-Javadoc)
     * @see
     * engine.card.classes.CharacterClassManager#promote(engine.card.classes
     * .BaseClass)
     */
    @Override
    public void promote(BaseClass classes) throws CheckFailException
    {
        CharacterClass toPromote = null;
        for(CharacterClass characterClass : classList)
            if(characterClass.getClass().equals(classes))
                toPromote = characterClass;
        if(toPromote == null) // Postać nie ma jeszcze tej klasy...
        {
            for(Checkable checkable : classes.getConditions())
                if(!checkable.check(fantasyCharacter))
                    throw new CheckFailException("Postać nie spełnia wymagań");
            toPromote = new CharacterClass(classes, 0);
            for(Skill skil : toPromote.getClasses().getClassFleats())
                fantasyCharacter.getSkil(skil.getName()).setClasses(true);
            classList.add(toPromote);
        }
        toPromote.setLevel(toPromote.getLevel() + 1); // Dodanie poziomu

        for(Benefit benefit : toPromote.getClasses().getLevelBenefitsList()[toPromote
                .getLevel()])
            benefit.apply(fantasyCharacter);// Dodanie premi klasowych
        updateSavingThrows();
        setChanged();
        notifyObservers(); // Uaktualnienie atutów, i inne rzeczy...

    }

    @Override
    public Integer getClassLevel(BaseClass classes)
    {
        for(CharacterClass baseClass : classList)
            if(baseClass.getClasses().getName().equals(classes.getName()))
                return baseClass.getLevel();
        throw new NoSuchElementException("Nie ma takiego elementu");
    }

    @Override
    public final List<CharacterClass> getClassList()
    {
        return classList;
    }

    @Override
    public void addCharacterClassObserver(Observer o)
    {
        addObserver(o);
    }

    private void updateSavingThrows()
    {
        int fortitude = 0;
        int refelex = 0;
        int will = 0;
        for(CharacterClass cl : getClassList())
        {
            fortitude += cl.getFortitudeBonus();
            refelex += cl.getReflexBonus();
            will += cl.getWillBonus();
        }
        fantasyCharacter.getForttiude().setBaseModifier(fortitude);
        fantasyCharacter.getReflex().setBaseModifier(refelex);
        fantasyCharacter.getWill().setBaseModifier(will);
    }
}
