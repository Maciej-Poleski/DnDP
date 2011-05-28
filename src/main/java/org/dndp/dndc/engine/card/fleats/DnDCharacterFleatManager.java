package org.dndp.dndc.engine.card.fleats;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.dndp.dndc.engine.Character;
import org.dndp.dndc.engine.benefit.Benefit;
import org.dndp.dndc.engine.check.Checkable;


/**
 * Klasa zajmująca się zarządzaniem atutami.
 * Również wszystkimi obowiązkami wynikającymi z piastującej funkcji. 
 * @author evil, bambucha
 */
public class DnDCharacterFleatManager implements CharacterFleatManager
{
    private Map<Fleat, CharacterFleat> characterFleatsMapping;
    private Character                  character;

    /**
     * Konstruktor.
     * 
     * @param character
     *            Postać
     */
    public DnDCharacterFleatManager(Character character)
    {
        this.character = character;
        characterFleatsMapping = new HashMap<Fleat, CharacterFleat>();

    }

    /**
     * Pobiera listę atutów.
     * 
     * @return
     */
    @Override
    public Collection<CharacterFleat> getAllCharacterFleats()
    {
        return characterFleatsMapping.values();
    }

    /**
     * Zwraca CharacterFleat dla danego Fleat
     * 
     * @param key Atut
     * @return Atut postaci odpowiadający atutowi
     */
    @Override
    public CharacterFleat getCharacterFleat(Fleat key)
    {
        return characterFleatsMapping.get(key);
    }
    
    /**
     * Sprawdza czy atut jest możliwy do wzięcia.
     * @param fleat Atut do sprawdzenia.
     * @return true, jeśli można wziąć.
     */
    public boolean checkFleat(Fleat fleat)
    {
        boolean result = true;
        for (Checkable c : fleat.getDependency())
            result = result && c.check(character);
        return result;
    }
    
    /**
     * Ustawia wszystkie premię atutu na postaci.
     * @param fleat Atut do ustawienia premi.
     */
    public void setFleatBenefit(Fleat fleat)
    {
        for(Benefit b : fleat.getBenefits())
            b.apply(character);
    }
    
    /**
     * Zabiera wszystkie premię wynikające z atutu.
     * @param fleat Atut do wzięcia premi.
     */
    public void unsetFleatBenefit(Fleat fleat)
    {
        for(Benefit b : fleat.getBenefits())
            b.abandon(character);
    }

    /**
     * Aktualizuje wszystkie atuty.
     */
    public void update()
    {
        for (CharacterFleat characterFleat : characterFleatsMapping.values())
            characterFleat.isPossible();
    }

}
