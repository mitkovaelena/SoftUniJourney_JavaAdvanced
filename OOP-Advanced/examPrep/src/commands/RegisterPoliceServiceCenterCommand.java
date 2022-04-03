package commands;

import annotations.InjectArgs;
import core.ManagementSystem;
import models.centers.EmergencyCenter;
import models.centers.PoliceServiceCenter;

public class RegisterPoliceServiceCenterCommand extends BaseCommand {

    @InjectArgs
    private String[] params;
    private EmergencyCenter center;

    public RegisterPoliceServiceCenterCommand(ManagementSystem managementSystem) {
        super(managementSystem);
    }

    @Override
    public String execute() {
        String name = this.params[0];
        Integer amountOfEmergencies = Integer.valueOf(this.params[1]);

        this.center = new PoliceServiceCenter(name, amountOfEmergencies);

        return super.getManagementSystem().registerPoliceServiceCenter(this.center);
    }
}
