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

    /**
     * Zwaraca bazową premię do atku
     * 
     * @return Bazowa premia do ataku postaci
     */
    @Override
    public BaseAttack getMeleeAttack()
    {
        return melee;
    }

    /**
     * Zwraca część odpowiedzialną za ataki dystansowe.
     * 
     * @return Moduł odpowiedzialny za ataki dystansowe.
     */
    @Override
    public BaseAttack getRangeAttack()
    {
        return range;
    }

    /**
     * Zwraca część odpowiedzianą za ataki w zwarciu
     * 
     * @return Moduł odpowiedziany za zwarcie.
     */
    @Override
    public BaseAttack getGrappleAttack()
    {
        return grapple;
    }

    /**
     * Zwraca wartość incjatywy z uwzględnieniem modufikatora od zręczności
     * 
     * @return Końcowa wartość modyfikatora
     */
    @Override
    public Initiative getInitiative()
    {
        return initiative;
    }

    /**
     * Zwraca szybkość postaci
     * 
     * @return Szybkość
     */
    @Override
    public Speed getSpeed()
    {
        return speed;
    }

    /**
     * Zwraca aktualną bazową premię do ataku
     * 
     * @return Bazowa premia do ataku
     */
    @Override
    public BaseBonusToAttack getBaseAttack()
    {
        return baseAtack;
    }

    /**
     * Ustawia bazową premię do ataku;
     * 
     * @param baseAtack
     */
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
