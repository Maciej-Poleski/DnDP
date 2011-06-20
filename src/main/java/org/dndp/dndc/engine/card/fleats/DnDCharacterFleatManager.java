package org.dndp.dndc.engine.card.fleats;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import org.dndp.dndc.engine.FantasyCharacter;
import org.dndp.dndc.engine.benefit.Benefit;
import org.dndp.dndc.engine.check.Checkable;


/**
 * Klasa zajmująca się zarządzaniem atutami.
 * Również wszystkimi obowiązkami wynikającymi z piastującej funkcji. 
 * @author evil, bambucha
 */
public class DnDCharacterFleatManager extends Observable implements CharacterFleatManager, Observer
{
    private Map<Fleat, CharacterFleat> characterFleatsMapping;
    private FantasyCharacter                  fantasyCharacter;

    /**
     * Konstruktor.
     * 
     * @param fantasyCharacter
     *            Postać
     */
    public DnDCharacterFleatManager(FantasyCharacter fantasyCharacter)
    {
        this.fantasyCharacter = fantasyCharacter;
        characterFleatsMapping = new HashMap<Fleat, CharacterFleat>();
        for( CharacterFleat fleat : characterFleatsMapping.values())
            fleat.addObserver(this);
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
            result = result && c.check(fantasyCharacter);
        return result;
    }
    
    /**
     * Ustawia wszystkie premię atutu na postaci.
     * @param fleat Atut do ustawienia premi.
     */
    public void setFleatBenefit(Fleat fleat)
    {
        for(Benefit b : fleat.getBenefits())
            b.apply(fantasyCharacter);
    }
    
    /**
     * Zabiera wszystkie premię wynikające z atutu.
     * @param fleat Atut do wzięcia premi.
     */
    public void unsetFleatBenefit(Fleat fleat)
    {
        for(Benefit b : fleat.getBenefits())
            b.abandon(fantasyCharacter);
    }

    /**
     * Aktualizuje wszystkie atuty.
     */
    public void update()
    {
        for (CharacterFleat characterFleat : characterFleatsMapping.values())
            characterFleat.isPossible();
    }

    @Override
    public void update(Observable o, Object arg)
    {
        setChanged();
        notifyObservers(arg);
    }

}
