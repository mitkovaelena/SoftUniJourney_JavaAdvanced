package e01_BoatRacingSimulator.models.engines;

public class JetEngine extends BaseEngine {
    private static final int Multiplier = 5;

    public JetEngine(String model, int horsepower, int displacement) {
        super(model, horsepower, displacement);
    }

    @Override
    public int getOutput() {
        if (super.getCachedOutput() != 0) {
            return super.getCachedOutput();
        }

        super.setCachedOutput((super.getHorsepower() * Multiplier) + super.getDisplacement());
        return super.getCachedOutput();
    }
}
