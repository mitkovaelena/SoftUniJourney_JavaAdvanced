package NeedForSpeed.garages;

import NeedForSpeed.cars.Car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Garage {
    private List<Car> parkedCars;

    public Garage() {
        this.setParkedCars(new ArrayList<>());
    }

    public List<Car> getParkedCars() {
        return Collections.unmodifiableList(parkedCars);
    }

    private void setParkedCars(List<Car> parkedCars) {
        this.parkedCars = parkedCars;
    }

    public void addCar(Car car){
        this.parkedCars.add(car);
    }

    public void removeCar(Car car){
        this.parkedCars.remove(car);
    }

    public void tune(int tuneIndex, String addOn){
        for(Car c : this.parkedCars){
            c.tune(tuneIndex, addOn);
        }
    }
}
