package org.dndp.dndc.engine.card.attack;


import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Observable;

/**
 * Klasa kapsułkująca bazową premię do ataku
 *
 * @author bambucha, evil
 */
public class BaseBonusToAttack extends Observable implements Iterable<Integer>, Comparable<BaseBonusToAttack> {
    private final List<Integer> bonus = new LinkedList<Integer>();

    public BaseBonusToAttack() {
        // DO NOTHING
    }

    /**
     * Inicjalizuje obiekt czteroma liczbami.
     *
     * @throws IllegalArgumentException Gdy któryś z argumentów jest ujemny.
     */
    public BaseBonusToAttack(int first, int second, int third, int fourth) throws IllegalArgumentException {
        if (first < 0 || second < 0 || third < 0 || fourth < 0)
            throw new IllegalArgumentException("Bazowa premia nie może być ujemna");
        bonus.add(first);
        bonus.add(second);
        bonus.add(third);
        bonus.add(fourth);
    }

    /**
     * Zwraca wartość wskazanego pola listy bonus.
     *
     * @param position Wybrane pole
     * @return Wartość wybranego pola.
     */
    private int getField(int position) {
        return bonus.get(position);
    }

    public int first() {
        return getField(0);
    }

    public int second() {
        return getField(1);
    }

    public int third() {
        return getField(2);
    }

    public int fourth() {
        return getField(3);
    }

    /**
     * Ustawia wybrane pole w kolekcji bonus.
     *
     * @param selectedField Wybrane pole (w przedziale [0,3])
     * @param newValue      Wartość która zostanie zagwarantowana
     * @throws IllegalArgumentException  Gdy podana wartość jest ujemna
     * @throws IndexOutOfBoundsException Gdy wybrane pole nie może zostać ustawione
     */
    private void setBonusField(int selectedField, int newValue) throws IllegalArgumentException, IndexOutOfBoundsException {
        if (selectedField < 0 || selectedField > 3)
            throw new IllegalArgumentException("Wybrałeś zły numer pola (czy aby napewno chcesz użyć tej metody?)");
        if (newValue < 0)
            throw new IllegalArgumentException("Bazowa premia nie może być ujemna");
        if (bonus.get(selectedField).equals(newValue))
            return;
        try {
            bonus.remove(selectedField);
        } catch (IndexOutOfBoundsException e) {
            // ALL RIGHT - DO NOTHING
        }
        bonus.add(selectedField, newValue);
        setChanged();
        notifyObservers(this);
    }

    public BaseBonusToAttack setFirst(int first) throws IllegalArgumentException {
        setBonusField(0, first);
        return this;
    }

    public BaseBonusToAttack setSecond(int second) throws IllegalArgumentException {
        setBonusField(1, second);
        return this;
    }

    public BaseBonusToAttack setThird(int third) throws IllegalArgumentException {
        setBonusField(2, third);
        return this;
    }

    public BaseBonusToAttack setFourth(int fourth) throws IllegalArgumentException {
        setBonusField(3, fourth);
        return this;
    }


    /**
     * Zwraca ilość ataków
     *
     * @return ilość ataków
     */
    public int getNumberOfAttacks() {
        return bonus.size();
    }

    @Override
    public Iterator<Integer> iterator() {
        return bonus.iterator();
    }

    @Override
    public int compareTo(BaseBonusToAttack o) {
        if (getNumberOfAttacks() < o.getNumberOfAttacks())
            return -1;
        else if ((getNumberOfAttacks() > o.getNumberOfAttacks()))
            return 1;
        for (int q = 0; q < getNumberOfAttacks(); ++q)
            if (getField(q) - o.getField(q) != 0)
                return getField(q) - o.getField(q);
        return 0;
    }

}

