package org.dndp.dndc.engine.item;

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
 * Interfejs powiększony na potrzeby ekwipunku. Rozszerza {@link BasicEquipmentManager} o funkcje potrzebne itemom podczas montowania się w
 * {@link DnDEquipmentManager}.
 * 
 * 
 * @author bambucha
 */
public interface EquipmentManager extends BasicEquipmentManager
{

    /**
     * Zwraca aktualną zbroję postaci Możliwość zmian
     * 
     * @return Zbroja
     */
    public abstract Plate getArmor();

    /**
     * Ustawia nową zbroję
     * 
     * @param newArmor
     */
    public abstract void setArmor(Plate newArmor);

    /**
     * Zwraca przedmiot będący na głowie postaci.
     * 
     * @return Przedmiot na głowie.
     */
    public abstract Helmet getHelmet();

    /**
     * Ustawia przedmiot na głowie postaci.
     * 
     * @param helmet
     *            Nowy "hełm" postaci.
     */
    public abstract void setHelmet(Helmet helmet);

    /**
     * Zwraca przedmiot, który jest obecnie okularami postaci.
     * 
     * @return Okulary
     */
    public abstract Glasses getGlasses();

    /**
     * Ustawia nowe okulary postaci
     * 
     * @param glasses
     *            Nowe okulary postaci.
     */
    public abstract void setGlasses(Glasses glasses);

    /**
     * Zwraca przedmiot będący na szyji postaci.
     * 
     * @return Przedmiot na szyji.
     */
    public abstract Necklace getNecklace();

    /**
     * Ustawia nowy przedmiot na szyji postaci.
     * 
     * @param necklace
     *            Nowy przedmiot na szyję.
     */
    public abstract void setNecklace(Necklace necklace);

    /**
     * Zwraca przedmiot będący koszulą postaci.
     * 
     * @return Koszula postaci.
     */
    public abstract Shirt getShirt();

    /**
     * Ustawia nową koszulę postaci.
     * 
     * @param shirt
     *            Nowa koszula.
     */
    public abstract void setShirt(Shirt shirt);

    /**
     * Zwraca przedmiot będący pasem postaci.
     * 
     * @return Pas postaci.
     */
    public abstract Belt getBelt();

    /**
     * Ustwawia przedmiot jako nowy pas postaci.
     * 
     * @param belt
     */
    public abstract void setBelt(Belt belt);

    /**
     * Zwraca przedmiot będący płaszczem postaci.
     * 
     * @return Płasz postaci.
     */
    public abstract Coat getCoat();

    /**
     * Ustwia przedmiot jako nowu płaszcz postaci.
     * 
     * @param coat
     *            Nowy płasz postaci.
     */
    public abstract void setCoat(Coat coat);

    /**
     * Zwraca przedmiot będący karwaszami postaci.
     * 
     * @return Karwasz postaci.
     */
    public abstract Bracer getBracer();

    /**
     * Ustawia przedmiot będący nowym karwaszem postaci.
     * 
     * @param bracer
     *            Nowe karwasze postaci.
     */
    public abstract void setBracer(Bracer bracer);

    /**
     * Zwraca rękawiczki postaci.
     * 
     * @return Rekawiczki.
     */
    public abstract Gloves getGloves();

    /**
     * Ustawia nowe rękawiczki postaci.
     * 
     * @param gloves
     *            Nowe rękawiczki.
     */
    public abstract void setGloves(Gloves gloves);

    /**
     * Zwraca pierwszy pierścień noszony przez postać.
     * 
     * @return Pierścień.
     */
    public abstract Ring getFirstRing();

    /**
     * Ustwia pierwszy pierścień noszony przez postać.
     * 
     * @param ring
     *            Postać.
     */
    public abstract void setFirstRing(Ring ring);

    /**
     * Zwrtaca drugi pierścień noszony przez postać.
     * 
     * @return Pierścień.
     */
    public abstract Ring getSecondRing();

    /**
     * Ustawia nowy drugi pierścień noszony przez postać.
     * 
     * @param secondRing
     *            Nowy pierścień
     */
    public abstract void setSecondRing(Ring secondRing);

    /**
     * Zwraca przedmiot będący butami postaci.
     * 
     * @return Buty postaci.
     */
    public abstract Shoes getShoes();

    /**
     * Ustawia nowe buty dla postaci.
     * 
     * @param shoes
     *            Nowe buty.
     */
    public abstract void setShoes(Shoes shoes);

    /**
     * Zwraca tarczę aktualnie dzierżoną przez postać.
     * 
     * @return Tarcza
     */
    public abstract Shield getShield();

    /**
     * Ustawia tarczę postaci.
     * 
     * @param shield
     *            Nowa tarcza.
     */
    public abstract void setShield(Shield shield);

    /**
     * Zwraca ekwipunek postaci. Tu zawierają się plecaki, pasy na eliksyry i inne.
     * 
     * @return Cały ekwipunke postaci.
     */
    public abstract Inventory getInventory();

    /**
     * Zwraca broń dzierżoną w głównej ręce.
     * 
     * @return Główna broń.
     */
    public abstract Weapon getMainHand();

    /**
     * Ustawia broń będącą na głównej ręce.
     * 
     * @param mainHand
     *            Nowa główna broń.
     */
    public abstract void setMainHand(Weapon mainHand);

    /**
     * Zwraca broń w drugorzędnej ręce.
     * 
     * @return Drugorzędna broń.
     */
    public abstract Weapon getSecondHand();

    /**
     * Ustawia nową drugorzędną broń.
     * 
     * @param secondHand
     *            Nowa durgorzędna broń.
     */
    public abstract void setSecondHand(Weapon secondHand);

    /**
     * Aplikuje na postaci wszytkie premię wynikające z noszenia przedmiotu. Używane w implemenctacjach item.putOn.
     * 
     * @param item
     *            Przedmiot którego premię mają być na postaci ustawione.
     */
    public abstract void applyItemBenefits(Item item);

    /**
     * Usuwa z postaci wszysztkie premię wynikające z przedmiotu. Używane w item.takeOff.
     * 
     * @param item
     *            Przedmiot którego premię mają być usunięte z postaci.
     */
    public abstract void abbandoItemBenefits(Item item);

}
