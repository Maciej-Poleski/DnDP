package org.dndp.dndc.engine.card.hp;

import java.util.Observable;

/**
 * Klasa obsługująca punkty życia i inne zdażenia.
 * 
 * @author bambucha
 */
public class DnDHitPoints extends Observable implements HitPoints
{
    private int maxHP;
    private int HP;

    public DnDHitPoints()
    {

    }

    @Override
    public int getHP()
    {
        return HP;
    }

    @Override
    public void setHP(int HP)
    {
        if(this.HP != HP)
            setChanged();
        this.HP = HP;
        notifyObservers(this);
    }

    @Override
    public int getMaxHP()
    {
        return maxHP;
    }

    @Override
    public void setMaxHP(int maxHP)
    {
        if(maxHP < 0)
            throw new IllegalArgumentException("Max HP < 0");
        if(this.maxHP != maxHP)
            setChanged();
        this.maxHP = maxHP;
        notifyObservers(this);
        
    }
}
