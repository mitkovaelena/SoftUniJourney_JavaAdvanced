package commands;

import annotations.InjectArgs;
import core.ManagementSystem;
import models.centers.EmergencyCenter;
import models.centers.FiremanServiceCenter;

public class RegisterFireServiceCenterCommand extends BaseCommand {

    @InjectArgs
    private String[] params;
    private EmergencyCenter center;

    public RegisterFireServiceCenterCommand(ManagementSystem managementSystem) {
        super(managementSystem);
    }

    @Override
    public String execute() {
        String name = this.params[0];
        Integer amountOfEmergencies = Integer.valueOf(this.params[1]);

        this.center = new FiremanServiceCenter(name, amountOfEmergencies);

        return super.getManagementSystem().registerFireServiceCenter(this.center);
    }
}
