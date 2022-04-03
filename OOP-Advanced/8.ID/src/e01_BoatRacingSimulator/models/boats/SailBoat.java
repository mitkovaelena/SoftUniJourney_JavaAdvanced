package e01_BoatRacingSimulator.models.boats;

import e01_BoatRacingSimulator.Utility.Validator;
import e01_BoatRacingSimulator.contracts.IRace;

public class SailBoat extends BaseBoat{
    private int sailEfficiency;

    public SailBoat(String model, int weight, int sailEfficiency) {
        super(model, weight, false);
        this.setSailEfficiency(sailEfficiency);
    }

    @Override
    public String getModel() {
        return super.getModel();
    }

    private void setSailEfficiency(int sailEfficiency) {
        Validator.validatePropertyValue(sailEfficiency, "Efficiency");
        this.sailEfficiency = sailEfficiency;
    }

    @Override
    public double calculateRaceSpeed(IRace race) {
        double speed = ((double)race.getWindSpeed()* ((double)this.sailEfficiency / 100)) - (double)super.getWeight() + ((double)race.getOceanCurrentSpeed() / 2) ;
        return speed;
    }
}
