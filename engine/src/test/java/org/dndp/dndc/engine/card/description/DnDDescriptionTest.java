package org.dndp.dndc.engine.card.description;

import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Matchers.eq;
import static org.mockito.Matchers.notNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

import java.util.Observer;

import org.dndp.dndc.engine.PersonalityTypes;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 * @author bambucha
 */
public class DnDDescriptionTest
{
	DnDDescription	description;

	@Before
	public void setUpClass() throws Exception
	{
		description = new DnDDescription();
	}

	private Observer getObserver()
	{
		Observer obs = mock(Observer.class);
		description.addDescriptionObserver(obs);
		return obs;
	}

	@Test
	public void testGetName()
	{
		assertThat(description.getName()).isNotNull().isEmpty();
	}

	@Test
	public void testGetPlayer()
	{
		assertThat(description.getPlayer()).isNotNull().isEmpty();
	}

	@Test
	public void testGetRase()
	{
		assertThat(description.getRase()).isNotNull();
	}

	@Test
	public void testGetPersonality()
	{
		assertThat(description.getPersonality()).isNotNull();
	}

	@Test
	public void testGetGod()
	{
		assertThat(description.getGod()).isNotNull();
	}

	@Test
	public void testGetSize()
	{
		assertThat(description.getSize()).isNotNull().isEqualTo(Size.MEDIUM);
	}

	@Test
	public void testGetAge()
	{
		assertThat(description.getAge()).isNotNull().isZero();
	}

	@Test
	public void testGetSex()
	{
		assertThat(description.getSex()).isNotNull().isEqualTo(Sex.MALE);
	}

	@Test
	public void testGetHeight()
	{
		assertThat(description.getHeight()).isEqualTo(170);
	}

	@Test
	public void testGetWeight()
	{
		assertThat(description.getWeight()).isEqualTo(100);
	}

	@Test
	public void testGetEye()
	{
		assertThat(description.getEye()).isNotNull();
	}

	@Test
	public void testGetHair()
	{
		assertThat(description.getEye()).isNotNull();
	}

	@Test
	public void testGetSkin()
	{
		assertThat(description.getSkin()).isNotNull();
	}

	@Test
	public void testSetAge()
	{
		description.setAge(13);
		assertThat(description.getAge()).isEqualTo(13);
	}

	@Test
	public void sameValeLikeBeforeForAge() throws Exception
	{
		// given
		description.setAge(15);
		Observer tester = getObserver();
		// when
		description.setAge(15);
		// then
		verify(tester, never()).update(eq(description), notNull());
	}

	@Test
	public void testSetPersonality()
	{
		description.setPersonality(PersonalityTypes.CD);
		assertThat(description.getPersonality()).isEqualTo(PersonalityTypes.CD);
	}

	@Test(expected = NullPointerException.class)
	public void testSetPersonalityNullException()
	{
		description.setPersonality(null);
	}

	@Test
	public void testSetEye()
	{
		description.setEye("oko");
		assertThat(description.getEye()).isEqualTo("oko");
	}

	@Test(expected = NullPointerException.class)
	public void testSetEyeNull()
	{
		description.setEye(null);
	}

	@Test
	public void secondSetingDidntMakeNotificationForEye() throws Exception
	{
		// given
		description.setEye("oko");
		Observer tester = getObserver();
		// when
		description.setEye("oko");
		// then
		verify(tester, never()).update(eq(description), notNull());
	}

	@Test
	public void testSetGod()
	{
		God tester = new God();
		description.setGod(tester);
		assertThat(description.getGod()).isEqualTo(tester);
	}

	@Test(expected = NullPointerException.class)
	public void testSetGodNull()
	{
		description.setGod(null);
	}

	@Test
	public void dontMakeNotifiWhenSecondTimeGodAreSame() throws Exception
	{
		God temp = new God();
		// given
		description.setGod(temp);
		Observer tester = getObserver();
		// when
		description.setGod(temp);
		// then
		verify(tester, never()).update(eq(description), notNull());
	}

	@Test
	public void testSetHair()
	{
		String hair = "rude";
		description.setHair(hair);
		assertThat(description.getHair()).isEqualTo(hair);
	}

	@Test(expected = NullPointerException.class)
	public void testSetHairNull()
	{
		description.setHair(null);
	}

	@Test
	public void secondSetHairDontMakeNotification() throws Exception
	{
		// given
		description.setHair("test");
		Observer test = getObserver();
		// when
		description.setHair("test");
		// then
		verify(test, never()).update(eq(description), notNull());
	}

