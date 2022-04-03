package models.emergencies;

import enums.EmergencyLevel;
import enums.Status;
import utils.RegistrationTime;

public class OrderEmergency extends BaseEmergency {
    private Status status;

    public OrderEmergency(String description, EmergencyLevel emergencyLevel, RegistrationTime registrationTime, Status status) {
        super(description, emergencyLevel, registrationTime);
        this.setStatus(status);
    }

    public Status getStatus() {
        return status;
    }

    private void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public int getResultAfterProcessing() {
        if(this.getStatus().equals(Status.SPECIAL)){
            return 1;
        }
        return 0;
    }
}
