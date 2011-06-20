/*
 * To change this template, choose Tools | Templates and open the template in the editor.
 */

package org.dndp.dndc.engine.card.attack;

import org.dndp.dndc.engine.Character;
import org.junit.AfterClass;
import org.junit.BeforeClass;

/**
 * 
 * @author bambucha
 */
public class MeleeAtackTest
{
    static Character main = new Character();
    static MeleeAttack      dupa = new MeleeAttack();

    public MeleeAtackTest()
    {
        main.getStrenght().setValue(16);
        main.getDexterity().setValue(13);
    }

    @BeforeClass
    public static void setUpClass() throws Exception
    {}

    @AfterClass
    public static void tearDownClass() throws Exception
    {

    }

}
