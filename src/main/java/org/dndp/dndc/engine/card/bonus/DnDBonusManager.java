package org.dndp.dndc.engine.card.bonus;

import java.util.HashMap;
import java.util.Map;

import org.dndp.dndc.engine.card.abilities.Abilities;
import org.dndp.dndc.engine.card.armor.Armor;


/**
 * Zajmuje się obsługą, pomocników liczących premię. Przez tą klasę trzeba przepychać wszytkie zmianny. Wzorzec projektowy singleton.
 * 
 * @par TODO Zastanowienie się nad potrzebą wprowadzenia przestrzeni nazw (z góry określonej jakiej), i wprowadznie takowej.
 * @author bambucha
 */
public class DnDBonusManager implements BonusManager
{
    private Map<String, BaseBonusHandler> bonusHandlerPool = new HashMap<String, BaseBonusHandler>();
    private Abilities                 abilities;

    /**
     * Standardowy konstruktor.
     * 
     * @param a
     *            Atrybuty postaci.
     */
    public DnDBonusManager(Abilities a)
    {
        abilities = a;
    }

    /**
     * Rejestruje w menadżerze, jedno pole.
     * 
     * @param newBonus
     *            Pole wymagające
     * @param name
     *            Nawa pola
     */
    @Override
    public void registerBonus(String name, Bonusable newBonus)
    {
        if(bonusHandlerPool.get(name) != null)
            throw new IllegalArgumentException("Rejestracja drugi raz tego samego klucza");
        if(newBonus instanceof Armor)
            bonusHandlerPool.put(name, new ArmorBonusHandler(newBonus, abilities));
        else
            bonusHandlerPool.put(name, new BaseBonusHandler(newBonus, abilities));

    }

    /**
     * Zwraca bonus handler do zarejestrowanego składnika.
     * 
     * @param name
     *            Nazwa składnika
     * @return BonusHandlare zajmujący się nim.
     */
    @Override
    public BaseBonusHandler getBonusHandler(String name)
    {
        BaseBonusHandler t = bonusHandlerPool.get(name);
        if(t == null)
            throw new IllegalArgumentException("Nie zarejetrowano takiego bonusu");
        else
            return t;
    }

}
