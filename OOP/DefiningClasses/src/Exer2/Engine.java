package Exer2;

public class Engine {
    private String model;
    private String power;
    private String displacement;
    private String  efficiency;

    public Engine(String model, int power) {
        this.model = model;
        this.power = String.valueOf(power);
        this.displacement = "n/a";
        this.efficiency = "n/a";
    }

    public Engine(String model, int power, int displacement) {
        this.model = model;
        this.power = String.valueOf(power);
        this.displacement = String.valueOf(displacement);
        this.efficiency = "n/a";
    }

    public Engine(String model,int power, String efficiency) {
        this.model = model;
        this.power = String.valueOf(power);
        this.efficiency = efficiency;
        this.displacement = "n/a";
    }

    public Engine(String model, int power, int displacement, String efficiency) {
        this.model = model;
        this.power = String.valueOf(power);
        this.displacement = String.valueOf(displacement);
        this.efficiency = efficiency;
    }

    @Override
    public String toString() {
        return String.format("  %s:%n    Power: %s%n    Displacement: %s%n    Efficiency: %s", this.model, this.power, this.displacement,this.efficiency);
    }
}
