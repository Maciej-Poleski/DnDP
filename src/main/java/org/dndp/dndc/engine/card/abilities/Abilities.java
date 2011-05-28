package org.dndp.dndc.engine.card.abilities;

/**
 * Interfejs obsługi atrybutów
 * 
 * @author bambucha
 * @see dndp.engine.Character
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
}
