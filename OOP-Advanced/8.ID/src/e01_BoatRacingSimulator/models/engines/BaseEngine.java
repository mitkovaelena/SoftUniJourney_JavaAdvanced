package e01_BoatRacingSimulator.models.engines;

import e01_BoatRacingSimulator.Utility.Constants;
import e01_BoatRacingSimulator.Utility.Validator;
import e01_BoatRacingSimulator.contracts.IModelable;

public abstract class BaseEngine implements IModelable {
    private int cachedOutput;  //TODO

    private String model;

    private int horsepower;

    private int displacement;

    protected BaseEngine(String model, int horsepower, int displacement)
    {
        this.setModel(model);
        this.setHorsepower(horsepower);
        this.setDisplacement(displacement);
    }

    @Override
    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        Validator.validateModelLength(model, Constants.MIN_BOAT_ENGINE_MODEL_LENGTH);  //TODO validate if unique
        this.model = model;
    }

    public int getHorsepower() {
        return horsepower;
    }

    private void setHorsepower(int horsepower) {
        Validator.validatePropertyValue(horsepower, "Horsepower");
        this.horsepower = horsepower;
    }

    public int getDisplacement() {
        return displacement;
    }

    private void setDisplacement(int displacement) {
        Validator.validatePropertyValue(displacement, "Displacement");
        this.displacement = displacement;
    }

    protected int getCachedOutput() {
        return cachedOutput;
    }

    protected void setCachedOutput(int cachedOutput) {
        this.cachedOutput = cachedOutput;
    }

    public abstract int getOutput();

}
