package org.dndp.dndc.engine.card.armor;

import java.util.Observable;
import java.util.Observer;

import org.dndp.dndc.engine.card.abilities.Abilities;
import org.dndp.dndc.engine.card.abilities.AbilityType;
import org.dndp.dndc.engine.card.bonus.ArmorBonusHandler;
import org.dndp.dndc.engine.card.bonus.BonusManager;
import org.dndp.dndc.engine.card.bonus.Bonusable;
import org.dndp.dndc.engine.item.BasicEquipmentManager;

/**
 * Klasa licząca Klasę pancerza dla postaci.
 * 
 * @author bambucha
 */
public class DnDArmor extends Observable implements Armor, Bonusable
{

    private final Integer         BASE = 10;
    private Abilities             abilities;
    private BasicEquipmentManager equipmentManager;
    private ArmorBonusHandler     bonusHandler;
    private int bonus;

    /**
     * @param abilities
     * @param equipmentManager
     */
    public DnDArmor(Abilities abilities, BasicEquipmentManager equipmentManager, BonusManager bonusManager)
    {
        super();
        this.abilities = abilities;
        this.equipmentManager = equipmentManager;
        bonusManager.registerBonus("armor", this);
        bonusHandler = (ArmorBonusHandler)bonusManager.getBonusHandler("armor");
    }

    protected Integer getDexterityACBonus()
    {
        return Math.min(abilities.getDexterity().getModifier(), equipmentManager.getMaximumDexterityACBonus());
    }

    /**
     * Zwraca KP postacie, dla "normalnych ataków"
     * 
     * @return Klasa Pancerza postaci
     */
    @Override
    public synchronized Integer getAC()
    {
        return BASE + bonusHandler.getACBonus() + getDexterityACBonus();
    }

    /**
     * Zwraca Klasę Pancerza postaci nieprzygotowane
     * 
     * @return Klasa Pancerza Postaci
     */
    @Override
    public Integer getFlatFootetAC()
    {
        return BASE + bonusHandler.getFlatFootetAC();
    }

    /**
     * Zwraca Klasę Pancerza postaci przeciwko ataką dodtykowym
     * 
     * @return Klasa Pancerza
     */
    @Override
    public Integer getTouchAttaksAC()
    {
        return BASE + bonusHandler.getTouchAttacksAC() + getDexterityACBonus();
    }

    /**
     * Wszystko liczone w funkcjach. Nie ma potrzeby.
     */
    @Override
    public void setBonus(int bonus)
    {
        if(this.bonus != bonus)
            setChanged();
        this.bonus = bonus;
        notifyObservers(this);
    }

    @Override
    public AbilityType getAbilityName()
    {
        return AbilityType.NONE;    //Pancerz sam musi załatwiać premię do Zręczności
                                    //Ze względ na ogranicznie zbroji
    }
    
    @Override
    public boolean isSizeImportant()
    {
        return true;
    }
    
    @Override
    public void addArmorObserver(Observer o)
    {
        addObserver(o);
    }
}
