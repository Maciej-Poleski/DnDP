package org.dndp.dndc.engine.card.bonus;

import java.util.Collections;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Typ premi maksymalizowanej. Oznacza to że jako bonus bierzę się maksymalną
 * wartośc wynikającą z danego atrybutu.
 * 
 * @author bambucha
 */
public class MaximizedBonus implements Bonus
{
    SortedMap<Integer, Integer> bonusSet;

    /**
     * Tworzy bonus pustą.
     */
    public MaximizedBonus()
    {
        this.bonusSet = Collections
                .synchronizedSortedMap(new TreeMap<Integer, Integer>());
        bonusSet.put(0, 0);
    }

    @Override
    public void addBonus(Integer bonus)
    {
        if (bonusSet.get(bonus) == null)
            bonusSet.put(bonus, 0);
        Integer get = bonusSet.get(bonus);
        bonusSet.remove(bonus);
        bonusSet.put(bonus, get + 1);
    }

    @Override
    public void removeBonus(Integer bonus)
    {
        Integer get = bonusSet.get(bonus);
        if (get == null)
            throw new IllegalArgumentException("Nie ma premii do usunięcia");
        bonusSet.remove(bonus);
        if (get < 1)
            bonusSet.put(bonus, get - 1);
    }

    @Override
    public Integer getBonus()
    {
        return bonusSet.lastKey() - bonusSet.firstKey();
    }
}
