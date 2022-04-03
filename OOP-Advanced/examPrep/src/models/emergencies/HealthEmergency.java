package models.emergencies;

import enums.EmergencyLevel;
import utils.RegistrationTime;

public class HealthEmergency extends BaseEmergency {
    private int numberOfCasulties;

    public HealthEmergency(String description, EmergencyLevel emergencyLevel, RegistrationTime registrationTime, int numberOfCasulties) {
        super(description, emergencyLevel, registrationTime);
        this.setNumberOfCasulties(numberOfCasulties);
    }

    public int getNumberOfCasulties() {
        return numberOfCasulties;
    }

    private void setNumberOfCasulties(int numberOfCasulties) {
        this.numberOfCasulties = numberOfCasulties;
    }

    @Override
    public int getResultAfterProcessing() {
        return this.getNumberOfCasulties();
    }
}
