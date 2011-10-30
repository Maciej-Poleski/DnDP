package org.dndp.dndc.engine.card.attack;

import java.util.Arrays;
import java.util.Observable;
import java.util.Observer;

import org.dndp.dndc.engine.card.bonus.BonusManager;

/**
 * Klasa przechowująca informacje co do możliwych ataków wykonywanych przez
 * postać.
 * 
 * @author bambucha
 */
public class DnDAttack implements Attack
{
    private Speed             speed;
    private Initiative        initiative;
    private BaseBonusToAttack baseAtack;
    private BaseAttack        melee;
    private BaseAttack        range;
    private BaseAttack        grapple;

    private Observable[]      tab;

    /**
     * Standardowy konstrutor tworzący postać na 0 wym poziomie.
     * 
     * @param bonusManager
     */
    public DnDAttack(BonusManager bonusManager)
    {
        baseAtack = new BaseBonusToAttack().setFirst(0);
        melee = new MeleeAttack(this);
        bonusManager.registerBonus("MeleeAttack", melee);
        range = new RangeAttack(this);
        bonusManager.registerBonus("RangeAttack", range);
        grapple = new GrappleAttack(this);
        bonusManager.registerBonus("GrappleAttack", grapple);
        initiative = new Initiative(bonusManager);
        speed = new Speed();
        tab = new Observable[] { melee, range, grapple, initiative, speed };
    }

    @Override
    public BaseAttack getMeleeAttack()
    {
        return melee;
    }

    @Override
    public BaseAttack getRangeAttack()
    {
        return range;
    }

    @Override
    public BaseAttack getGrappleAttack()
    {
        return grapple;
    }

    @Override
    public Initiative getInitiative()
    {
        return initiative;
    }

    @Override
    public Speed getSpeed()
    {
        return speed;
    }

    @Override
    public BaseBonusToAttack getBaseAttack()
    {
        return baseAtack;
    }

    @Override
    public void setBaseAttack(BaseBonusToAttack baseAtack)
    {
        boolean need = this.baseAtack.compareTo(baseAtack)==0;
        this.baseAtack = baseAtack;
        if(need)
        {
            melee.update();
            range.update();
            grapple.update();
        }
    }

    @Override
    public void addAttackObserver(Observer o)
    {
        for(Observable ob : tab)
        {
            ob.addObserver(o);
        }
    }

    @Override
    public void removeObserverFromAttack(Observer o)
    {
        for(Observable ob : tab)
        {
            ob.deleteObserver(o);
        }
    }

    @Override
    public void removeObserversFromAttack()
    {
        for(Observable ob : tab)
        {
            ob.deleteObservers();
        }
    }

}
