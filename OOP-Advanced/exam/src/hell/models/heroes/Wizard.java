package hell.models.heroes;

public class Wizard extends BaseHero {
    private static long BASE_STRENGTH = 25L;
    private static long BASE_AGILITY = 25L;
    private static long BASE_INTELIGENCE = 100L;
    private static long BASE_HIT_POINTS = 100L;
    private static long BASE_DAMAGE = 250L;

    public Wizard(String name) {
        super(name, BASE_STRENGTH, BASE_AGILITY, BASE_INTELIGENCE, BASE_HIT_POINTS, BASE_DAMAGE);
    }
}
