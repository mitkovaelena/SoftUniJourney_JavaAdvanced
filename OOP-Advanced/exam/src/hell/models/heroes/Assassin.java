package hell.models.heroes;

public class Assassin extends BaseHero {
    private static long BASE_STRENGTH = 25L;
    private static long BASE_AGILITY = 100L;
    private static long BASE_INTELIGENCE = 15L;
    private static long BASE_HIT_POINTS = 150L;
    private static long BASE_DAMAGE = 300L;

    public Assassin(String name) {
        super(name, BASE_STRENGTH, BASE_AGILITY, BASE_INTELIGENCE, BASE_HIT_POINTS, BASE_DAMAGE);
    }
}
