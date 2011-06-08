package org.dndp.dndc.engine.card.attack;

import org.dndp.dndc.engine.Character;

/**
 * Klasa przechowująca informacje co do możliwych ataków wykonywanych przez
 * postać.
 * 
 * @author bambucha
 */
public class DnDAttack implements Attack
{
    private Character         mother;
    private double            speed;
    private Integer           initiative;
    private BaseBonusToAttack baseAtack;
    private BaseAttack        melee;
    private BaseAttack        range;
    private BaseAttack        grapple;

    /**
     * Standardowy konstrutor tworzący postać na 0 wym poziomie.
     * 
     * @param mother
     */
    public DnDAttack(Character mother)
    {
        this.mother = mother;
        speed = 9D;
        initiative = 0;
        baseAtack = new BaseBonusToAttack(new int[] { 0 });
        melee = new MeleeAttack(mother);
        range = new RangeAttack(mother);
        grapple = new GrappleAttack(mother);
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
    public void setInitiativeModifier(Integer newValue)
    {
        if (newValue == null)
            throw new NullPointerException();
        initiative = newValue;
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
        this.speed = newValue;
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
        melee.setBaseAttack(baseAtack);
        range.setBaseAttack(baseAtack);
        grapple.setBaseAttack(baseAtack);
        this.baseAtack = baseAtack;
    }

}
