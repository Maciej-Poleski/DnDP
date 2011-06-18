package org.dndp.dndc.engine.card.classes;

import java.util.List;

import org.dndp.dndc.engine.check.CheckFailException;

public interface CharacterClassManager
{

    /**
     * Zwraca obecny poziom postaci
     * @return Level postaci.
     */
    public abstract Integer getLevel();

    /**
     * Odpowiada na pytanie czy posatać jest wielokalsowa.
     * @return Czy wielokasowa.
     */
    public abstract boolean isMultiClassCharacter();

    /**
     * Zwraca obecną ilość punktów doświadczenia.
     * @return Ilość punktów doświadczenia
     */
    public abstract Integer getExperiancePoint();

    /**
     * Ustwaia nową ilość punktów doświadczenia.
     * @param experiancePoint Nowa ilość punktów doświadczenia.
     */
    public abstract void setExperiancePoint(Integer experiancePoint);

    /**
     * Odpowiada czy postać może być awansowana w jakieś klasie.
     * @return
     */
    public abstract boolean isPromoted();

    /**
     * Wykorzystaj możliwość i rozwiń postać w danej klasie.
     * @param classes
     * @throws Exception
     */
    public abstract void promote(BaseClass classes) throws CheckFailException;
    
    /**
     * Zwraca poziom w danej klasie postaci.
     * @param classes
     * @return
     */
    public abstract Integer getClassLevel(BaseClass classes);
    
    /**
     * Zwarac listę klas jaką posiada listę klas.
     * @return Lista klas postaci.
     */
    public abstract  List<CharacterClass> getClassList(); 
}
