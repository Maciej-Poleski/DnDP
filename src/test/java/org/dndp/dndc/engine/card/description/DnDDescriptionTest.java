/*
 * To change this template, choose Tools | Templates and open the template in the editor.
 */

package org.dndp.dndc.engine.card.description;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.dndp.dndc.engine.PersonalityTypes;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;


/**
 * 
 * @author bambucha
 */
public class DnDDescriptionTest
{

    public DnDDescriptionTest()
    {}

    @BeforeClass
    public static void setUpClass() throws Exception
    {}

    @AfterClass
    public static void tearDownClass() throws Exception
    {}

    @Test
    public void testGetName()
    {
        System.out.println("getName");
        DnDDescription instance = new DnDDescription();
        String expResult = "";
        String result = instance.getName();
        assertNotNull(result);
        assertEquals(expResult, result);

    }

    @Test
    public void testGetPlayer()
    {
        System.out.println("getPlayer");
        DnDDescription instance = new DnDDescription();
        String expResult = "";
        String result = instance.getPlayer();
        assertNotNull(result);
        assertEquals(expResult, result);
    }

    @Test
    public void testGetRase()
    {
        System.out.println("getRase");
        DnDDescription instance = new DnDDescription();
        Race result = instance.getRase();
        assertNotNull(result);
        //assertEquals(expResult, result);
    }

    @Test
    public void testGetPersonality()
    {
        System.out.println("getPersonality");
        DnDDescription instance = new DnDDescription();
        PersonalityTypes result = instance.getPersonality();
        assertNotNull(result);
        // assertEquals(expResult, result);

    }

    @Test
    public void testGetGod()
    {
        System.out.println("getGod");
        DnDDescription instance = new DnDDescription();
        God result = instance.getGod();
        assertNotNull(result);
        //assertEquals(expResult, result);

    }

    @Test
    public void testGetSize()
    {
        System.out.println("getSize");
        DnDDescription instance = new DnDDescription();
        Size expResult = Size.MEDIUM;
        Size result = instance.getSize();
        assertNotNull(result);
        assertEquals(expResult, result);

    }

    @Test
    public void testGetAge()
    {
        System.out.println("getAge");
        DnDDescription instance = new DnDDescription();
        Integer expResult = 0;
        Integer result = instance.getAge();
        assertNotNull(result);
        assertEquals(expResult, result);

    }

    @Test
    public void testGetSex()
    {
        System.out.println("getSex");
        DnDDescription instance = new DnDDescription();
        Sex expResult = Sex.MALE;
        Sex result = instance.getSex();
        assertNotNull(result);
        assertEquals(expResult, result);

    }

    @Test
    public void testGetHeight()
    {
        System.out.println("getHeight");
        DnDDescription instance = new DnDDescription();
        Integer expResult = 170;
        Integer result = instance.getHeight();
        assertNotNull(result);
        assertEquals(expResult, result);

    }

    @Test
    public void testGetWeight()
    {
        System.out.println("getWeight");
        DnDDescription instance = new DnDDescription();
        Integer expResult = 100;
        Integer result = instance.getWeight();
        assertNotNull(result);
        assertEquals(expResult, result);

    }

    @Test
    public void testGetEye()
    {
        System.out.println("getEye");
        DnDDescription instance = new DnDDescription();
        String result = instance.getEye();
        assertNotNull(result);
        //assertEquals(expResult, result);

    }

    @Test
    public void testGetHair()
    {
        System.out.println("getHair");
        DnDDescription instance = new DnDDescription();
        String result = instance.getHair();
        assertNotNull(result);
        //assertEquals(expResult, result);

    }

    @Test
    public void testGetSkin()
    {
        System.out.println("getSkin");
        DnDDescription instance = new DnDDescription();
        String result = instance.getSkin();
        assertNotNull(result);
        //assertEquals(expResult, result);
    }

    @Test
    public void testSetAge()
    {
        System.out.println("setAge");
        Integer age = 13;
        DnDDescription instance = new DnDDescription();
        instance.setAge(age);
        assertEquals(age, instance.getAge());

    }

    @Test(expected = NullPointerException.class)
    public void testSetAgeNullException()
    {
        System.out.println("setAge null");
        Integer age = null;
        DnDDescription instance = new DnDDescription();
        instance.setAge(age);
    }

    @Test
    public void testSetPersonality()
    {
        System.out.println("setPersonality");
        PersonalityTypes personality = PersonalityTypes.CZ;
        DnDDescription instance = new DnDDescription();
        instance.setPersonality(personality);
        assertEquals(personality, instance.getPersonality());

    }

    @Test(expected = NullPointerException.class)
    public void testSetPersonalityNullException()
    {
        System.out.println("setPersonality null");
        PersonalityTypes personality = null;
        DnDDescription instance = new DnDDescription();
        instance.setPersonality(personality);
    }

