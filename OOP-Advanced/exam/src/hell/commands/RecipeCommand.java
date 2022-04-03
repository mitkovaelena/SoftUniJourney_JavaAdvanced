package hell.commands;

import hell.annotations.InjectArgs;
import hell.core.ManagingSystem;

import java.lang.reflect.InvocationTargetException;

public class RecipeCommand extends BaseCommand {

    @InjectArgs
    private String[] params;

    public RecipeCommand(ManagingSystem managingSystem) {
        super(managingSystem);
    }

    @Override
    public String execute() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        String name = this.params[0];
        String heroName = this.params[1];
        int strengthBonus = Integer.parseInt(this.params[2]);
        int agilityBonus = Integer.parseInt(this.params[3]);
        int intelligenceBonus = Integer.parseInt(this.params[4]);
        int hitpointsBonus = Integer.parseInt(this.params[5]);
        int damageBonus = Integer.parseInt(this.params[6]);

        String[] requiredItems = new String[this.params.length-7];

        if (this.params.length > 7) {
            System.arraycopy(this.params, 7, requiredItems, 0, requiredItems.length);
        }

        return super.getManagingSystem().createRecipe(name, heroName, strengthBonus, agilityBonus, intelligenceBonus, hitpointsBonus, damageBonus, requiredItems);
    }
}
