/*
 * To change this template, choose Tools | Templates and open the template in the editor.
 */

package org.dndp.dndc.engine.card.st;

import static org.junit.Assert.assertEquals;

import org.dndp.dndc.engine.card.abilities.AbilityType;
import org.junit.Test;


/**
 * 
 * @author bambucha
 */
public class ReflexThrowTest
{
    static ReflexThrow test = new ReflexThrow();

    public ReflexThrowTest()
    {

    }

    @Test
    public void testCountModifier()
    {
        assertEquals(AbilityType.DEXTERITY, test.getAbilityName());

    }

}
