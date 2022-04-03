package e01_BoatRacingSimulator.models.boats;

import e01_BoatRacingSimulator.Utility.Constants;
import e01_BoatRacingSimulator.Utility.Validator;
import e01_BoatRacingSimulator.contracts.IBoat;
import e01_BoatRacingSimulator.contracts.IRace;

public abstract class BaseBoat implements IBoat {
    private String model;
    private int weight;
    private boolean isMotorBoat;

    protected BaseBoat(String model, int weight, boolean isMotorBoat) {
        this.setModel(model);
        this.setWeight(weight);
        this.isMotorBoat = isMotorBoat;
    }

    @Override
    public String getModel() {
        return model;
    }

    public int getWeight() {
        return weight;
    }

    private void setModel(String model) {
        Validator.validateModelLength(model, Constants.MIN_BOAT_MODEL_LENGTH);
        this.model = model;
    }

    private void setWeight(int weight) {
        Validator.validatePropertyValue(weight, "Weight");
        this.weight = weight;
    }

    @Override
    public boolean isMotorBoat() {
        return isMotorBoat;
    }

    public abstract double calculateRaceSpeed(IRace race);
}