	@Test
	public void testSetHeight()
	{
		int height = 999;
		description.setHeight(height);
		assertThat(description.getHeight()).isEqualTo(height);
	}

	@Test
	public void secondSetHeightDontMakeNotification() throws Exception
	{
		// given
		description.setHeight(999);
		Observer test = getObserver();
		// when
		description.setHeight(999);
		// then
		verify(test, never()).update(eq(description), notNull());
	}

	@Test
	public void testSetName()
	{
		String name = "dupad12";
		description.setName(name);
		assertThat(description.getName()).isEqualTo(name);
	}

	@Test
	public void secondSetNameDontMakeNotification() throws Exception
	{
		// given
		description.setName("name");
		Observer test = getObserver();
		// when
		description.setName("name");
		// then
		verify(test, never()).update(eq(description), notNull());
	}

	@Test(expected = NullPointerException.class)
	public void testSetNameNull()
	{
		description.setName(null);
	}

	@Test
	public void testSetPlayer()
	{
		String player = "czarnuch";
		description.setPlayer(player);
		assertThat(description.getPlayer()).isEqualTo(player);
	}

	@Test
	public void secondSetPlayerDontMakeNotification() throws Exception
	{
		// given
		description.setPlayer("test");
		Observer test = getObserver();
		// when
		description.setPlayer("test");
		// then
		verify(test, never()).update(eq(description), notNull());
	}

	@Test(expected = NullPointerException.class)
	public void testSetPlayerNull()
	{
		description.setPlayer(null);
	}

	@Test
	public void testSetSex()
	{
		Sex sex = Sex.FEMALE;
		description.setSex(sex);
		assertThat(description.getSex()).isEqualTo(sex);

	}

	@Test(expected = NullPointerException.class)
	public void testSetSexNull()
	{
		description.setSex(null);
	}

	@Test
	public void secondSetSexDontMakeNotification() throws Exception
	{
		// given
		description.setSex(Sex.FEMALE);
		Observer test = getObserver();
		// when
		description.setSex(Sex.FEMALE);
		// then
		verify(test, never()).update(eq(description), notNull());
	}

	@Test
	public void testSetSize()
	{
		Size size = Size.LARGE;
		description.setSize(size);
		assertThat(description.getSize()).isEqualTo(size);
	}

	@Test(expected = NullPointerException.class)
	public void testSetSizeNull()
	{
		description.setSize(null);
	}

	@Test
	public void secondSetSizeDontMakeNotification() throws Exception
	{
		// given
		description.setSize(Size.LARGE);
		Observer test = getObserver();
		// when
		description.setSize(Size.LARGE);
		// then
		verify(test, never()).update(eq(description), notNull());
	}

	@Test
	public void testSetSkin()
	{
		String skin = "black";
		description.setSkin(skin);
		assertThat(description.getSkin()).isEqualTo(skin);
	}

	@Test(expected = NullPointerException.class)
	public void testSetSkinNull()
	{
		description.setSkin(null);
	}

	@Test
	public void secondSetSkinDontMakeNotification() throws Exception
	{
		String skin = "black";
		// given
		description.setSkin(skin);
		Observer test = getObserver();
		// when
		description.setSkin(skin);
		// then
		verify(test, never()).update(eq(description), notNull());
	}

	@Test
	public void testSetWeight()
	{
		int weight = 3;
		description.setWeight(weight);
		assertThat(description.getWeight()).isEqualTo(weight);
	}

	@Test
	public void secondSetWeightDontMakeNotification() throws Exception
	{
		int weight = 3;
		// given
		description.setWeight(weight);
		Observer test = getObserver();
		// when
		description.setWeight(weight);
		// then
		verify(test, never()).update(eq(description), notNull());
	}

	@Test
	public void testSetRace()
	{
		Race raceOfPlayer = new Race();
		description.setRase(raceOfPlayer);
		assertThat(description.getRase()).isEqualTo(raceOfPlayer);
	}

	@Test(expected = NullPointerException.class)
	public void testSetRaseNull()
	{
		description.setRase(null);
	}

	@Test
	public void secondSetRaceDontMakeNotification() throws Exception
	{
		Race raceOfPlayer = new Race();
		description.setRase(raceOfPlayer);
		Observer test = getObserver();
		// when
		description.setRase(raceOfPlayer);
		// then
		verify(test, never()).update(eq(description), notNull());
	}
}
