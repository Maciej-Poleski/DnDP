package org.dndp.dndc.engine.card.classes;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Klasa, singleton, przechowująca informacje o wszystkich klasach. Możliwe że w przyuszłości, ilośc przechowywanych informacji będzie zredukowana do tylko
 * nagłowków.
 * 
 * @author bambucha
 */
public class ClassManager
{
    private static ClassManager    instance;
    private Map<String, BaseClass> classMap;

    /**
     * Na potrzeby singletonu.
     * 
     * Pobiera listę klas z bazy danych.
     */
    protected ClassManager()
    {
        classMap = new HashMap<String, BaseClass>();
    }

    /**
     * Zwraca instancję obiektu. Klasyczny wariant singletownowy.
     * 
     * @return Obiekt Klasy
     */
    public static ClassManager getInstance()
    {
        if(instance == null)
            instance = new ClassManager();
        return instance;
    }

    public BaseClass getClass(String name)
    {
        return classMap.get(name);
    }

    public Set<String> getClassNames()
    {
        return classMap.keySet();
    }
}
