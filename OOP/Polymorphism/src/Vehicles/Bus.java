package Vehicles;

public class Bus extends Vehicle{
    private boolean isEmpty;

    public Bus(Double fuelQuantity, Double fuelConsumption, Double tankCapacity) {
        this.setFuelQuantity(fuelQuantity);
        this.setFuelConsumption(fuelConsumption);
        this.setTankCapacity(tankCapacity);
    }

    private boolean isEmpty() {
        return isEmpty;
    }

    void setEmpty(boolean empty) {
        isEmpty = empty;
    }

    @Override
    protected void setFuelConsumption(Double fuelConsumption) {
        super.setFuelConsumption(fuelConsumption);
    }

    @Override
    protected void setFuelQuantity(Double fuelQuantity) {
        super.setFuelQuantity(fuelQuantity);
    }

    @Override
    protected void setTankCapacity(Double tankCapacity) {
        super.setTankCapacity(tankCapacity);
    }

    @Override
    public void refuel(Double liters){
        if(super.getTankCapacity()< super.getFuelQuantity()+liters){
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        }
        super.refuel(liters);
    };

    @Override
    public void drive(Double distance){
        if (isEmpty()) {
            if(this.getFuelQuantity()-super.getFuelConsumption()*distance < 0){
                throw new IllegalArgumentException(" needs refueling");
            }
            this.setFuelQuantity(this.getFuelQuantity() - super.getFuelConsumption() * distance);
        } else {
            if(this.getFuelQuantity()-(super.getFuelConsumption()+1.4)*distance < 0){
                throw new IllegalArgumentException(" needs refueling");
            }
            this.setFuelQuantity(this.getFuelQuantity() - (super.getFuelConsumption()+1.4) * distance);
        }
    };
}
