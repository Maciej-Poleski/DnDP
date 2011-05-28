package org.dndp.dndc.engine.card.description;

import org.dndp.dndc.engine.PersonalityTypes;

/**
 * Implementacja opisu postaci
 * 
 * @author bambucha
 */
public class DnDDescription implements Description
{
    private String           name;
    private String           player;
    private Race             race;
    private PersonalityTypes personality;
    private God              god;
    private Size             size;
    private Integer          age;
    private Sex              sex;
    private Integer          height;
    private Integer          weight;
    private String           eye;
    private String           hair;
    private String           skin;

    public DnDDescription()
    {
        this.name = new String();
        this.player = new String();
        this.race = new Race();
        this.personality = PersonalityTypes.NN;
        this.god = new God();
        this.size = Size.MEDIUM;
        this.age = new Integer(0);
        this.sex = Sex.MALE;
        this.height = new Integer(170);
        this.weight = new Integer(100);
        this.eye = new String("red");
        this.hair = new String("Black");
        this.skin = new String("white");
    }

    @Override
    public String getName()
    {
        return this.name;
    }

    @Override
    public String getPlayer()
    {
        return this.player;
    }

    @Override
    public Race getRase()
    {
        return this.race;
    }

    @Override
    public PersonalityTypes getPersonality()
    {
        return this.personality;
    }

    @Override
    public God getGod()
    {
        return this.god;
    }

    @Override
    public Size getSize()
    {
        return this.size;
    }

    @Override
    public Integer getAge()
    {
        return this.age;
    }

    @Override
    public Sex getSex()
    {
        return this.sex;
    }

    @Override
    public Integer getHeight()
    {
        return this.height;
    }

    @Override
    public Integer getWeight()
    {
        return this.weight;
    }

    @Override
    public String getEye()
    {
        return this.eye;
    }

    @Override
    public String getHair()
    {
        return this.hair;
    }

    @Override
    public String getSkin()
    {
        return this.skin;
    }

    @Override
    public void setAge(Integer age)
    {
        if (age == null)
            throw new NullPointerException();
        this.age = age;
    }

    @Override
    public void setPersonality(PersonalityTypes personality)
    {
        if (personality == null)
            throw new NullPointerException();
        this.personality = personality;
    }

    @Override
    public void setEye(String eye)
    {
        if (eye == null)
            throw new NullPointerException();
        this.eye = eye;
    }

    @Override
    public void setGod(God god)
    {
        if (god == null)
            throw new NullPointerException();
        this.god = god;
    }

    @Override
    public void setHair(String hair)
    {
        if (hair == null)
            throw new NullPointerException();
        this.hair = hair;
    }

    @Override
    public void setHeight(Integer height)
    {
        if (height == null)
            throw new NullPointerException();
        this.height = height;
    }

    @Override
    public void setName(String name)
    {
        if (name == null)
            throw new NullPointerException();
        this.name = name;
    }

    @Override
    public void setPlayer(String player)
    {
        if (player == null)
            throw new NullPointerException();
        this.player = player;
    }

    @Override
    public void setSex(Sex sex)
    {
        if (sex == null)
            throw new NullPointerException();
        this.sex = sex;
    }

    @Override
    public void setSize(Size size)
    {
        if (size == null)
            throw new NullPointerException();
        this.size = size;
    }

    @Override
    public void setSkin(String skin)
    {
        if (skin == null)
            throw new NullPointerException();
        this.skin = skin;
    }

    @Override
    public void setWeight(Integer weight)
    {
        if (weight == null)
            throw new NullPointerException();
        this.weight = weight;
    }

    @Override
    public void setRase(Race raceOfPlayer)
    {
        if (raceOfPlayer == null)
            throw new NullPointerException();
        this.race = raceOfPlayer;
    }

}
