package Exer5;

public class Car {
    private String model;
    private Double fuelAmount;
    private Double fuelCost;
    private Double distance;

    public Car(String model, Double fuelAmount, Double fuelCost) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelCost = fuelCost;
        this.distance = 0.0;
    }

    public void isFuelSufficientForRide(double km){
      if(km*this.fuelCost > this.fuelAmount){
          System.out.println("Insufficient fuel for the drive");
          return;
      }
      this.fuelAmount -= km*this.fuelCost;
      this.distance += km;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %.0f", this.model, this.fuelAmount, this.distance);
    }
}
