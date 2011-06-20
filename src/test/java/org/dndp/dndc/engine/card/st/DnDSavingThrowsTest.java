/*
 * To change this template, choose Tools | Templates and open the template in the editor.
 */

package org.dndp.dndc.engine.card.st;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.dndp.dndc.engine.Character;
import org.dndp.dndc.engine.card.bonus.BonusManager;
import org.dndp.dndc.engine.card.bonus.DnDBonusManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;


/**
 * 
 * @author bambucha
 */
public class DnDSavingThrowsTest
{

    Character d    = new Character();
    BonusManager     s    = new DnDBonusManager(d,d);
    DnDSavingThrows  test = new DnDSavingThrows(s);

    public DnDSavingThrowsTest()
    {}

    @BeforeClass
    public static void setUpClass() throws Exception
    {}

    @AfterClass
    public static void tearDownClass() throws Exception
    {}

    @Test
    public void testGetForttiude()
    {
        System.out.println("getForttiude");
        DnDSavingThrows instance = test;
        SavingThrow result = instance.getForttiude();
        assertTrue(result instanceof FortitudeThrow);
    }

    @Test
    public void testGetReflex()
    {
        System.out.println("getReflex");
        DnDSavingThrows instance = test;
        SavingThrow result = instance.getReflex();
        assertTrue(result instanceof ReflexThrow);
    }

    @Test
    public void testGetWill()
    {
        System.out.println("getWill");
        DnDSavingThrows instance = test;
        SavingThrow result = instance.getWill();
        assertTrue(result instanceof WillThrow);
    }

    @Test
    public void testGetSpellResistance()
    {
        System.out.println("getSpellResistance");
        DnDSavingThrows instance = test;
        Double expResult = 0.0;
        Double result = instance.getSpellResistance();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetSpellResistance()
    {
        System.out.println("setSpellResistance");
        double newValue = 2.5;
        DnDSavingThrows instance = test;
        instance.setSpellResistance(newValue);
        assertEquals(instance.getSpellResistance(), newValue,0.01);
    }
}
