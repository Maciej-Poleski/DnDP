package org.dndp.dndc.engine.card.attack;

import java.util.Observable;

import org.dndp.dndc.engine.card.abilities.AbilityType;
import org.dndp.dndc.engine.card.bonus.BonusManager;
import org.dndp.dndc.engine.card.bonus.Bonusable;

public class Initiative extends Observable implements Bonusable
{
    private int base;
    private int bonus;
    
    public Initiative(BonusManager bonusManager)
    {
        base = 0;
        bonus = 0;
        bonusManager.registerBonus("Initiative", this);
    }
    
    public Integer getInitiativModifier()
    {
        return base + bonus;
    }
    

    public void setBase(int base)
    {
        if(this.base != base)
            setChanged();
        this.base = base;
        notifyObservers();
    }

    @Override
    public void setBonus(int bonus)
    {
        if(this.bonus != bonus)
            setChanged();
        this.bonus = bonus;
        notifyObservers();
    }

    @Override
    public AbilityType getAbilityName()
    {
        return AbilityType.DEXTERITY;
    }

    @Override
    public boolean isSizeImportant()
    {
        return false;
    }

}
