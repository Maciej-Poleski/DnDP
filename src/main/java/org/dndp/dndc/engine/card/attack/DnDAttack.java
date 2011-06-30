package org.dndp.dndc.engine.card.attack;

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

    /**
     * Standardowy konstrutor tworzący postać na 0 wym poziomie.
     * 
     * @param bonusManager
     */
    public DnDAttack(BonusManager bonusManager)
    {
        baseAtack = new BaseBonusToAttack(new int[] { 0 });
        melee = new MeleeAttack();
        bonusManager.registerBonus("MeleeAttack", melee);
        range = new RangeAttack();
        bonusManager.registerBonus("RangeAttack", range);
        grapple = new GrappleAttack();
        bonusManager.registerBonus("GrappleAttack", grapple);
        initiative = new Initiative(bonusManager);
        speed = new Speed();
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
        this.baseAtack = baseAtack;
        melee.setBaseAttack(baseAtack);
        range.setBaseAttack(baseAtack);
        grapple.setBaseAttack(baseAtack);
    }

    @Override
    public void addAttackObserver(Observer o)
    {
        melee.addObserver(o);
        range.addObserver(o);
        grapple.addObserver(o);
        initiative.addObserver(o);
        speed.addObserver(o);
    }

}
