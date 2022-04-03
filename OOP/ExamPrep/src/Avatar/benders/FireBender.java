package Avatar.benders;

import java.text.DecimalFormat;

public class FireBender extends Bender {

    private double heatAggression;

    public FireBender(String name, int power, double heatAggression) {
        super(name, power);
        this.heatAggression  = heatAggression ;
    }

    public double getHeatAggression() {
        return heatAggression;
    }

    @Override
    public double getTotalPower() {
        return super.getPower() * heatAggression;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("0.00");
        return "Fire Bender: " + super.getName() + ", Power: " + super.getPower() + ", Heat Aggression: " + df.format(this.heatAggression);
    }
}
