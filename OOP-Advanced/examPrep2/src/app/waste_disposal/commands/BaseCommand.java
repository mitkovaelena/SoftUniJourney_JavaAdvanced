package app.waste_disposal.commands;


import app.waste_disposal.core.ManagingSystem;

public abstract class BaseCommand implements Executable {

    private ManagingSystem managingSystem;

    protected BaseCommand(ManagingSystem managingSystem) {
        this.managingSystem = managingSystem;
    }

    protected ManagingSystem getManagingSystem() {
        return this.managingSystem;
    }
}
