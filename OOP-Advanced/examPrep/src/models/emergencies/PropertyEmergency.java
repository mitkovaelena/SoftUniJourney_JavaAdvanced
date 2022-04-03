package models.emergencies;

import enums.EmergencyLevel;
import utils.RegistrationTime;

public class PropertyEmergency extends BaseEmergency {
    private int damage;

    public PropertyEmergency(String description, EmergencyLevel emergencyLevel, RegistrationTime registrationTime, int damage) {
        super(description, emergencyLevel, registrationTime);
        this.setDamage(damage);
    }

    public int getDamage() {
        return damage;
    }

    private void setDamage(int damage) {
        this.damage = damage;
    }

    @Override
    public int getResultAfterProcessing() {
        return this.getDamage();
    }
}
