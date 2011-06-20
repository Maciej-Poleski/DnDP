package org.dndp.dndc.engine.card.attack;

import java.util.Observer;

/**
 * 
 * @author bambucha
 */
public interface Attack
{
    public BaseBonusToAttack getBaseAttack();

    public void setBaseAttack(BaseBonusToAttack newValue);

    public BaseAttack getMeleeAttack();

    public BaseAttack getRangeAttack();

    public BaseAttack getGrappleAttack();

    public Integer getInitiativeModifier();

    public void setInitiativeModifier(int newValue);

    public double getSpeed();

    public void setSpeed(double newValue);
    
    public void addAttackObserver(Observer o);
}
