package org.dndp.dndc.engine.card.hp;

/**
 * Klasa obsługująca punkty życia i inne zdażenia.
 * 
 * @author bambucha
 */
public class DnDHitPoints implements HitPoints
{
    private Integer maxHP;
    private Integer HP;

    public DnDHitPoints()
    {

    }

    @Override
    public Integer getHP()
    {
        return HP;
    }

    @Override
    public void setHP(Integer HP)
    {
        this.HP = HP;
    }

    @Override
    public Integer getMaxHP()
    {
        return maxHP;
    }

    @Override
    public void setMaxHP(Integer maxHP)
    {
        if(maxHP < 0)
            throw new IllegalArgumentException("Max HP < 0");
        this.maxHP = maxHP;
    }
}
