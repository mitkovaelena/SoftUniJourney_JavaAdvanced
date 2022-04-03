package e01_BoatRacingSimulator.models.boats;

import e01_BoatRacingSimulator.Utility.Validator;
import e01_BoatRacingSimulator.contracts.IRace;

public class RowBoat extends BaseBoat{
    private int oars;

    public RowBoat(String model, int weight, int oars) {
        super(model, weight, false);
        this.setOars(oars);
    }

    @Override
    public String getModel() {
        return super.getModel();
    }

    private void setOars(int oars) {
        Validator.validatePropertyValue(oars, "Oars");
        this.oars = oars;
    }

    @Override
    public double calculateRaceSpeed(IRace race) {
        double speed = ((double)this.oars * 100) - (double)super.getWeight() + (double)race.getOceanCurrentSpeed();
        return speed;
    }
}
