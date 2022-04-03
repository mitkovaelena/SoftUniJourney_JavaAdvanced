package Vehicles;

public abstract class Vehicle {
    private Double fuelQuantity;
    private Double fuelConsumption;
    private Double tankCapacity;

    public Vehicle() {
    }

    public Vehicle(Double fuelQuantity, Double fuelConsumption, Double tankCapacity) {
        this.setFuelQuantity(fuelQuantity);
        this.setFuelConsumption(fuelConsumption);
        this.setTankCapacity(tankCapacity);
    }

    public void drive(Double distance){
        if(this.getFuelQuantity()-this.fuelConsumption*distance < 0){
            throw new IllegalArgumentException(" needs refueling");
        }
        this.setFuelQuantity(this.getFuelQuantity()-this.fuelConsumption*distance);
    };

    public void refuel(Double liters){
        this.setFuelQuantity(this.getFuelQuantity()+liters);
    };

    protected Double getTankCapacity() {
        return tankCapacity;
    }

    protected void setTankCapacity(Double tankCapacity) {
        this.tankCapacity = tankCapacity;
    }

    protected Double getFuelQuantity() {
        return fuelQuantity;
    }

    protected void setFuelQuantity(Double fuelQuantity) {
        if(fuelQuantity < 0){
            throw new IllegalArgumentException("Fuel must be a positive number");
        }
        this.fuelQuantity = fuelQuantity;
    }

    protected Double getFuelConsumption() {
        return fuelConsumption;
    }

    protected void setFuelConsumption(Double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    @Override
    public String toString() {
        return String.format(": %.2f", this.getFuelQuantity());
    }
}
