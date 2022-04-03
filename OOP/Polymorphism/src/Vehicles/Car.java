package Vehicles;

public class Car extends Vehicle {

    public Car(Double fuelQuantity, Double fuelConsumption, Double tankCapacity) {
        this.setFuelQuantity(fuelQuantity);
        this.setFuelConsumption(fuelConsumption);
        this.setTankCapacity(tankCapacity);
    }

    @Override
    public void refuel(Double liters){
        if(super.getTankCapacity()< super.getFuelQuantity()+liters){
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        }
        super.refuel(liters);
    };

    @Override
    protected void setFuelConsumption(Double fuelConsumption) {
        super.setFuelConsumption(fuelConsumption+0.9);
    }

    @Override
    protected void setTankCapacity(Double tankCapacity) {
        super.setTankCapacity(tankCapacity);
    }

    @Override
    protected void setFuelQuantity(Double fuelQuantity) {
        super.setFuelQuantity(fuelQuantity);
    }
}
