/*
 * To change this template, choose Tools | Templates and open the template in the editor.
 */

package org.dndp.dndc.engine.card.abilities;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.dndp.dndc.engine.card.bonus.DnDBonusManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;


/**
 * 
 * @author bambucha
 */
public class DnDAbilitiesTest
{

    public DnDAbilitiesTest()
    {}

    DnDAbilities dupa = new DnDAbilities(new DnDBonusManager(null));

    @BeforeClass
    public static void setUpClass() throws Exception
    {

    }

    @AfterClass
    public static void tearDownClass() throws Exception
    {}

    /**
     * Test of getStrenght method, of class DnDAbilities.
     */
    @Test
    public void testGetStrenght()
    {
        System.out.println("getStrenght");
        DnDAbilities instance = dupa;
        Abiliti result = instance.getStrenght();
        assertNotNull(result);
        assertTrue(result instanceof Abiliti);
    }

    /**
     * Test of getDexterity method, of class DnDAbilities.
     */
    @Test
    public void testGetDexterity()
    {
        System.out.println("getDexterity");
        DnDAbilities instance = dupa;
        Abiliti result = instance.getDexterity();
        assertNotNull(result);
        assertTrue(result instanceof Abiliti);
    }

    /**
     * Test of getConstitution method, of class DnDAbilities.
     */
    @Test
    public void testGetConstitution()
    {
        System.out.println("getConstitution");
        DnDAbilities instance = dupa;
        Abiliti result = instance.getConstitution();
        assertNotNull(result);
        assertTrue(result instanceof Abiliti);
    }

    /**
     * Test of getInteligence method, of class DnDAbilities.
     */
    @Test
    public void testGetInteligence()
    {
        System.out.println("getInteligence");
        DnDAbilities instance = dupa;
        Abiliti result = instance.getInteligence();
        assertNotNull(result);
        assertTrue(result instanceof Abiliti);
    }

    /**
     * Test of getWisdom method, of class DnDAbilities.
     */
    @Test
    public void testGetWisdom()
    {
        System.out.println("getWisdom");
        DnDAbilities instance = dupa;
        Abiliti result = instance.getWisdom();
        assertNotNull(result);
        assertTrue(result instanceof Abiliti);
    }

    /**
     * Test of getCharisma method, of class DnDAbilities.
     */
    @Test
    public void testGetCharisma()
    {
        System.out.println("getCharisma");
        DnDAbilities instance = dupa;
        Abiliti result = instance.getCharisma();
        assertNotNull(result);
        assertTrue(result instanceof Abiliti);
    }

}
