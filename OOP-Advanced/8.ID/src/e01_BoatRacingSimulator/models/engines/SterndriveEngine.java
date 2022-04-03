package e01_BoatRacingSimulator.models.engines;

public class SterndriveEngine extends BaseEngine {
    private static final int Multiplier = 7;

    public SterndriveEngine(String model, int horsepower, int displacement) {
        super(model, horsepower, displacement);
    }

    public int getOutput() {
        if (super.getCachedOutput() != 0)
        {
            return super.getCachedOutput();
        }

        super.setCachedOutput((super.getHorsepower() * Multiplier) + super.getDisplacement());
        return super.getCachedOutput();
    }


}
