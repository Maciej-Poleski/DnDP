package org.dndp.dndc.engine.card.bonus;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Logger;

import org.dndp.dndc.engine.card.abilities.Abiliti;
import org.dndp.dndc.engine.card.abilities.Abilities;
import org.dndp.dndc.engine.card.armor.Armor;
import org.dndp.dndc.engine.card.description.Description;

/**
 * Zajmuje się obsługą, pomocników liczących premię. Przez tą klasę trzeba
 * przepychać wszytkie zmianny. Wzorzec projektowy singleton.
 * 
 * @par TODO Zastanowienie się nad potrzebą wprowadzenia przestrzeni nazw (z
 *      góry określonej jakiej), i wprowadznie takowej.
 * @author bambucha
 */
public class DnDBonusManager implements BonusManager, Observer
{
    private static Logger                 log              = Logger.getLogger("fantasyCharacter.bonusManager");

    private Map<String, BaseBonusHandler> bonusHandlerPool = new HashMap<String, BaseBonusHandler>();
    private final Abilities               abilities;
    private final Description             description;

    /**
     * Standardowy konstruktor.
     * 
     * @param a
     *            Atrybuty postaci.
     */
    public DnDBonusManager(Abilities abilities, Description description)
    {
        this.abilities = abilities;
        this.description = description;
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
            throw new IllegalArgumentException(
                    "Rejestracja drugi raz tego samego klucza");
        if(newBonus instanceof Armor)
            bonusHandlerPool.put(name, new ArmorBonusHandler(newBonus,
                    abilities, description));
        else
            bonusHandlerPool.put(name, new BaseBonusHandler(newBonus,
                    abilities, description));

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
            throw new IllegalArgumentException(
                    "Nie zarejetrowano takiego bonusu");
        else
            return t;
    }

    private void updateIfSizeImportant()
    {
        for(BaseBonusHandler bonus : bonusHandlerPool.values())
            if(bonus.isSizeImportant())
                bonus.countBonus();
    }

    private void updateIfAbilitiImportant()
    {
        for(BaseBonusHandler bonus : bonusHandlerPool.values())
            if(bonus.isAbilitiImportant())
                bonus.countBonus();
    }

    @Override
    public void update(Observable o, Object arg)
    {
        log.info("Przyszło uaktualnienie");
        if(o instanceof Description)
            updateIfSizeImportant();
        if(o instanceof Abiliti)
            updateIfAbilitiImportant();
    }

}
