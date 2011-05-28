package org.dndp.dndc.engine.item.weapon;

import org.dndp.dndc.engine.Dice;

/**
 * Klasa opisująca pojedynczy sposób ataku broni.
 * 
 * @author bambucha
 */
public abstract class WeaponAttack
{
    private final Integer    timesDice;
    private final Dice       diceType;
    private final DamageType damageType;

    /**
     * Standardowy konstruktor towrzy atak danego typu z odpowidnim rzutem
     * 
     * @param timesDice
     *            Ilość kostek
     * @param diceType
     *            Typ kostek
     * @param damageType
     *            Typ obrażeń
     */
    public WeaponAttack(Integer timesDice, Dice diceType, DamageType damageType)
    {
        this.timesDice = timesDice;
        this.diceType = diceType;
        this.damageType = damageType;
    }

    /**
     * Zwraca ilość rzutów wykonywanych podczas testu obrażeń.
     * @return Ilość rzutów.
     */
    public Integer getTimesDice()
    {
        return timesDice;
    }

    /**
     * Zwraca kość użytą do rzutów.
     * @return Typ kości.
     */
    public Dice getDiceType()
    {
        return diceType;
    }

    /**
     * Zwraca typ zadawanych obrażeń.
     * @return Typ obrażeń.
     */
    public DamageType getDamageType()
    {
        return damageType;
    }
    
    
}
