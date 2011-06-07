package org.dndp.dndc.engine.card.description;

import org.dndp.dndc.engine.PersonalityTypes;

/**
 * Interfejs zapeawniajacy postaci mozliwosc opisu
 * 
 * @author bambucha
 */
public interface Description
{
    public String getName();

    public void setName(String newValeu);

    public String getPlayer();

    public void setPlayer(String newValeu);

    public Race getRase();

    public void setRase(Race raceOfPlayer);

    public PersonalityTypes getPersonality();

    public void setPersonality(PersonalityTypes newValeu);

    public God getGod();

    public void setGod(God newValeu);

    public Size getSize();

    public void setSize(Size newValeu);

    public int getAge();

    public void setAge(int newValeu);

    public Sex getSex();

    public void setSex(Sex newValeu);

    public int getHeight();

    public void setHeight(int newValeu);

    public int getWeight();

    public void setWeight(int newValeu);

    public String getEye();

    public void setEye(String newValeu);

    public String getHair();

    public void setHair(String newValeu);

    public String getSkin();

    public void setSkin(String newValeu);
}
