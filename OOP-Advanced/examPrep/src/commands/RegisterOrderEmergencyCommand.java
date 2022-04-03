package commands;

import annotations.InjectArgs;
import core.ManagementSystem;
import enums.EmergencyLevel;
import enums.Status;
import models.emergencies.Emergency;
import models.emergencies.OrderEmergency;
import utils.RegistrationTime;
import utils.RegistrationTimeImpl;

public class RegisterOrderEmergencyCommand extends BaseCommand {

    @InjectArgs
    private String[] params;
    private RegistrationTime registrationTime;
    private Emergency emergency;


    public RegisterOrderEmergencyCommand(ManagementSystem managementSystem) {
        super(managementSystem);
    }

    @Override
    public String execute() {
        String description = this.params[0];
        EmergencyLevel level = EmergencyLevel.valueOf(this.params[1].toUpperCase());
        this.registrationTime = new RegistrationTimeImpl(this.params[2]);
        Status status = Status.valueOf(this.params[3].replace("-", "_").toUpperCase());

        this.emergency = new OrderEmergency(description, level, this.registrationTime, status);

        return super.getManagementSystem().registerOrderEmergency(this.emergency);
    }
}
