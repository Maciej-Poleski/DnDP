package org.dndp.dndc.engine.card.abilities;

/**
 * Enum z atrybutami.<br/>
 * Będzie przydatne przy umiejętnościach.
 * 
 * @author bambucha
 * @version 1.0
 */
public enum AbilityType
{
    STRENGHT, DEXTERITY, CONSTRUCTION, INTELLIGENCE, WISDOM, CHARISMA, NONE;
    
    /**
     * Funkcja zwraca modyfikatr od atrybutu do umijętności.
     * 
     * @param arg
     *            Nazwa atrybutu
     * @return Wartość modyfikatora
     */
    public Abiliti getAbiliti(Abilities abilities)
    {
        switch (this)
        {
            case STRENGHT:
                return abilities.getStrenght();
            case DEXTERITY:
                return abilities.getDexterity();
            case CONSTRUCTION:
                return abilities.getConstitution();
            case INTELLIGENCE:
                return abilities.getInteligence();
            case WISDOM:
                return abilities.getWisdom();
            case CHARISMA:
                return abilities.getCharisma();
            case NONE:
            default:
                return null;
        }
    }
}
