package org.dndp.dndc.engine;

/**
 * Klasa na kostki (jest ich troche)
 */
public enum Dice
{

    D4(4), D6(6), D8(8), D10(10), D12(12), D20(20), D100(100);
    private final Integer maxValue;

    Dice(int x)
    {
        maxValue = x;
    }

    /**
     * @return maksymalna wartość na kostce
     */
    public int getMaxValue()
    {
        return maxValue;
    }

    /**
     * Rzuca kostką
     * 
     * @return ilość oczek
     */
    public Integer throwTheDice()
    {
        return new Integer((int)Math.floor((maxValue - 1) * Math.random() + 1));
    }

    /**
     * Rzuca <code>times</code> rozy kostką i zwraca sumę wyników rzutów
     * 
     * @param times
     *            Ilość rzutów kostaką
     * @return suma ilości oczek w <code>times</code> rzutach
     */
    public Integer throwTheDice(Integer times)
    {
        int result = 0;
        for (int q = 0; q < times; ++q)
        {
            result += this.throwTheDice();
        }
        return result;
    }
}
