package org.dndp.dndc.engine.item.weapon;

import org.dndp.dndc.engine.benefit.Benefit;
import org.dndp.dndc.engine.item.Item;
import org.dndp.dndc.engine.item.Value;

/**
 * Klasa abstrakcyjna broni
 * 
 * @par TODO Zastanowienie się nad atakowaniem
 * @author bambucha
 */
public class Weapon extends Item
{
    private final WeaponAttack[] attackTypes;
    private final WeaponType     type;
    private final Boolean        isOneHand;
    private final Boolean        isMWW;

    /**
     * Standardowy konstruktor broni.
     * 
     * @param name
     *            Nazwa broni
     * @param weight
     *            Waga broni
     * @param value
     *            Wartość broni
     * @param attackTypes
     *            Ataki broni
     * @param type
     *            Typ broni
     * @param isOneHand
     *            czy jednoręczna
     */
    public Weapon(String name, Double weight, Value value,Benefit[] benefits, WeaponAttack[] attackTypes, WeaponType type, Boolean isOneHand)
    {
        super(name, weight, value,benefits);
        this.attackTypes = attackTypes;
        this.type = type;
        this.isMWW = false;
        this.isOneHand = isOneHand;
    }

    /**
     * Zwraca tablicę ataków broni.
     * @return Tablica ataków.
     */
    public WeaponAttack[] getAttackTypes()
    {
        return attackTypes;
    }

    /**
     * Zwraca typ broni.
     * @return Typ broni
     */
    public WeaponType getType()
    {
        return type;
    }

    /**
     * Odpowiada na pytanie czy broń jest jednoręczna.
     * @return <code>true</code>, jeśli broń jest jednoręczna.
     */
    public Boolean getIsOneHand()
    {
        return isOneHand;
    }

    /**
     * Odpowiada na pytanie czy broń jest mistrzowsko wykonana.
     * @return <code>true</code>, jeśli broń jest mistrzowsko wykonana.
     */
    public Boolean getIsMWW()
    {
        return isMWW;
    }

    @Override
    public void putOn()
    {
        if(getManager().getMainHand() != null)
            getManager().getMainHand().takeOff();
        getManager().setMainHand(this);
    }

    @Override
    public void takeOff()
    {
        if(getManager().getMainHand() != this)
            return;
        getManager().store(this);
        getManager().setMainHand(null);
    }

}
