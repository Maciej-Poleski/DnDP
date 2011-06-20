package org.dndp.dndc.engine.card.attack;

import java.util.Observable;
import java.util.Observer;

import org.dndp.dndc.engine.FantasyCharacter;

/**
 * Klasa przechowująca informacje co do możliwych ataków wykonywanych przez
 * postać.
 * 
 * @author bambucha
 */
public class DnDAttack extends Observable implements Attack 
{
    private FantasyCharacter         mother;
    private double            speed;
    private int           initiative;
    private BaseBonusToAttack baseAtack;
    private BaseAttack        melee;
    private BaseAttack        range;
    private BaseAttack        grapple;

    /**
     * Standardowy konstrutor tworzący postać na 0 wym poziomie.
     * 
     * @param mother
     */
    public DnDAttack(FantasyCharacter mother)
    {
        this.mother = mother;
        speed = 9D;
        initiative = 0;
        baseAtack = new BaseBonusToAttack(new int[] { 0 });
        melee = new MeleeAttack();
        mother.registerBonus("MeleeAttack", melee);
        range = new RangeAttack();
        mother.registerBonus("RangeAttack", range);
        grapple = new GrappleAttack(mother);
        mother.registerBonus("GrappleAttack", grapple);
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
    public Integer getInitiativeModifier()
    {
        return initiative + mother.getDexterity().getModifier();
    }

    /**
     * Ustawia nową wartość modyfikatora incjatywy. <b>Premia ze zeręczności
     * jest doliczana on-line, podczas pobierania wartości końcowej</b>
     * 
     * @param newValue
     *            Wartość bez premi ze zręczności
     */
    @Override
    public void setInitiativeModifier(int newValue)
    {
        if (newValue == initiative)
            setChanged();
        initiative = newValue;
        notifyObservers();
        
    }

    /**
     * Zwraca szybkość postaci
     * 
     * @return Szybkość
     */
    @Override
    public double getSpeed()
    {
        return speed;
    }

    /**
     * Ustawia prętkość
     * 
     * @param newValue
     */
    @Override
    public void setSpeed(double newValue)
    {
        //TODO Sprawdzić w książce i zweryfikować dla małych istot.
        if (newValue % 1.5 != 0)
            throw new IllegalArgumentException("Nowa wartość musi być wielokrotoność 1.5");
        if(newValue != speed)
            setChanged();
        this.speed = newValue;
        notifyObservers();
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
        if(this.baseAtack.compareTo(baseAtack) != 0)
            setChanged();
        this.baseAtack = baseAtack;
        melee.setBaseAttack(baseAtack);
        range.setBaseAttack(baseAtack);
        grapple.setBaseAttack(baseAtack);
        notifyObservers();
    }
    
    @Override
    public void addAttackObserver(Observer o)
    {
        melee.addObserver(o);
        range.addObserver(o);
        grapple.addObserver(o);
        addObserver(o);
    }

}
