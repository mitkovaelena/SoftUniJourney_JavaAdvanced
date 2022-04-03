package Avatar.monuments;

public class EarthMonument extends Monument {

    private int earthAffinity;

    public EarthMonument(String name, int earthAffinity ) {
        super(name);
        this.earthAffinity = earthAffinity;
    }

    public int getEarthAffinity() {
        return this.earthAffinity;
    }

    @Override
    public String toString() {
        return "Earth Monument: " + super.getName() + ", Earth Affinity: " + this.earthAffinity;
    }
}
