package org.dndp.dndc.engine;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.dndp.dndc.engine.card.UnavailableTestException;
import org.dndp.dndc.engine.card.abilities.Abiliti;
import org.dndp.dndc.engine.card.abilities.Abilities;
import org.dndp.dndc.engine.card.abilities.DnDAbilities;
import org.dndp.dndc.engine.card.armor.Armor;
import org.dndp.dndc.engine.card.armor.DnDArmor;
import org.dndp.dndc.engine.card.attack.Attack;
import org.dndp.dndc.engine.card.attack.BaseAttack;
import org.dndp.dndc.engine.card.attack.BaseBonusToAttack;
import org.dndp.dndc.engine.card.attack.DnDAttack;
import org.dndp.dndc.engine.card.bonus.BaseBonusHandler;
import org.dndp.dndc.engine.card.bonus.BonusManager;
import org.dndp.dndc.engine.card.bonus.Bonusable;
import org.dndp.dndc.engine.card.bonus.DnDBonusManager;
import org.dndp.dndc.engine.card.classes.BaseClass;
import org.dndp.dndc.engine.card.classes.CharacterClass;
import org.dndp.dndc.engine.card.classes.CharacterClassManager;
import org.dndp.dndc.engine.card.classes.DnDCharacterClassManager;
import org.dndp.dndc.engine.card.description.Description;
import org.dndp.dndc.engine.card.description.DnDDescription;
import org.dndp.dndc.engine.card.description.God;
import org.dndp.dndc.engine.card.description.Race;
import org.dndp.dndc.engine.card.description.Sex;
import org.dndp.dndc.engine.card.description.Size;
import org.dndp.dndc.engine.card.fleats.CharacterFleat;
import org.dndp.dndc.engine.card.fleats.CharacterFleatManager;
import org.dndp.dndc.engine.card.fleats.DnDCharacterFleatManager;
import org.dndp.dndc.engine.card.fleats.Fleat;
import org.dndp.dndc.engine.card.hp.DnDHitPoints;
import org.dndp.dndc.engine.card.hp.HitPoints;
import org.dndp.dndc.engine.card.skills.CharacterSkill;
import org.dndp.dndc.engine.card.skills.DnDSkilManager;
import org.dndp.dndc.engine.card.skills.SkillManager;
import org.dndp.dndc.engine.card.st.DnDSavingThrows;
import org.dndp.dndc.engine.card.st.SavingThrow;
import org.dndp.dndc.engine.card.st.SavingThrows;
import org.dndp.dndc.engine.card.state.DnDStateManager;
import org.dndp.dndc.engine.card.state.State;
import org.dndp.dndc.engine.card.state.StateManager;
import org.dndp.dndc.engine.check.CheckFailException;
import org.dndp.dndc.engine.item.BasicEquipmentManager;
import org.dndp.dndc.engine.item.DnDEquipmentManager;
import org.dndp.dndc.engine.item.Item;


/**
 * Reprezentacja jednej postaci Wzorzec projektowy mediator + fasada
 * 
 * @author evil , bambucha
 */
