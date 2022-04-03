package hell.core;

import java.lang.reflect.InvocationTargetException;

public interface ManagingSystem {

    String createHero(String name, String type) throws NoSuchMethodException, ClassNotFoundException, IllegalAccessException, InvocationTargetException, InstantiationException;

    String createItem(String name, String heroName, int strengthBonus, int agilityBonus, int intelligenceBonus, int hitpointsBonus, int damageBonus);

    String createRecipe(String name, String heroName, int strengthBonus, int agilityBonus, int intelligenceBonus, int hitpointsBonus, int damageBonus, String[] requiredItems);

    String inspect(String name) throws NoSuchFieldException, IllegalAccessException;

    String report() throws NoSuchFieldException, IllegalAccessException;
}
