/*
 * To change this template, choose Tools | Templates and open the template in the editor.
 */

package org.dndp.dndc.engine.card.bonus;

import static org.junit.Assert.assertEquals;

import org.dndp.dndc.engine.Character;
import org.dndp.dndc.engine.card.abilities.Abiliti;
import org.junit.Test;


/**
 * 
 * @author bambucha
 */
public class BonusManagerTest
{
    static Abiliti         s = new Abiliti();
    static Abiliti         d = new Abiliti();
    static Abiliti         w = new Abiliti();

    static Character       a = new Character();
    static DnDBonusManager t = new DnDBonusManager(a);

    /**
     * Zwraca modyfilator jaki powinnien mieć atrybiut, przyz konkretynym bonusie.
     * 
     * @param bonus
     *            Bonus
     * @param t
     *            Atrubut
     * @return Modyfikator
     */
    private Integer getModifier(Integer bonus, Abiliti t)
    {
        return new Integer(((bonus - t.getValue()) + 10) / 2);
    }

    public BonusManagerTest()
    {}

    @Test
    public void testRegisterAndGetBonus()
    {
        t.registerBonus("s", s);
        t.getBonusHandler("s").addBonus(BonusType.SACRED, 2);
        assertEquals(s.getModifier(), getModifier(2, s));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSecondRegisterException()
    {
        t.registerBonus("s", s);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetBonsuException()
    {
        t.getBonusHandler("stredfht");
    }

}
