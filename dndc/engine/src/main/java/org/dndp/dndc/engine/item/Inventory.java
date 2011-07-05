package org.dndp.dndc.engine.item;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import java.util.TreeSet;

import org.dndp.dndc.engine.benefit.Benefit;


/**
 * Ekwipunek. Dla pełnego hardcoru implementuje Iterable dla foreach<br/>
 * Oddelegowanie metod <code>listOfItems</code> w celu wytworzenia kontenerowego API.
 * 
 * @author evil, bambucha
 */
public class Inventory extends Item implements Iterable<Item>
{
    private Set<Item>             listOfItems = new TreeSet<Item>();
    private Collection<Inventory> listOfBag   = new LinkedList<Inventory>();

    /**
     * @see dndp.engine.item.Item
     */
    public Inventory(String name, Double weight, Value value, Benefit[] benefits)
    {
        super(name, weight, value, benefits);
    }

    /**
     * @see java.util.List
     */
    public int size()
    {
        return listOfItems.size();
    }

    /**
     * @see java.util.List
     */
    public boolean remove(Item o)
    {
        if(listOfBag.remove(o))
        {
            setWeight(getWeight() - o.getWeight());
            setValue(Value.subtract(getValue(), o.getValue()));
            return true;
        }
        if(listOfItems.remove(o))
        {
            setWeight(getWeight() - o.getWeight());
            setValue(Value.subtract(getValue(), o.getValue()));
            return true;
        }
        return false;
    }

    /**
     * @see java.lang.Iterable
     */
    @Override
    public Iterator<Item> iterator()
    {
        return listOfItems.iterator();
    }

    /**
     * @see java.util.List
     */
    public boolean isEmpty()
    {
        return listOfItems.isEmpty();
    }

    /**
     * @see java.util.List
     */
    public boolean containsByExample(Item o)
    {
        boolean v = listOfItems.contains(o);
        if(!v)
            for (Inventory i : listOfBag)
                v = v || i.containsByExample(o);
        return v;
    }

    /**
     * @see java.util.List
     */
    public Item getByExample(Item o)
    {
        for (Item item : listOfItems)
            if(item.equals(o))
                return item;
        for (Inventory inventory : listOfBag)
        {
            Item temp = inventory.getByExample(o);
            if(temp != null)
                return temp;
        }
        return null;
    }

    /**
     * Dużo wolniejsze niż przez przykład.
     * 
     * @param o
     *            Nazwa przedmiotu
     * @return
     */
    public boolean containsByName(String name)
    {
        for (Item item : listOfItems)
            if(item.getName().equals(name))
                return true;
        for (Inventory inventory : listOfBag)
            if(inventory.containsByName(name))
                return true;
        return false;
    }

    /**
     * Dużo wolniejsze niż przez przykład.
     * 
     * @param o
     *            Nazwa przedmiotu
     * @return
     */
    public Item getByName(String name)
    {
        for (Item item : listOfItems)
            if(item.getName().equals(name))
                return item;
        for (Inventory inventory : listOfBag)
        {
            Item temp = inventory.getByName(name);
            if(temp != null)
                return temp;
        }
        return null;
    }

    /**
     * @see java.util.List
     */
    public boolean add(Item e)
    {
        if(e.getInventory() != null)
        {
            if(listOfBag.add(e.getInventory()))
            {
                setWeight(getWeight() + e.getWeight());
                setValue(Value.add(e.getValue(), getValue()));
                return true;
            }
            return false;
        }
        else if(listOfItems.add(e))
        {
            setWeight(getWeight() + e.getWeight());
            setValue(Value.add(e.getValue(), getValue()));
            return true;
        }
        return false;
    }

    @Override
    public void putOn()
    {

    }

    @Override
    public void takeOff()
    {

    }

    @Override
    public Inventory getInventory()
    {
        return this;
    }
}
