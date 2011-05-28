package org.dndp.dndc.engine.item;

import org.dndp.dndc.engine.Character;
import org.dndp.dndc.engine.benefit.Benefit;
import org.dndp.dndc.engine.item.armor.Plate;
import org.dndp.dndc.engine.item.armor.Shield;
import org.dndp.dndc.engine.item.things.Belt;
import org.dndp.dndc.engine.item.things.Bracer;
import org.dndp.dndc.engine.item.things.Coat;
import org.dndp.dndc.engine.item.things.Glasses;
import org.dndp.dndc.engine.item.things.Gloves;
import org.dndp.dndc.engine.item.things.Helmet;
import org.dndp.dndc.engine.item.things.Necklace;
import org.dndp.dndc.engine.item.things.Ring;
import org.dndp.dndc.engine.item.things.Shirt;
import org.dndp.dndc.engine.item.things.Shoes;
import org.dndp.dndc.engine.item.weapon.Weapon;

/**
 * Klasa dająca miejsce zaczepienia wszystkim przedmiotom noszącym przez postać.<br/>
 * Ogranicza również lość ich.
 * 
 * @par TODO Sprawdzenie pisowni. Broń postaci.
 * 
 * @author bambucha
 */
public class DnDEquipmentManager implements EquipmentManager
{
    private Helmet    helmet;    // głowa - obręcz , czapka , hełm lub relikwiarz
    private Glasses   glasses;   // oczy - soczewka lub okulary
    private Necklace  necklace;  // szyja - amulet , brosza , medalion, naszjnik, wisiorek lub skarabeusz
    private Shirt     shirt;     // tułw - kamizelaka, ornat lub koszulka
    private Plate     armor;     // tułw - zbroja, pancerz lub szata noszona na koszuli(itp.)
    private Belt      belt;      // talia - pas noszony na zbroji(itp.)
    private Coat      coat;      // ramiona- płaszcz , peleryna lub koszula noszona na zbroji(itp.)
    private Bracer    bracer;    // [ramiona|nadgarstki] - para branzolet lub karwaszy na szacie(itp.)
    private Gloves    gloves;    // dlonie- rękawiczka, para rękawiczek, rękawic
    private Ring      firstRing; // dłonie- po jednym pierścieniu na dłoń, lub dwa na jednej
    private Ring      secondRing; // ^^
    private Shoes     shoes;     // stopy - para butów lub pantofli

    private Shield    shield;    // Tarcza dzierżona przez postać.

    private Weapon    mainHand;  // Ręka główna, w niej są dzierżone bronioe jednoręczne.
    private Weapon    secondHand; // Reka druga, wykorzystywana podczas walki bronią dwuręczną lub dwiema broniami
    /*
     * Jeżeli postać walczy bronią dwuręczną na obu referencjach musi być ta sama broń.
     */
    private Inventory inventory; //Miejsce gdzie będzie się wsadzać plecaki i inne.

    private Character owner;

    /**
     * Standardowy konstuktor tworzący pustą postać, bez założonych itemów
     * 
     * @param owner
     *            Dowiązanie przedmiotów do postaci
     */
    public DnDEquipmentManager(Character owner)
    {
        this.owner = owner;
        this.helmet = null;
        this.glasses = null;
        this.necklace = null;
        this.shirt = null;
        this.armor = null;
        this.belt = null;
        this.coat = null;
        this.bracer = null;
        this.gloves = null;
        this.firstRing = null;
        this.secondRing = null;
        this.shoes = null;
        this.inventory = new Inventory("main", 0.0, new Value(0, 0, 0, 0), new Benefit[0]);
    }

    /*
     * (non-Javadoc)
     * @see engine.item.EquipmentManager#putOn(engine.item.Item)
     */
    @Override
    public void putOn(Item what)
    {
        what.setManager(this);
        what.putOn();
    }

    /*
     * (non-Javadoc)
     * @see engine.item.EquipmentManager#getCurrentArmorPently()
     */
    @Override
    public Integer getCurrentArmorPently()
    {
        int armorPently = 0;
        if(armor != null)
            armorPently += armor.getArmorPenalty();
        if(shield != null)
            armorPently += shield.getArmorPenalty();
        return armorPently;
    }

    /*
     * (non-Javadoc)
     * @see engine.item.EquipmentManager#getCurrentArmorPently()
     */
    @Override
    public Integer getMaximumDexterityACBonus()
    {
        if(armor == null)
            return Integer.MAX_VALUE;
        return armor.getMaxDexBonus();
    }

    @Override
    public void store(Item what)
    {
        inventory.add(what);
    }

    /*
     * (non-Javadoc)
     * @see engine.item.EquipmentManager#getArmor()
     */
    @Override
    public Plate getArmor()
    {
        return armor;
    }

    /*
     * (non-Javadoc)
     * @see engine.item.EquipmentManager#setArmor(engine.item.armor.Plate)
     */
    @Override
    public void setArmor(Plate newArmor)
    {
        this.armor = newArmor;
    }

    /*
     * (non-Javadoc)
     * @see engine.item.EquipmentManager#getHelmet()
     */
    @Override
    public Helmet getHelmet()
    {
        return helmet;
    }

    /*
     * (non-Javadoc)
     * @see engine.item.EquipmentManager#setHelmet(engine.item.Item)
     */
    @Override
    public void setHelmet(Helmet helmet)
    {
        this.helmet = helmet;
    }

