/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */

package org.dndp.dndc.engine.card.attack;

import org.dndp.dndc.engine.FantasyCharacter;
import org.junit.AfterClass;
import org.junit.BeforeClass;

/**
 * 
 * @author bambucha
 */
public class RangeAtackTest
{
    static FantasyCharacter main = new FantasyCharacter();

    // static RangeAttack dupa = new RangeAttack();

    public RangeAtackTest()
    {
        main.getStrenght().setValue(16);
        main.getDexterity().setValue(13);
    }

    @BeforeClass
    public static void setUpClass() throws Exception
    {}

    @AfterClass
    public static void tearDownClass() throws Exception
    {}
}
