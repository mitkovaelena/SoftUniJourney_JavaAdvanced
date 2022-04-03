package hell.core;

import hell.interfaces.Hero;
import hell.interfaces.Item;
import hell.interfaces.Recipe;
import hell.models.items.CommonItem;
import hell.models.items.RecipeItem;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedHashMap;
import java.util.Map;

public class ManagingSystemImpl implements ManagingSystem {
    private static final String HEROES_PACKAGE = "hell.models.heroes.";

    private Map<String, Hero> heroes;

    public ManagingSystemImpl() {
        this.heroes = new LinkedHashMap<>();
    }

    @Override
    public String createHero(String name, String type) throws NoSuchMethodException, ClassNotFoundException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<Hero> heroClass = (Class<Hero>) Class.forName(HEROES_PACKAGE + type);
        Constructor<Hero> constructor = heroClass.getDeclaredConstructor(String.class);
        Hero hero = constructor.newInstance(name);
        this.heroes.put(name, hero);
        return String.format("Created %s - %s", type, name);
    }

    @Override
    public String createItem(String name, String heroName, int strengthBonus, int agilityBonus, int intelligenceBonus, int hitpointsBonus, int damageBonus) {
        Item item = new CommonItem(name, strengthBonus, agilityBonus, intelligenceBonus, hitpointsBonus, damageBonus);
        heroes.get(heroName).addItem(item);
        return String.format("Added item - %s to Hero - %s", name, heroName);
    }

    @Override
    public String createRecipe(String name, String heroName, int strengthBonus, int agilityBonus, int intelligenceBonus, int hitpointsBonus, int damageBonus, String[] requiredItems) {
        Recipe item = new RecipeItem(name, strengthBonus, agilityBonus, intelligenceBonus, hitpointsBonus, damageBonus, requiredItems);
        heroes.get(heroName).addRecipe(item);
        return String.format("Added recipe - %s to Hero - %s", name, heroName);
    }

    @Override
    public String inspect(String name) throws NoSuchFieldException, IllegalAccessException {
        Hero hero = this.heroes.get(name);
        StringBuilder output = new StringBuilder(String.format("Hero: %s, Class: %s\n" +
                        "HitPoints: %d, Damage: %d\n" +
                        "Strength: %d\n" +
                        "Agility: %d\n" +
                        "Intelligence: %d\n" +
                        "Items:",
                name, hero.getClass().getSimpleName(),
                hero.getHitPoints(), hero.getDamage(),
                hero.getStrength(), hero.getAgility(), hero.getIntelligence()));

        if (hero.getItems().size() > 0) {
            for (Item item : hero.getItems()) {
                output.append("\n###Item: ").append(item.getName());
                output.append("\n###+").append(item.getStrengthBonus()).append(" Strength");
                output.append("\n###+").append(item.getAgilityBonus()).append(" Agility");
                output.append("\n###+").append(item.getIntelligenceBonus()).append(" Intelligence");
                output.append("\n###+").append(item.getHitPointsBonus()).append(" HitPoints");
                output.append("\n###+").append(item.getDamageBonus()).append(" Damage");
            }

        } else {
            output.append(" None");
        }

        return output.toString();
    }

    @Override
    public String report() throws NoSuchFieldException, IllegalAccessException {
        Map<String, Hero> heroesSorted = new LinkedHashMap<String, Hero>();
        heroes.entrySet().stream()
                .sorted((h1, h2) -> {
                    long resultH1 = (h1.getValue().getStrength() + h1.getValue().getAgility() + h1.getValue().getIntelligence());
                    long resultH2 = (h2.getValue().getStrength() + h2.getValue().getAgility() + h2.getValue().getIntelligence());

                    if (Long.compare(resultH2, resultH1) == 0) {

                        long resultH11 = h1.getValue().getHitPoints() + h1.getValue().getDamage();
                        long resultH22 = h2.getValue().getHitPoints() + h2.getValue().getDamage();
                        return Long.compare(resultH22, resultH11);
                    } else {
                        return Long.compare(resultH2, resultH1);
                    }
                })
                .forEachOrdered(x -> heroesSorted.put(x.getKey(), x.getValue()));

        StringBuilder output = new StringBuilder();

        int i = 0;
        for (Hero hero : heroesSorted.values()) {
            i++;
            output.append(String.format("%d. %s: %s\n" +
                    "###HitPoints: %d\n" +
                    "###Damage: %d\n" +
                    "###Strength: %d\n" +
                    "###Agility: %d\n" +
                    "###Intelligence: %d\n" +
                    "###Items:",
                    i, hero.getClass().getSimpleName(), hero.getName(),
                    hero.getHitPoints(), hero.getDamage(),
                    hero.getStrength(), hero.getAgility(),
                    hero.getIntelligence()));

            if (hero.getItems().size() > 0) {
                for (Item item : hero.getItems()) {
                    output.append(" ").append(item.getName()).append(",");
                }
                output.setLength(output.length()-1);
                output.append("\n");

            } else {
                output.append(" None");
            }
        }

        return output.toString().trim();
    }
}
