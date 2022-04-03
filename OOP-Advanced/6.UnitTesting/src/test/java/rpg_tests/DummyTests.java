package rpg_tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import rpg.*;

import java.util.Arrays;

public class DummyTests {

    private static final int ATTACK_POINTS = 10;
    private static final int HEALTH = 100;
    private static final int XP = 100;
    private static final int INDEX = 0;
    private static final Weapon[] WEAPONS = new Weapon[] {
            new Axe(10, 10),
            new Axe(20, 20),
            new Axe(30, 30),
    };

    private Target target;

    @Before
    public void initializeTestObjects() {
        this.target = new Dummy(HEALTH, XP, Arrays.asList(WEAPONS));
    }

    @Test
    public void attackedTargetLoosesHealth() {
        this.target.takeAttack(ATTACK_POINTS);
        Assert.assertEquals("Wrong health", HEALTH - ATTACK_POINTS, this.target.getHealth());
    }

    @Test(expected = IllegalStateException.class)
    public void attackDeadTargetThrowsException() {
        while (target.getHealth() >= 0) {
            this.target.takeAttack(ATTACK_POINTS);
        }
    }

    @Test
    public void deadTargetGivesExp() {
        while (!this.target.isDead()) {
            this.target.takeAttack(ATTACK_POINTS);
        }

        Assert.assertEquals("Wrong experience", XP, this.target.giveExperience());
    }

    @Test(expected = IllegalStateException.class)
    public void aliveTargetCantGiveExp() {
        this.target.giveExperience();
    }

    @Test
    public void targetDropsRandomLoot() {
        RandomProvider rndMock = Mockito.mock(RandomProvider.class);
        Mockito.when(rndMock.next(WEAPONS.length)).thenReturn(INDEX);

        Weapon loot = target.dropLoot(rndMock);

        Assert.assertNotNull("Dropped loot was null", loot);
        Assert.assertSame("Wrong loot", WEAPONS[INDEX], loot);
    }
}
