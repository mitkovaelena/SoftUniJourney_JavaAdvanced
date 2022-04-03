package Exer2;

public class Car {
    private String model;
    private Engine engine;
    private String weight;
    private String color;

    public Car(String model, Engine engine) {
        this.model = model;
        this.engine = engine;
        this.weight = "n/a";
        this.color = "n/a";
    }

    public Car(String model, Engine engine, int weight) {
        this.model = model;
        this.engine = engine;
        this.weight = String.valueOf(weight);
        this.color = "n/a";
    }

    public Car(String model, Engine engine, String color) {
        this.model = model;
        this.engine = engine;
        this.color = color;
        this.weight = "n/a";
    }

    public Car(String model, Engine engine, int weight, String color) {
        this.model = model;
        this.engine = engine;
        this.weight = String.valueOf(weight);
        this.color = color;
    }

    @Override
    public String toString() {
        return String.format("%s:%n%s%n  Weight: %s%n  Color: %s", this.model, this.engine.toString(), this.weight,this.color);
    }
}
