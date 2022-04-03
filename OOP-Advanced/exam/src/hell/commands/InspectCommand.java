package hell.commands;

import hell.annotations.InjectArgs;
import hell.core.ManagingSystem;

public class InspectCommand extends BaseCommand {

    @InjectArgs
    private String[] params;

    public InspectCommand(ManagingSystem managingSystem) {
        super(managingSystem);
    }

    @Override
    public String execute() throws NoSuchFieldException, IllegalAccessException {
        String name = this.params[0];
        return super.getManagingSystem().inspect(name);
    }
}
