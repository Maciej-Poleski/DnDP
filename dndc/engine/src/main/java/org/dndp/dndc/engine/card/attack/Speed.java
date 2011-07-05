package org.dndp.dndc.engine.card.attack;

import java.util.Observable;


public class Speed extends Observable
{
    private double speed;

    public Speed()
    {
        speed = 9D;
    }

    /**
     * Zwraca prędkość postaci
     * @return prędkość
     */
    public Double getSpeed()
    {
        return speed;
    }

    /**
     * Ustawia nową predkość i powiadamia o tym zainteresowanych.
     * @param speed nowa prędkość
     */
    public void setSpeed(double speed)
    {
        if(Math.abs(this.speed - speed) >= 0.01)
            setChanged();
        this.speed = speed;
        notifyObservers(getSpeed());
    }
}