    @Test
    public void testSetEye()
    {
        System.out.println("setEye");
        String eye = "";
        DnDDescription instance = new DnDDescription();
        instance.setEye(eye);
        assertEquals(eye, instance.getEye());
    }

    @Test(expected = NullPointerException.class)
    public void testSetEyeNull()
    {
        System.out.println("setEye null");
        String eye = null;
        DnDDescription instance = new DnDDescription();
        instance.setEye(eye);
    }

    @Test
    public void testSetGod()
    {
        System.out.println("setGod");
        God god = new God();
        DnDDescription instance = new DnDDescription();
        instance.setGod(god);
        assertEquals(god, instance.getGod());
    }

    @Test(expected = NullPointerException.class)
    public void testSetGodNull()
    {
        System.out.println("setGod null");
        God god = null;
        DnDDescription instance = new DnDDescription();
        instance.setGod(god);
    }

    @Test
    public void testSetHair()
    {
        System.out.println("setHair");
        String hair = "rude";
        DnDDescription instance = new DnDDescription();
        instance.setHair(hair);
        assertEquals(hair, instance.getHair());
    }

    @Test(expected = NullPointerException.class)
    public void testSetHairNull()
    {
        System.out.println("setHair null");
        String hair = null;
        DnDDescription instance = new DnDDescription();
        instance.setHair(hair);
    }

    @Test
    public void testSetHeight()
    {
        System.out.println("setHeight");
        Integer height = 999;
        DnDDescription instance = new DnDDescription();
        instance.setHeight(height);
        assertEquals(height, instance.getHeight());
    }

    @Test(expected = NullPointerException.class)
    public void testSetHeightNull()
    {
        System.out.println("setHeight null");
        Integer height = null;
        DnDDescription instance = new DnDDescription();
        instance.setHeight(height);
    }

    @Test
    public void testSetName()
    {
        System.out.println("setName");
        String name = "dupad12";
        DnDDescription instance = new DnDDescription();
        instance.setName(name);
    }

    @Test(expected = NullPointerException.class)
    public void testSetNameNull()
    {
        System.out.println("setName null");
        String name = null;
        DnDDescription instance = new DnDDescription();
        instance.setName(name);
    }

    @Test
    public void testSetPlayer()
    {
        System.out.println("setPlayer");
        String player = "czarnuch";
        DnDDescription instance = new DnDDescription();
        instance.setPlayer(player);
        assertEquals(player, instance.getPlayer());
    }

    @Test(expected = NullPointerException.class)
    public void testSetPlayerNull()
    {
        System.out.println("setPlayer null");
        String player = null;
        DnDDescription instance = new DnDDescription();
        instance.setPlayer(player);
    }

    @Test
    public void testSetSex()
    {
        System.out.println("setSex");
        Sex sex = Sex.FEMALE;
        DnDDescription instance = new DnDDescription();
        instance.setSex(sex);
        assertEquals(sex, instance.getSex());

    }

    @Test(expected = NullPointerException.class)
    public void testSetSexNull()
    {
        System.out.println("setSex null");
        Sex sex = null;
        DnDDescription instance = new DnDDescription();
        instance.setSex(sex);

    }

    @Test
    public void testSetSize()
    {
        System.out.println("setSize");
        Size size = Size.LARGE;
        DnDDescription instance = new DnDDescription();
        instance.setSize(size);
        assertEquals(size, instance.getSize());
    }

    @Test(expected = NullPointerException.class)
    public void testSetSizeNull()
    {
        System.out.println("setSize null");
        Size size = null;
        DnDDescription instance = new DnDDescription();
        instance.setSize(size);
    }

    @Test
    public void testSetSkin()
    {
        System.out.println("setSkin");
        String skin = "black";
        DnDDescription instance = new DnDDescription();
        instance.setSkin(skin);
    }

    @Test(expected = NullPointerException.class)
    public void testSetSkinNull()
    {
        System.out.println("setSkin null");
        String skin = null;
        DnDDescription instance = new DnDDescription();
        instance.setSkin(skin);
    }

    @Test
    public void testSetWeight()
    {
        System.out.println("setWeight");
        Integer weight = 3;
        DnDDescription instance = new DnDDescription();
        instance.setWeight(weight);
        assertEquals(weight, instance.getWeight());

    }

    @Test(expected = NullPointerException.class)
    public void testSetWeightNull()
    {
        System.out.println("setWeight null");
        Integer weight = null;
        DnDDescription instance = new DnDDescription();
        instance.setWeight(weight);
    }

    @Test
    public void testSetRase()
    {
        System.out.println("setRase");
        Race raceOfPlayer = new Race();
        DnDDescription instance = new DnDDescription();
        instance.setRase(raceOfPlayer);
        assertEquals(raceOfPlayer, instance.getRase());
    }

    @Test(expected = NullPointerException.class)
    public void testSetRaseNull()
    {
        System.out.println("setRase");
        Race raceOfPlayer = null;
        DnDDescription instance = new DnDDescription();
        instance.setRase(raceOfPlayer);
    }

}
