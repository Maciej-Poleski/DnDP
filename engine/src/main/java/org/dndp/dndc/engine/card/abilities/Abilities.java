package org.dndp.dndc.engine.card.abilities;

import java.util.Observer;

import org.dndp.dndc.engine.FantasyCharacter;

/**
 * Interfejs obsługi atrybutów
 * 
 * TODO dokumentacja
 * 
 * @author bambucha
 * @see FantasyCharacter.engine.Character
 * @see engine.karta.abilities.DnDAbilities
 */
public interface Abilities
{
    public Abiliti getStrenght();

    public Abiliti getDexterity();

    public Abiliti getConstitution();

    public Abiliti getInteligence();

    public Abiliti getWisdom();

    public Abiliti getCharisma();

    public void addObserverToAbilities(Observer o);

    public void removeObserverFromAbilities(Observer o);

    public void removeAllObserversFromAbilites();
}