    /*
     * (non-Javadoc)
     * @see engine.item.EquipmentManager#getGlasses()
     */
    @Override
    public Glasses getGlasses()
    {
        return glasses;
    }

    /*
     * (non-Javadoc)
     * @see engine.item.EquipmentManager#setGlasses(engine.item.Item)
     */
    @Override
    public void setGlasses(Glasses glasses)
    {
        this.glasses = glasses;
    }

    /*
     * (non-Javadoc)
     * @see engine.item.EquipmentManager#getNecklace()
     */
    @Override
    public Necklace getNecklace()
    {
        return necklace;
    }

    /*
     * (non-Javadoc)
     * @see engine.item.EquipmentManager#setNecklace(engine.item.Item)
     */
    @Override
    public void setNecklace(Necklace necklace)
    {
        this.necklace = necklace;
    }

    /*
     * (non-Javadoc)
     * @see engine.item.EquipmentManager#getShirt()
     */
    @Override
    public Shirt getShirt()
    {
        return shirt;
    }

    /*
     * (non-Javadoc)
     * @see engine.item.EquipmentManager#setShirt(engine.item.Item)
     */
    @Override
    public void setShirt(Shirt shirt)
    {
        this.shirt = shirt;
    }

    /*
     * (non-Javadoc)
     * @see engine.item.EquipmentManager#getBelt()
     */
    @Override
    public Belt getBelt()
    {
        return belt;
    }

    /*
     * (non-Javadoc)
     * @see engine.item.EquipmentManager#setBelt(engine.item.Item)
     */
    @Override
    public void setBelt(Belt belt)
    {
        this.belt = belt;
    }

    /*
     * (non-Javadoc)
     * @see engine.item.EquipmentManager#getCoat()
     */
    @Override
    public Coat getCoat()
    {
        return coat;
    }

    /*
     * (non-Javadoc)
     * @see engine.item.EquipmentManager#setCoat(engine.item.Item)
     */
    @Override
    public void setCoat(Coat coat)
    {
        this.coat = coat;
    }

    /*
     * (non-Javadoc)
     * @see engine.item.EquipmentManager#getBracer()
     */
    @Override
    public Bracer getBracer()
    {
        return bracer;
    }

    /*
     * (non-Javadoc)
     * @see engine.item.EquipmentManager#setBracer(engine.item.Item)
     */
    @Override
    public void setBracer(Bracer bracer)
    {
        this.bracer = bracer;
    }

    /*
     * (non-Javadoc)
     * @see engine.item.EquipmentManager#getGloves()
     */
    @Override
    public Gloves getGloves()
    {
        return gloves;
    }

    /*
     * (non-Javadoc)
     * @see engine.item.EquipmentManager#setGloves(engine.item.Item)
     */
    @Override
    public void setGloves(Gloves gloves)
    {
        this.gloves = gloves;
    }

    /*
     * (non-Javadoc)
     * @see engine.item.EquipmentManager#getRing()
     */
    @Override
    public Ring getFirstRing()
    {
        return firstRing;
    }

    /*
     * (non-Javadoc)
     * @see engine.item.EquipmentManager#setRing(engine.item.Item)
     */
    @Override
    public void setFirstRing(Ring ring)
    {
        this.firstRing = ring;
    }

    /*
     * (non-Javadoc)
     * @see engine.item.EquipmentManager#getSecondRing()
     */
    @Override
    public Ring getSecondRing()
    {
        return secondRing;
    }

    /*
     * (non-Javadoc)
     * @see engine.item.EquipmentManager#setSecondRing(engine.item.Item)
     */
    @Override
    public void setSecondRing(Ring secondRing)
    {
        this.secondRing = secondRing;
    }

    /*
     * (non-Javadoc)
     * @see engine.item.EquipmentManager#getShoes()
     */
    @Override
    public Shoes getShoes()
    {
        return shoes;
    }

    /*
     * (non-Javadoc)
     * @see engine.item.EquipmentManager#setShoes(engine.item.Item)
     */
    @Override
    public void setShoes(Shoes shoes)
    {
        this.shoes = shoes;
    }

    /*
     * (non-Javadoc)
     * @see engine.item.EquipmentManager#getShield()
     */
    @Override
    public Shield getShield()
    {
        return shield;
    }

    /*
     * (non-Javadoc)
     * @see engine.item.EquipmentManager#setShield(engine.item.armor.Shield)
     */
    @Override
    public void setShield(Shield shield)
    {
        this.shield = shield;
    }

    /*
     * (non-Javadoc)
     * @see engine.item.EquipmentManager#getMain()
     */
    @Override
    public Inventory getInventory()
    {
        return inventory;
    }

    public Weapon getMainHand()
    {
        return mainHand;
    }

    public void setMainHand(Weapon mainHand)
    {
        this.mainHand = mainHand;
    }

    public Weapon getSecondHand()
    {
        return secondHand;
    }

    public void setSecondHand(Weapon secondHand)
    {
        this.secondHand = secondHand;
    }

    @Override
    public void applyItemBenefits(Item item)
    {
        for (Benefit b : item.getBenefits())
            b.apply(owner);
    }

    @Override
    public void abbandoItemBenefits(Item item)
    {
        for (Benefit b : item.getBenefits())
            b.abandon(owner);

    }

}
