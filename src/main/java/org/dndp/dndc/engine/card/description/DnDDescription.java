package org.dndp.dndc.engine.card.description;

import java.util.Observable;
import java.util.Observer;

import org.dndp.dndc.engine.PersonalityTypes;

/**
 * Implementacja opisu postaci
 * 
 * @author bambucha
 */
public class DnDDescription extends Observable implements Description
{
    private String           name;
    private String           player;
    private Race             race;
    private PersonalityTypes personality;
    private God              god;
    private Size             size;
    private int              age;
    private Sex              sex;
    private int              height;
    private int              weight;
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
    public int getAge()
    {
        return this.age;
    }

    @Override
    public Sex getSex()
    {
        return this.sex;
    }

    @Override
    public int getHeight()
    {
        return this.height;
    }

    @Override
    public int getWeight()
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
    public void setAge(int age)
    {
        if(this.age != age)
            setChanged();
        this.age = age;
        notifyObservers();
    }

    @Override
    public void setPersonality(PersonalityTypes personality)
    {
        if(personality == null)
            throw new NullPointerException();
        if(! personality.equals(this.personality))
            setChanged();
        this.personality = personality;
        notifyObservers(this);
    }

    @Override
    public void setEye(String eye)
    {
        if(eye == null)
            throw new NullPointerException();
        if(! eye.equals(this.eye))
            setChanged();
        this.eye = eye;
        notifyObservers(this);
    }

    @Override
    public void setGod(God god)
    {
        if(god == null)
            throw new NullPointerException();
        if(! god.equals(this.god))
            setChanged();
        this.god = god;
        notifyObservers(this);
    }

    @Override
    public void setHair(String hair)
    {
        if(hair == null)
            throw new NullPointerException();
        if(! hair.equals(this.hair))
            setChanged();
        this.hair = hair;
        notifyObservers(this);
    }

    @Override
    public void setHeight(int height)
    {
        if(height != this.height)
            setChanged();
        this.height = height;
        notifyObservers(this);
    }

    @Override
    public void setName(String name)
    {
        if(name == null)
            throw new NullPointerException();
        if(!name.equals(this.name))
            setChanged();
        this.name = name;
        notifyObservers(this);
    }

    @Override
    public void setPlayer(String player)
    {
        if(player == null)
            throw new NullPointerException();
        if(!player.equals(this.player))
            setChanged();
        this.player = player;
        notifyObservers(this);
    }

    @Override
    public void setSex(Sex sex)
    {
        if(sex == null)
            throw new NullPointerException();
        if(!sex.equals(this.sex))
            setChanged();
        this.sex = sex;
        notifyObservers(this);
    }

    @Override
    public void setSize(Size size)
    {
        if(size == null)
            throw new NullPointerException();
        if(!size.equals(this.size))
            setChanged();
        this.size = size;
        notifyObservers(this);
    }

    @Override
    public void setSkin(String skin)
    {
        if(skin == null)
            throw new NullPointerException();
        if(!skin.equals(this.sex))
            setChanged();
        this.skin = skin;
        notifyObservers(this);
    }

    @Override
    public void setWeight(int weight)
    {
        if(this.weight != weight)
            setChanged();
        this.weight = weight;
        notifyObservers(this);
    }

    @Override
    public void setRase(Race raceOfPlayer)
    {
        if(raceOfPlayer == null)
            throw new NullPointerException();
        if(!raceOfPlayer.equals(this.race))
            setChanged();
        this.race = raceOfPlayer;
        notifyObservers(this);
    }
    
    public void addDescriptionObserver(Observer o)
    {
        addObserver(o);
    };
}
