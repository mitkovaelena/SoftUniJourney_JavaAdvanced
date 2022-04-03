package rpg_tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import rpg.Axe;
import rpg.Target;
import rpg.Weapon;

public class AxeTests {

    private static final int AXE_DURABILITY = 10;
    private static final int AXE_ATTACK = 10;

    private Weapon weapon;
    private Target target;

    @Before
    public void initializeTestObjects() {
        this.weapon = new Axe(AXE_ATTACK, AXE_DURABILITY);
        this.target = Mockito.mock(Target.class);
    }

    @Test
    public void weaponLosesDurabilityOnAttack() {
        this.weapon.attack(this.target);

        Assert.assertEquals("Wrong durability",
                AXE_DURABILITY - 1,
                this.weapon.getDurabilityPoints());
    }

    @Test(expected = IllegalStateException.class)
    public void brokenWeaponCannotAttack() {
        for (int hitCount = 0; hitCount < AXE_DURABILITY + 1; hitCount++) {
            weapon.attack(this.target);
        }
    }
}
