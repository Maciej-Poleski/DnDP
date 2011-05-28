package org.dndp.dndc.engine.card.attack;

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

    public void setInitiativeModifier(Integer newValue);

    public Double getSpeed();

    public void setSpeed(Double newValue);
}
