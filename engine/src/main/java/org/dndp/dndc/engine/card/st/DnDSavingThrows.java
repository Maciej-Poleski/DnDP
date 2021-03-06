package org.dndp.dndc.engine.card.st;

import java.util.Observable;
import java.util.Observer;

import org.dndp.dndc.engine.card.bonus.BonusManager;
import org.dndp.dndc.engine.util.ChangeObservable;

/**
 * Klasa opiekująca sie rzutami obronnymi
 * 
 * @author bambucha
 */
public class DnDSavingThrows extends ChangeObservable implements SavingThrows,
        Observer
{
    private SavingThrow forttiude;
    private SavingThrow reflex;
    private SavingThrow will;
    private double      spell;

    /**
     * Standardowy konstruktor.
     * 
     * @param bonusManager
     *            Widok rzutów.
     */
    public DnDSavingThrows(BonusManager bonusManager)
    {
        forttiude = new FortitudeThrow();
        bonusManager.registerBonus("FortitudeThrow", forttiude);
        reflex = new ReflexThrow();
        bonusManager.registerBonus("ReflexThrow", reflex);
        will = new WillThrow();
        bonusManager.registerBonus("WillThrow", will);
        spell = 0.0;
        forttiude.addObserver(this);
        reflex.addObserver(this);
        will.addObserver(this);
    }

    @Override
    public SavingThrow getForttiude()
    {
        return forttiude;
    }

    @Override
    public SavingThrow getReflex()
    {
        return reflex;
    }

    @Override
    public SavingThrow getWill()
    {
        return will;
    }

    @Override
    public double getSpellResistance()
    {
        return spell;
    }

    @Override
    public void setSpellResistance(double newValue)
    {
        if(newValue < 0)
            throw new IllegalArgumentException("Nie może być < 0");
        if(this.spell != newValue)
            setChanged();
        spell = newValue;
        notifyObservers(this);
    }

    @Override
    public void addSavingThrowObserver(Observer o)
    {
        addObserver(o);
    }

    @Override
    public void removeObserverFromST(Observer o)
    {
        deleteObserver(o);
    }

    @Override
    public void removeObserversFromST()
    {
        deleteObservers();
    }

    @Override
    public void update(Observable o, Object arg)
    {
        setChanged();
        notifyObservers();
    }
}
