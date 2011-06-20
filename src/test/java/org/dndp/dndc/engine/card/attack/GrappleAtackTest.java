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
public class GrappleAtackTest
{
    static FantasyCharacter     main = new FantasyCharacter();
    static GrappleAttack dupa = new GrappleAttack(main);

    public GrappleAtackTest()
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
