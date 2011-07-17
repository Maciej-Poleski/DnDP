package org.dndp.dndc.engine.util;

import java.util.Observable;
import java.util.Observer;

public class ChangeObservable extends Observable
{
    @Override
    public synchronized void addObserver(Observer o)
    {
        super.addObserver(o);
        setChanged();
        notifyObservers();
    }
}
