package Avatar.benders;

import java.text.DecimalFormat;

public class EarthBender extends Bender {

    private double groundSaturation;

    public EarthBender(String name, int power, double groundSaturation) {
        super(name, power);
        this.groundSaturation  = groundSaturation ;
    }

    public double getGroundSaturation() {
        return groundSaturation;
    }

    @Override
    public double getTotalPower() {
        return super.getPower() * groundSaturation;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("0.00");
        return "Earth Bender: " + super.getName() + ", Power: " + super.getPower() + ", Ground Saturation: " + df.format(this.groundSaturation);
    }
}
