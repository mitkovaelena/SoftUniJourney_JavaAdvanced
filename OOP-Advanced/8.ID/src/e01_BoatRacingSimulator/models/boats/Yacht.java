package e01_BoatRacingSimulator.models.boats;

import e01_BoatRacingSimulator.Utility.Validator;
import e01_BoatRacingSimulator.contracts.IRace;
import e01_BoatRacingSimulator.models.engines.BaseEngine;

public class Yacht extends BaseBoat{
    private BaseEngine engine;
    private int cargoWeight;

    public Yacht(String model, int weight, BaseEngine engine, int cargoWeight) {
        super(model, weight, true);
        this.engine = engine;
        this.setCargoWeight(cargoWeight);
    }

    @Override
    public String getModel() {
        return super.getModel();
    }

    private void setCargoWeight(int cargoWeight) {
        Validator.validatePropertyValue(cargoWeight, "Cargo Weight");
        this.cargoWeight = cargoWeight;
    }

    @Override
    public double calculateRaceSpeed(IRace race) {
        double speed = (double)this.engine.getOutput() - ((double)super.getWeight() + (double)this.cargoWeight) + ((double)race.getOceanCurrentSpeed() / 2);;
        return speed;
    }
}
