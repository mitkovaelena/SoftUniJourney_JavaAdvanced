package hell.commands;


import hell.core.ManagingSystem;

public abstract class BaseCommand implements Executable {

    private ManagingSystem managingSystem;

    protected BaseCommand(ManagingSystem managingSystem) {
        this.managingSystem = managingSystem;
    }

    protected ManagingSystem getManagingSystem() {
        return this.managingSystem;
    }
}
