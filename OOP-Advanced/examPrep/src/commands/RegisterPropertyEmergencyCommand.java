package commands;

import annotations.InjectArgs;
import core.ManagementSystem;
import enums.EmergencyLevel;
import models.emergencies.Emergency;
import models.emergencies.PropertyEmergency;
import utils.RegistrationTime;
import utils.RegistrationTimeImpl;

public class RegisterPropertyEmergencyCommand extends BaseCommand {

    @InjectArgs
    private String[] params;
    private RegistrationTime registrationTime;
    private Emergency emergency;

    public RegisterPropertyEmergencyCommand(ManagementSystem managementSystem) {
        super(managementSystem);
    }

    @Override
    public String execute() {
        String description = this.params[0];
        EmergencyLevel level = EmergencyLevel.valueOf(this.params[1].toUpperCase());
        this.registrationTime = new RegistrationTimeImpl(this.params[2]);
        Integer damage = Integer.valueOf(this.params[3]);

        this.emergency = new PropertyEmergency(description, level, this.registrationTime, damage);

        return super.getManagementSystem().registerPropertyEmergency(this.emergency);
    }
}
