package org.dndp.dndc.engine.item;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * 
 * @author bambucha
 */
public class ValueTest
{

    Value x;

    public ValueTest()
    {
        x = new Value(4, 132, 22, 33);
    }

    @Test
    public void testAdd()
    {
        System.out.println("add");
        Value b = new Value(3, 90, 90, 90);
        Value instance = new Value(4, 132, 22, 33);
        Value expResult = new Value(30, 4, 4, 3);
        Value result = Value.add(instance, b);
        assertEquals(expResult.toString(), result.toString());
    }

    @Test
    public void testGetCopper()
    {
        System.out.println("getCopper");
        Value instance = x;
        Integer expResult = 3;
        Integer result = instance.getCopper();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetCopper()
    {
        System.out.println("setCopper");
        Integer copper = 10;
        Value instance = x;
        instance.setCopper(copper);
        assertEquals(0, x.getCopper().intValue());
    }

    @Test
    public void testGetGold()
    {
        System.out.println("getGold");
        Value instance = x;
        Integer expResult = 4;
        Integer result = instance.getGold();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetGold()
    {
        System.out.println("setGold");
        Integer gold = 21;
        Value instance = new Value(4, 132, 22, 33);
        instance.setGold(gold);
        assertEquals(1, instance.getGold().intValue());
    }

    @Test
    public void testGetPlatinum()
    {
        System.out.println("getPlatinum");
        Value instance = x;
        Integer expResult = 17;
        Integer result = instance.getPlatinum();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetPlatinum()
    {
        System.out.println("setPlatinum");
        Integer platinum = 5;
        Value instance = x;
        instance.setPlatinum(platinum);
        assertEquals(instance.getPlatinum(), platinum);
    }

    @Test
    public void testGetSilver()
    {
        System.out.println("getSilver");
        Value instance = x;
        Integer expResult = 5;
        Integer result = instance.getSilver();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetSilver()
    {
        System.out.println("setSilver");
        Integer silver = 30;
        Value instance = x;
        instance.setSilver(silver);
        assertEquals(0, instance.getSilver().intValue());
    }

    @Test
    public void testToString()
    {
        System.out.println("toString");
        Value instance = x;
        String expResult = "17 pp 4 gp 5 sp 3 cp";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

}
