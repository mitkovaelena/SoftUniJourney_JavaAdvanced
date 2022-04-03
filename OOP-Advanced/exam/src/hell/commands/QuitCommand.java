package hell.commands;

import hell.core.ManagingSystem;

public class QuitCommand extends BaseCommand {

    public QuitCommand(ManagingSystem managingSystem) {
        super(managingSystem);
    }

    @Override
    public String execute() throws NoSuchFieldException, IllegalAccessException {
        return super.getManagingSystem().report();
    }
}
