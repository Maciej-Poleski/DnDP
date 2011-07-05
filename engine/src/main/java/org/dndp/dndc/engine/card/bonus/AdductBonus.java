package org.dndp.dndc.engine.card.bonus;

import java.util.Map;
import java.util.TreeMap;

/**
 * Klasa zajmująca się premiami kumulującymi się.
 * 
 * @author bambucha
 */
public class AdductBonus implements Bonus
{
    private Integer               currentBonus;
    private Integer               currentPenalty;
    private Map<Integer, Integer> modifierHeap;

    /**
     * Konstruktor tworzy premię na poziomie 0.
     */
    public AdductBonus()
    {
        this.currentBonus = 0;
        this.currentPenalty = 0;
        this.modifierHeap = new TreeMap<Integer, Integer>();
    }

    /**
     * Dodaje wartość do premii.
     * 
     * @param bonus
     */
    @Override
    public synchronized void addBonus(Integer bonus)
    {
        if(modifierHeap.get(bonus) == null)
            modifierHeap.put(bonus, 0);
        int get = modifierHeap.get(bonus);
        modifierHeap.remove(bonus);
        modifierHeap.put(bonus, get + 1);
        if (bonus >= 0)
            currentBonus += bonus;
        else
            currentPenalty += bonus;
    }

    /**
     * Obniża premię.
     * 
     * @param bonus
     */
    @Override
    public synchronized void removeBonus(Integer bonus)
    {
        Integer get = modifierHeap.get(bonus);
        if(get == null)
            throw new IllegalArgumentException("Nie ma takiej premi.");
        modifierHeap.remove(bonus);
        if (get < 1)
            modifierHeap.put(bonus, get - 1);
        if (bonus >= 0)
            currentBonus -= bonus;
        else
            currentPenalty -= bonus;
    }

    /**
     * Zwraca aktualną premię.
     * 
     * @return Premia.
     */
    @Override
    public Integer getBonus()
    {
        return currentBonus - currentPenalty;
    }

}
