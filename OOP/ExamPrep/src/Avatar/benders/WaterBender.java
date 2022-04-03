package Avatar.benders;

import java.text.DecimalFormat;

public class WaterBender extends Bender {

    private double waterClarity;

    public WaterBender(String name, int power, double waterClarity) {
        super(name, power);
        this.waterClarity  = waterClarity ;
    }

    public double getWaterClarity() {
        return waterClarity;
    }

    @Override
    public double getTotalPower() {
        return super.getPower() * waterClarity;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("0.00");
        return "Water Bender: " + super.getName() + ", Power: " + super.getPower() + ", Water Clarity: " + df.format(this.waterClarity);
    }
}
