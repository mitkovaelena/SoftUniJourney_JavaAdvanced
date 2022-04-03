package Vehicles;

public class Truck extends Vehicle{
    public Truck(Double fuelQuantity, Double fuelConsumption, Double tankCapacity) {
        this.setFuelQuantity(fuelQuantity);
        this.setFuelConsumption(fuelConsumption);
        this.setTankCapacity(tankCapacity);
    }

    @Override
    protected void setFuelConsumption(Double fuelConsumption) {
        super.setFuelConsumption(fuelConsumption+1.6);
    }

    @Override
    protected void setFuelQuantity(Double fuelQuantity) {
        super.setFuelQuantity(fuelQuantity);
    }

    @Override
    public void refuel(Double liters){
        super.refuel(liters*0.95);
    };

}