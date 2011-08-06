package org.dndp.dndc.engine.card.bonus;

/**
 * Zawiera stałe użyte do komunikacji z systemem bonusów. 
 * 
 * @author bambucha
 */
public enum BonusConstans
{
    STRENGHT("Strenght","Siła"),
    DEXTERITY("Dexterity","Zręczność"),
    CONSTRUCTION("Construction","Budowa"),
    INTELIGENCE("Intelligence","Inteligencja"),
    WISDOM("Wisdom","Roztropność"),
    CHARISMA("Charisma","Charyzma"),
    ARMOR("Armor","Klasa Pancerza"),
    MELLE("Melee Attack","Atak wręcz"),
    RANGE("Range Attack","Atak dystansowy"),
    GRAPPLE("Grapple Attack","Zwarcie"),
    INITIATIVE("Initiative","Incjatywa"),
    FORTITUDE("Fortitude Throw","Wytrzymałość"),
    REFLEX("Reflex Throw","Reflex"),
    WILL("Will Throw","Wola");
    
    private String token;
    private String label;
    
    private BonusConstans(String name,String label)
    {
        this.token = name;
        this.label = label;
    }
    
    @Override
    public String toString()
    {
        return label;
    }
    
    public String getConstans()
    {
        return token;
    }
    
    public static String[] names()
    {
        String[] name = new String[values().length];
        int index = 0;
        for(BonusConstans bonus : values())
            name[index++] = bonus.toString();
        return name;
    }
}
