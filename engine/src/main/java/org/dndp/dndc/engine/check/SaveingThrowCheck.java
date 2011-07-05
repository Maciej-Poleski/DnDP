package org.dndp.dndc.engine.check;

import org.dndp.dndc.engine.FantasyCharacter;

public class SaveingThrowCheck implements Checkable
{
    private boolean fortitue;
    private boolean dexterity;
    private boolean will;
    private int value;
    
    

    public SaveingThrowCheck(boolean fortitue, boolean dexterity, boolean inteligence, int value)
    {
        super();
        if( ! (fortitue || dexterity || inteligence))
            throw new IllegalArgumentException("Sprawdzenie powinno dotyczyć któregoś z rzutów");
        this.fortitue = fortitue;
        this.dexterity = dexterity;
        this.will = inteligence;
        this.value = value;
    }



    @Override
    public boolean check(FantasyCharacter fantasyCharacter)
    {
        boolean result = true;
        if(fortitue)
        {
            result &= fantasyCharacter.getForttiude().getTotalModifier() >= value;
        }
        if(dexterity)
        {
            result &= fantasyCharacter.getReflex().getTotalModifier() >= value;
        }
        if(will)
        {
            result &= fantasyCharacter.getWill().getTotalModifier() >= value;
        }
        return result;
    }
}
