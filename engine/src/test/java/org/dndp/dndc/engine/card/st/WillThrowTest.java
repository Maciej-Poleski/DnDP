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
public class WillThrowTest
{

    static WillThrow test = new WillThrow();

    public WillThrowTest()
    {}

    @Test
    public void testCountModifier()
    {
        assertEquals(AbilityType.WISDOM, test.getAbilityName());
    }

}
