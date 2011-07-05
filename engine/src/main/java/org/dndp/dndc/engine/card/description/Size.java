package org.dndp.dndc.engine.card.description;

/**
 * Enum rozmiarów. Dodatkowo zawarte modyfikatory z rozmiaru. Ustawione w kolejności rosnącego rozmiaru FINE == Filigranowy
 * 
 * @author bambucha
 */
public enum Size
{
    FINE, DIMINUTIVE, TINY, SMALL, MEDIUM, LARGE, HUGE, GARANTUAN, COLOSSAL;

    
    /**
     * Zwraca podstawowy modyfikator wynikający z rozmiaru.
     * @return
     */
    public int getBaseModifier()
    {
        switch (this)
        {
            case FINE:
                return 8;
            case DIMINUTIVE:
                return 4;
            case TINY:
                return 2;
            case SMALL:
                return 1;
            case MEDIUM:
                return 0;
            case LARGE:
                return -1;
            case HUGE:
                return -2;
            case GARANTUAN:
                return -4;
            case COLOSSAL:
                return -8;
            default:
                return 0;
        }
    }

    /**
     * Metoda zwraca modyfikator z rozmaru przy ataku w zwarciu.
     */
    public int getGrappleAttacksModifier()
    {

        switch (this)
        {
            case FINE:
                return -16;
            case DIMINUTIVE:
                return -12;
            case TINY:
                return -8;
            case SMALL:
                return -4;
            case MEDIUM:
                return 0;
            case LARGE:
                return 4;
            case HUGE:
                return 8;
            case GARANTUAN:
                return 12;
            case COLOSSAL:
                return 16;
            default:
                return 0;

        }
    }
}
