package Exer6;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Car {
    private String model;
    private Integer engineSpeed;
    private Integer enginePower;
    private Integer cargoWeight;
    private String cargoType;
    private ArrayList<Double> tirePressures;
    private ArrayList<Double> tireAges;

    public Car(String model, Integer engineSpeed, Integer enginePower, Integer cargoWeight, String cargoType, ArrayList<Double> tirePressures, ArrayList<Double> tireAges) {
        this.model = model;
        this.engineSpeed = engineSpeed;
        this.enginePower = enginePower;
        this.cargoWeight = cargoWeight;
        this.cargoType = cargoType;
        this.tirePressures = tirePressures;
        this.tireAges = tireAges;
    }

    public Double getTirePressures() {
        List<Double> temp =  tirePressures.stream().sorted((a, b) -> Double.compare(a,b)).collect(Collectors.toList());
        return temp.get(0);
    }

    public Integer getEnginePower() {
        return enginePower;
    }
}
