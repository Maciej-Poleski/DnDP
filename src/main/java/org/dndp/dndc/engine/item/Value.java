package org.dndp.dndc.engine.item;

/**
 * Klasa troszczaca się o wartość przedmiotu <br/>
 * Zapewnia odpowiednie przedstawieni wartości. <br/>
 * Sestaw metod do konwersji.<br/>
 * Rozwojawa.
 * 
 * 
 * @author bambucha
 */
public class Value implements Comparable<Value>
{
    Integer platinum;
    Integer gold;
    Integer silver;
    Integer copper;

    /**
     * Standardowy konstruktor.
     * 
     * @param platinum
     *            Ilość platyny
     * @param gold
     *            Ilość złota
     * @param silver
     *            Ilość srebra
     * @param copper
     *            Ilość miedziaków
     */
    public Value(Integer platinum, Integer gold, Integer silver, Integer copper)
    {
        if(platinum < 0 || gold < 0 || silver < 0 || copper < 0)
            throw new IllegalArgumentException("Wartość nie może być ujemna");
        this.platinum = platinum + (int)Math.floor(gold / 10);
        this.gold = gold % 10 + (int)Math.floor(silver / 10);
        this.silver = silver % 10 + (int)Math.floor(copper / 10);
        this.copper = copper % 10;
    }
    
    private Value(int abs)
    {
        this.copper = abs%10;
        this.silver = (abs%100 - this.copper)/10;
        this.gold = (abs%1000 - this.silver*10)/100;
        this.platinum = abs/1000;
    }

    /**
     * Zwraca wartość liczoną w sztukach miedzi.
     * 
     * @return Wartość
     */
    private Integer abs()
    {
        return copper + 10 * silver + 100 * gold + 1000 * platinum;
    }

    /**
     * Ustawia ładnie wartości;
     */
    private void clear()
    {
        platinum = platinum + (int)Math.floor(gold / 10);
        gold = gold % 10 + (int)Math.floor(silver / 10);
        silver = silver % 10 + (int)Math.floor(copper / 10);
        copper = copper % 10;
    }

    /**
     * Odejmuje wartości od sibie, i zwraca wartość bezwzlendną
     * 
     * @param a
     *            Pierwsza wartość
     * @param b
     *            Druga wartość
     * @return Wartość bezwzględna różnicy wartości
     */
    public static Value subtract(Value a, Value b)
    {
        if(a.abs() < b.abs())
            return new Value(b.abs() - a.abs());
        else
            return new Value(a.abs() - b.abs());
        
    }

    /**
     * Sumuje wartości
     * 
     * @param a
     *            Pierwsza wartosć
     * @param b
     *            Druga wartość
     * @return Suma wartości
     */
    public static Value add(Value a, Value b)
    {
        return new Value(a.platinum + b.platinum, a.gold + b.gold, a.silver + b.silver, a.copper + b.copper);
    }

    /**
     * Wartość miedzi
     * 
     * @return Wartość
     */
    public Integer getCopper()
    {
        return copper;
    }

    /**
     * Ustawia nową warotść ilości miedziaków
     * 
     * @param copper
     *            Nowa wartość \
     */
    public void setCopper(Integer copper)
    {
        this.copper = copper;
        clear();
    }

    /**
     * Wartość złota
     * 
     * @return Wartość
     */
    public Integer getGold()
    {
        return gold;
    }

    /**
     * Ustawia wartość złota
     * 
     * @param gold
     *            Nowa wartość
     */
    public void setGold(Integer gold)
    {
        this.gold = gold;
        clear();
    }

    /**
     * Zwraca wartość platyny
     * 
     * @return Wartość
     */
    public Integer getPlatinum()
    {
        return platinum;
    }

    /**
     * Ustawia nową wartość platyny
     * 
     * @param platinum
     *            Nowa wartość
     */
    public void setPlatinum(Integer platinum)
    {
        this.platinum = platinum;
        clear();
    }

    /**
     * Podaje wartość srebra
     * 
     * @return Wartość
     */
    public Integer getSilver()
    {
        return silver;
    }

    /**
     * Ustawia nową wartość srebra
     * 
     * @param silver
     *            Nowa wartość
     */
    public void setSilver(Integer silver)
    {
        this.silver = silver;
        clear();
    }

    /**
     * Zmienia obiekt zgodnie ze schematem "xx pp xx gp xx sp xx cp", gdzie xx to liczba całkowita z przedziału [0,1000)
     * 
     * @return
     * @see Object
     */
    @Override
    public String toString()
    {
        String t = new String();
        if(platinum != 0)
            t += platinum + " pp ";
        if(gold != 0)
            t += gold + " gp ";
        if(silver != 0)
            t += silver + " sp ";
        if(copper != 0)
            t += copper + " cp";
        return t;
    }

    @Override
    public int compareTo(Value t)
    {
        return t.abs() - this.abs();
    }
}
