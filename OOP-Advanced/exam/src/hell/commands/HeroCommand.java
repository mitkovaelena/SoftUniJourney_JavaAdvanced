package hell.commands;

import hell.annotations.InjectArgs;
import hell.core.ManagingSystem;

import java.lang.reflect.InvocationTargetException;

public class HeroCommand extends BaseCommand {

    @InjectArgs
    private String[] params;

    public HeroCommand(ManagingSystem managingSystem) {
        super(managingSystem);
    }

    @Override
    public String execute() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        String name = this.params[0];
        String type = this.params[1];

        return super.getManagingSystem().createHero(name, type);
    }
}
