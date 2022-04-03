package app.waste_disposal.commands;

import app.waste_disposal.annotations.InjectArgs;
import app.waste_disposal.core.ManagingSystem;

import java.lang.reflect.InvocationTargetException;

public class ChangeManagementRequirementCommand extends BaseCommand{

    @InjectArgs
    private String[] params;

    public ChangeManagementRequirementCommand(ManagingSystem managingSystem) {
        super(managingSystem);
    }

    @Override
    public String execute() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        double energyBalance = Double.parseDouble(this.params[0]);
        double capitalBalance = Double.parseDouble(this.params[1]);
        String garbageType = this.params[2];

        return this.getManagingSystem().changeManagementRequirement(energyBalance,capitalBalance,garbageType);
    }
}
