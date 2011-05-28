package org.dndp.dndc.engine.card.skills;

import org.dndp.dndc.engine.card.abilities.AbilityType;

/**
 * Klasa na umiejętność. Przechowuje informacje potrzebne do wykonania testów.
 * Służy do przechowywania danych w bazie, na jej podstawie budowany jest
 * CharacterSkill.
 * 
 * @par TODO Zastanowić się nad synergią, wielokrotnym testami, przeszkadzaniem
 *      i innymi.
 * @see dndp.engine.card.skills.DnDSkilManager
 * @author bambucha
 */
public class Skill
{
    private final String      name;
    private final AbilityType abilitiModifier;
    private final Boolean     train;
    private final Boolean     armorInterrupt;

    /**
     * Konstruktor do budowania umiejętności.
     * 
     * @param name
     *            Nazwa umiejętności.
     * @param abilitiModifier
     *            Atrybut modyfikatora.
     * @param train
     *            Czy wytenowana.
     * @param armorInterrupt
     *            Czy używa się kar za zbroje.
     */
    public Skill(String name, AbilityType abilitiModifier, Boolean train, Boolean armorInterrupt)
    {
        this.name = name;
        this.abilitiModifier = abilitiModifier;
        this.train = train;
        this.armorInterrupt = armorInterrupt;
    }

    /**
     * Zwraca atrybut będący modyfikatorem umiejętności.
     * 
     * @return Atrybut
     */
    public AbilityType getAbilitiModifier()
    {
        return abilitiModifier;
    }

    /**
     * Zwraca czy stosuję się karę od zbroji.<br/>
     * 
     * @return
     */
    public Boolean isArmorInterrupt()
    {
        return armorInterrupt;
    }

    /**
     * Zwraca nazwę umiejętności
     * 
     * @return
     */
    public String getName()
    {
        return name;
    }

    /**
     * Odpowiada na pytanie czy umiejętność musi być wytrenowana
     * 
     * @return [Tak|Nie]
     */
    public Boolean isTrain()
    {
        return train;
    }
}
