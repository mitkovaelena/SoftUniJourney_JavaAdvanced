package rpg_tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import rpg.Hero;
import rpg.RandomProvider;
import rpg.Target;
import rpg.Weapon;

public class HeroTests {

    private static final String NAME = "Gosho";
    private static final int XP = 10;

    private Weapon weaponMock;
    private Target targetMock;
    private RandomProvider rndMock;
    private Hero hero;

    @Before
    public void initTestObjects() {
        this.weaponMock = Mockito.mock(Weapon.class);
        this.targetMock = Mockito.mock(Target.class);
        this.rndMock = Mockito.mock(RandomProvider.class);
        this.hero = new Hero(NAME, this.weaponMock);
    }

    @Test
    public void attackGainsExperienceIfTargetIsDead() {
        // arrange
        Mockito.when(this.targetMock.isDead()).thenReturn(true);
        Mockito.when(this.targetMock.giveExperience()).thenReturn(XP);

        // act
        hero.attack(this.targetMock, this.rndMock);

        // assert
        Assert.assertEquals("Wrong experience", XP, hero.getExperience());
    }

    @Test
    public void attackGrantsLootIfTargetIsDead() {
        // arrange
        Mockito.when(this.targetMock.isDead()).thenReturn(true);
        Mockito.when(this.targetMock.dropLoot(this.rndMock)).thenReturn(this.weaponMock);

        // act
        hero.attack(this.targetMock, this.rndMock);

        // assert
        for (Weapon weapon : this.hero.getInventory()) {
            Assert.assertSame("Wrong loot", this.weaponMock, weapon);
        }
    }
}
