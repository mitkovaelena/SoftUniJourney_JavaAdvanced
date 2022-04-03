package hell.models.heroes;

import hell.entities.miscellaneous.HeroInventory;
import hell.entities.miscellaneous.ItemCollection;
import hell.interfaces.Hero;
import hell.interfaces.Inventory;
import hell.interfaces.Item;
import hell.interfaces.Recipe;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public abstract class BaseHero implements Hero {
    private String name;
    private long strength;
    private long agility;
    private long intelligence;
    private long hitPoints;
    private long damage;
    private Inventory inventory;

    public BaseHero(String name, long strength, long agility, long intelligence, long hitPoints, long damage) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
        this.hitPoints = hitPoints;
        this.damage = damage;
        this.inventory = new HeroInventory();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public long getStrength() {
        return strength+this.inventory.getTotalStrengthBonus();
    }

    @Override
    public long getAgility() {
        return agility+this.inventory.getTotalAgilityBonus();
    }

    @Override
    public long getIntelligence() {
        return intelligence+this.inventory.getTotalIntelligenceBonus();
    }

    @Override
    public long getHitPoints() {
        return hitPoints+this.inventory.getTotalHitPointsBonus();
    }

    @Override
    public long getDamage() {
        return damage+this.inventory.getTotalDamageBonus();
    }

    @Override
    public Collection<Item> getItems() throws NoSuchFieldException, IllegalAccessException {
        Map<String, Item> items = null;

        Class inventoryClass = this.inventory.getClass();
        Field[] fields = inventoryClass.getDeclaredFields();

        for(Field field : fields) {
            if(field.isAnnotationPresent(ItemCollection.class)) {
                field.setAccessible(true);
                items = (LinkedHashMap<String, Item>) field.get(this.inventory);
            }
        }

        return Collections.unmodifiableCollection(items.values());
    }

    @Override
    public void addItem(Item item) {
        this.inventory.addCommonItem(item);
    }

    @Override
    public void addRecipe(Recipe recipe) {
        this.inventory.addRecipeItem(recipe);
    }
}
