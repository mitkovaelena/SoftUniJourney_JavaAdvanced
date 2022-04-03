package hell.models.heroes;

public class Barbarian extends BaseHero {
    private static long BASE_STRENGTH = 90L;
    private static long BASE_AGILITY = 25L;
    private static long BASE_INTELIGENCE = 10L;
    private static long BASE_HIT_POINTS = 350L;
    private static long BASE_DAMAGE = 150L;

    public Barbarian(String name) {
        super(name, BASE_STRENGTH, BASE_AGILITY, BASE_INTELIGENCE, BASE_HIT_POINTS, BASE_DAMAGE);
    }


}
