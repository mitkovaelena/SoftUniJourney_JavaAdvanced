package app.waste_disposal.commands;

import app.waste_disposal.core.ManagingSystem;

public class StatusCommand extends BaseCommand {

    public StatusCommand(ManagingSystem managingSystem) {
        super(managingSystem);
    }

    @Override
    public String execute() {
        return super.getManagingSystem().getStatus();
    }
}
