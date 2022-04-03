package e01_BoatRacingSimulator.models.boats;

import e01_BoatRacingSimulator.contracts.IRace;
import e01_BoatRacingSimulator.models.engines.BaseEngine;

public class PowerBoat extends BaseBoat{
    private BaseEngine[] engines;

    public PowerBoat(String model, int weight, BaseEngine[] engines) {
        super(model, weight, true);
        this.engines = engines;
    }

    @Override
    public String getModel() {
        return super.getModel();
    }

    @Override
    public double calculateRaceSpeed(IRace race) {
        double speed = ((double)this.engines[0].getOutput() + (double)this.engines[1].getOutput()) - (double)super.getWeight() + ((double)race.getOceanCurrentSpeed() / 5);
        return speed;
    }
}
