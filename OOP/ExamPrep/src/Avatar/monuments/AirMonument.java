package Avatar.monuments;

public class AirMonument extends Monument {

    private int airAffinity;

    public AirMonument(String name, int airAffinity ) {
        super(name);
        this.airAffinity = airAffinity;
    }

    public int getAirAffinity() {
        return this.airAffinity;
    }

    @Override
    public String toString() {
        return "Air Monument: " + super.getName() + ", Air Affinity: " + this.airAffinity;
    }
}
