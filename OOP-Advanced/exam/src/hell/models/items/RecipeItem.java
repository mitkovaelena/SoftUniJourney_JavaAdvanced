package hell.models.items;

import hell.interfaces.Recipe;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class RecipeItem extends BaseItem implements Recipe {
    private List<String> requiredItems;

    public RecipeItem(String name, int strengthBonus, int agilityBonus, int intelligenceBonus, int hitPointsBonus, int damageBonus, String[] requiredItems) {
        super(name, strengthBonus, agilityBonus, intelligenceBonus, hitPointsBonus, damageBonus);
        this.requiredItems = new LinkedList<>();
        Collections.addAll(this.requiredItems, requiredItems);
    }

    @Override
    public List<String> getRequiredItems() {
        return Collections.unmodifiableList(this.requiredItems);
    }
}
