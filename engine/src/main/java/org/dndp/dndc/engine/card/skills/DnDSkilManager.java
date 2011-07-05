package org.dndp.dndc.engine.card.skills;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;

import org.dndp.dndc.engine.Dice;
import org.dndp.dndc.engine.card.UnavailableTestException;
import org.dndp.dndc.engine.card.bonus.BonusManager;
import org.dndp.dndc.engine.item.BasicEquipmentManager;

/**
 * Klasa opiekująca się umiejetnoscieami bohaterów
 * 
 * @author bambucha
 */
public class DnDSkilManager extends Observable implements SkillManager,
        Observer
{
    private BasicEquipmentManager       baseEquipmentManager;
    private Map<String, CharacterSkill> skilSet;

    // Przyśpieszenie zapytania po nazwie umiejętności. Dodanie klucza powinno
    // wyglądać put(CharacterSkil.getSkil.getName,CharacterSkill)

    public DnDSkilManager(BasicEquipmentManager main, BonusManager bonusManager)
    {
        this.baseEquipmentManager = main;
        this.skilSet = new HashMap<String, CharacterSkill>();

    }

    /**
     * Wykonuje test danej umiejętności.
     * 
     * @param skilToTest
     *            Umiejętnośc do testowania
     * @return Wynikt testu
     * @throws UnavailableTestException
     *             Gdy test jest niemożliwy do wykonania.
     */
    private Integer testSkil(CharacterSkill skilToTest)
            throws UnavailableTestException
    {
        if(skilToTest.getSkil().isTrain() && skilToTest.getRank() == 0)
            throw new UnavailableTestException();
        if(skilToTest.getSkil().isArmorInterrupt())
            return Dice.D20.throwTheDice() + skilToTest.getRank()
                    + skilToTest.getBonus()
                    - baseEquipmentManager.getCurrentArmorPently();
        return Dice.D20.throwTheDice() + skilToTest.getRank()
                + skilToTest.getBonus();
    }

    /*
     * (non-Javadoc)
     * @see engine.card.skils.SkilManager#testSkil(java.lang.String)
     */
    @Override
    public Integer testSkil(String name) throws UnavailableTestException
    {
        CharacterSkill t = skilSet.get(name);
        if(t != null)
            return testSkil(t);
        else
            throw new UnavailableTestException();
    }

    /*
     * (non-Javadoc)
     * @see engine.card.skils.SkilManager#getSkilNameSet()
     */
    @Override
    public Set<String> getSkilNameSet()
    {
        return skilSet.keySet();
    }

    @Override
    public Collection<CharacterSkill> getCharacterSkillSet()
    {
        return skilSet.values();
    }

    @Override
    public CharacterSkill getSkil(String name)
    {
        return skilSet.get(name);
    }

    @Override
    public void update(Observable o, Object arg)
    {
        setChanged();
        notifyObservers(getCharacterSkillSet());
    }

    @Override
    public void addSkillObserver(Observer o)
    {
        addObserver(o);
    }
}