public class Character implements Abilities, Attack, Armor, Description, HitPoints, SavingThrows, BonusManager, CharacterFleatManager,
        SkillManager, StateManager, BasicEquipmentManager, CharacterClassManager
{
    private Abilities             abilities;
    private Armor                 armor;
    private Description           description;
    private Attack                attack;
    private BasicEquipmentManager equipment;
    private HitPoints             HP;
    private SavingThrows          savingThrows;
    private BonusManager          bonusManager;
    private SkillManager           skilManager;
    private CharacterFleatManager characterFleatManager;
    private StateManager          stateManager;
    private CharacterClassManager classManager;

    /**
     * Konstruktor postaci<br/>
     * 
     * @param view
     *            Widok karty postaci.
     * @par TODO kolejność inicjowania poszególnych rzeczy.
     */
    public Character()
    {
        bonusManager = new DnDBonusManager(this);
        abilities = new DnDAbilities(this);
        description = new DnDDescription();
        HP = new DnDHitPoints();
        savingThrows = new DnDSavingThrows(this);
        armor = new DnDArmor(this, this, this);
        attack = new DnDAttack(this);
        equipment = new DnDEquipmentManager(this);
        skilManager = new DnDSkilManager(this, this);
        characterFleatManager = new DnDCharacterFleatManager(this);
        stateManager = new DnDStateManager(this);
        classManager = new DnDCharacterClassManager(this);
    }

    @Override
    public Abiliti getStrenght()
    {
        return abilities.getStrenght();
    }

    @Override
    public Abiliti getDexterity()
    {
        return abilities.getDexterity();
    }

    @Override
    public Abiliti getConstitution()
    {
        return abilities.getConstitution();
    }

    @Override
    public Abiliti getInteligence()
    {
        return abilities.getInteligence();
    }

    @Override
    public Abiliti getWisdom()
    {
        return abilities.getWisdom();
    }

    @Override
    public Abiliti getCharisma()
    {
        return abilities.getCharisma();
    }

    // Konice atrybutów

    @Override
    public Integer getAC()
    {
        return armor.getAC();
    }

    @Override
    public Integer getFlatFootetAC()
    {
        return armor.getFlatFootetAC();
    }

    @Override
    public Integer getTouchAttaksAC()
    {
        return armor.getTouchAttaksAC();
    }

    // Konice Pancerza

    @Override
    public String getName()
    {
        return description.getName();
    }

    @Override
    public String getPlayer()
    {
        return description.getPlayer();
    }

    @Override
    public Race getRase()
    {
        return description.getRase();
    }

    @Override
    public PersonalityTypes getPersonality()
    {
        return description.getPersonality();
    }

    @Override
    public God getGod()
    {
        return description.getGod();
    }

    @Override
    public Size getSize()
    {
        return description.getSize();
    }

    @Override
    public int getAge()
    {
        return description.getAge();
    }

    @Override
    public Sex getSex()
    {
        return description.getSex();
    }

    @Override
    public int getHeight()
    {
        return description.getHeight();
    }

    @Override
    public int getWeight()
    {
        return description.getWeight();
    }

    @Override
    public String getEye()
    {
        return description.getEye();
    }

    @Override
    public String getHair()
    {
        return description.getHair();
    }

    @Override
    public String getSkin()
    {
        return description.getSkin();
    }

    @Override
    public void setWeight(int newValeu)
    {
        description.setWeight(newValeu);
    }

    @Override
    public void setSkin(String newValeu)
    {
        description.setSkin(newValeu);
    }

    @Override
    public void setSize(Size newValeu)
    {
        description.setSize(newValeu);
    }

    @Override
    public void setSex(Sex newValeu)
    {
        description.setSex(newValeu);
    }

    @Override
    public void setRase(Race raceOfPlayer)
    {
        description.setRase(raceOfPlayer);
    }

    @Override
    public void setPlayer(String newValeu)
    {
        description.setPlayer(newValeu);
    }

    @Override
    public void setPersonality(PersonalityTypes newValeu)
    {
        description.setPersonality(newValeu);
    }

    @Override
    public void setName(String newValeu)
    {
        description.setName(newValeu);
    }

    @Override
    public void setHeight(int newValeu)
    {
        description.setHeight(newValeu);
    }

    @Override
    public void setHair(String newValeu)
    {
        description.setHair(newValeu);
    }

    @Override
    public void setGod(God newValeu)
    {
        description.setGod(newValeu);
    }

    @Override
    public void setEye(String newValeu)
    {
        description.setEye(newValeu);
    }

    @Override
    public void setAge(int newValeu)
    {
        description.setAge(newValeu);
    }

    // Koniec opisu

    @Override
    public void setSpeed(double newValue)
    {
        attack.setSpeed(newValue);
    }

    @Override
    public void setInitiativeModifier(Integer newValue)
    {
        attack.setInitiativeModifier(newValue);
    }

    @Override
    public void setBaseAttack(BaseBonusToAttack newValue)
    {
        attack.setBaseAttack(newValue);
    }

    @Override
    public double getSpeed()
    {
        return attack.getSpeed();
    }

    @Override
    public BaseAttack getRangeAttack()
    {
        return attack.getRangeAttack();
    }

    @Override
    public BaseAttack getMeleeAttack()
    {
        return attack.getMeleeAttack();
    }

    @Override
    public Integer getInitiativeModifier()
    {
        return attack.getInitiativeModifier();
    }

    @Override
    public BaseAttack getGrappleAttack()
    {
        return attack.getGrappleAttack();
    }

    @Override
    public BaseBonusToAttack getBaseAttack()
    {
        return attack.getBaseAttack();
    }

    // Koniec ataku

    @Override
    public void setMaxHP(int maxHP)
    {
        HP.setMaxHP(maxHP);
    }

    @Override
    public void setHP(int HP)
    {
        this.HP.setHP(HP);
    }

    @Override
    public int getMaxHP()
    {
        return HP.getMaxHP();
    }

    @Override
    public int getHP()
    {
        return HP.getHP();
    }

    // Koniec punktów życia

    @Override
    public void putOn(Item what)
    {
        equipment.putOn(what);
    }

    @Override
    public Integer getCurrentArmorPently()
    {
        return equipment.getCurrentArmorPently();
    }

    @Override
    public Integer getMaximumDexterityACBonus()
    {
        return equipment.getMaximumDexterityACBonus();
    }

    // Koniec ekwipunku

    public void store(Item what)
    {
        equipment.store(what);
    }

    @Override
    public void setSpellResistance(double newValue)
    {
        savingThrows.setSpellResistance(newValue);
    }

    @Override
    public SavingThrow getWill()
    {
        return savingThrows.getWill();
    }

    @Override
    public double getSpellResistance()
    {
        return savingThrows.getSpellResistance();
    }

    @Override
    public SavingThrow getReflex()
    {
        return savingThrows.getReflex();
    }

    @Override
    public SavingThrow getForttiude()
    {
        return savingThrows.getForttiude();
    }

    // Konice rzutów obronnych

    @Override
    public void registerBonus(String name, Bonusable newBonus)
    {
        bonusManager.registerBonus(name, newBonus);
    }

    @Override
    public BaseBonusHandler getBonusHandler(String name)
    {
        return bonusManager.getBonusHandler(name);
    }

    // Koniec menadżera bonusów.

    @Override
    public CharacterFleat getCharacterFleat(Fleat key)
    {
        return characterFleatManager.getCharacterFleat(key);
    }

    @Override
    public Collection<CharacterFleat> getAllCharacterFleats()
    {
        return characterFleatManager.getAllCharacterFleats();
    }

    // Koniec delegacji menadżera atutów.

    @Override
    public void setState(State state)
    {
        stateManager.setState(state);
    }

    @Override
    public void removeState(State state)
    {
        stateManager.removeState(state);
    }

    // Koniec stanów postaci

    public Integer testSkil(String name) throws UnavailableTestException
    {
        return skilManager.testSkil(name);
    }

    public CharacterSkill getSkil(String name)
    {
        return skilManager.getSkil(name);
    }

    
    public Set<String> getSkilNameSet()
    {
        return skilManager.getSkilNameSet();
    }

    //Koniec umiejętności

    @Override
    public Integer getLevel()
    {
        return classManager.getLevel();
    }

    @Override
    public boolean isMultiClassCharacter()
    {
        return classManager.isMultiClassCharacter();
    }

    @Override
    public Integer getExperiancePoint()
    {
        return classManager.getExperiancePoint();
    }

    @Override
    public void setExperiancePoint(Integer experiancePoint)
    {
        classManager.setExperiancePoint(experiancePoint);
    }

    @Override
    public boolean isPromoted()
    {
        return classManager.isPromoted();
    }

    @Override
    public void promote(BaseClass classes) throws CheckFailException
    {
        classManager.promote(classes);
    }

    @Override
    public Integer getClassLevel(BaseClass classes)
    {
        return classManager.getClassLevel(classes);
    }

    @Override
    public List<CharacterClass> getClassList()
    {
        return classManager.getClassList();
    }
    
}
