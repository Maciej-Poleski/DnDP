package org.dndp.dndc.engine.card.abilities;

import java.util.Observer;

import org.dndp.dndc.engine.card.bonus.BonusManager;

/**
 * Implementacja i obsługa atybutów.
 * 
 * @author bambucha
 * @see dndp.engine.card.abilities.Abilities
 */
public class DnDAbilities implements Abilities
{
    private Abiliti strenght;
    private Abiliti dexterity;
    private Abiliti construction;
    private Abiliti intelligence;
    private Abiliti wisdom;
    private Abiliti charisma;

    public DnDAbilities(BonusManager bonusManager)
    {
        this.strenght = new Abiliti();
        bonusManager.registerBonus("Strenght", strenght);
        this.dexterity = new Abiliti();
        bonusManager.registerBonus("Dexterity", dexterity);
        this.construction = new Abiliti();
        bonusManager.registerBonus("Construction", construction);
        this.intelligence = new Abiliti();
        bonusManager.registerBonus("Intelligence", intelligence);
        this.wisdom = new Abiliti();
        bonusManager.registerBonus("Wisdom", wisdom);
        this.charisma = new Abiliti();
        bonusManager.registerBonus("Charisma", charisma);
    }

    @Override
    public Abiliti getStrenght()
    {
        return this.strenght;
    }

    @Override
    public Abiliti getDexterity()
    {
        return this.dexterity;
    }

    @Override
    public Abiliti getConstitution()
    {
        return this.construction;
    }

    @Override
    public Abiliti getInteligence()
    {
        return this.intelligence;
    }

    @Override
    public Abiliti getWisdom()
    {
        return this.wisdom;
    }

    @Override
    public Abiliti getCharisma()
    {
        return this.charisma;
    }

    @Override
    public void addObserverToAbilities(Observer o)
    {
        strenght.addObserver(o);
        dexterity.addObserver(o);
        construction.addObserver(o);
        intelligence.addObserver(o);
        wisdom.addObserver(o);
        charisma.addObserver(o);
    }
}
