package NeedForSpeed.cars;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PerformanceCar extends Car {
    private List<String> addOns;

    public PerformanceCar(String brand, String model, int yearOfProduction, int horsepower, int acceleration, int suspension, int durability) {
        super(brand, model, yearOfProduction, horsepower, acceleration, suspension, durability);
        this.setAddOns(new ArrayList<>());
        this.setHorsepower(horsepower + (horsepower*50)/100);
        this.setSuspension(suspension - (suspension*25)/100);
    }

    @Override
    protected void setHorsepower(int horsepower) {
        super.setHorsepower(horsepower);
    }

    @Override
    protected void setSuspension(int suspension) {
        super.setSuspension(suspension);
    }

    public List<String> getAddOns() {
        return Collections.unmodifiableList(addOns);
    }

    @Override
    public String toString() {
        String output = super.toString() + "Add-ons: ";
        output+= this.getAddOns().size() > 0 ? this.getAddOns().toString().replaceAll("[\\[\\]]", "") : "None";
        return output;
    }

    @Override
    public String getBrand() {
        return super.getBrand();
    }

    @Override
    public String getModel() {
        return super.getModel();
    }

    @Override
    public int getYearOfProduction() {
        return super.getYearOfProduction();
    }

    @Override
    public int getHorsepower() {
        return super.getHorsepower();
    }

    @Override
    public int getAcceleration() {
        return super.getAcceleration();
    }

    @Override
    public int getSuspension() {
        return super.getSuspension();
    }

    @Override
    public int getDurability() {
        return super.getDurability();
    }

    @Override
    protected void setBrand(String brand) {
        super.setBrand(brand);
    }

    @Override
    protected void setModel(String model) {
        super.setModel(model);
    }

    @Override
    protected void setYearOfProduction(int yearOfProduction) {
        super.setYearOfProduction(yearOfProduction);
    }

    @Override
    protected void setAcceleration(int acceleration) {
        super.setAcceleration(acceleration);
    }

    @Override
    public void setDurability(int durability) {
        super.setDurability(durability);
    }

    @Override
    public void tune(int tuneIndex, String addOn){
        super.increaseHorsepower(tuneIndex);
        super.increaseSuspension(tuneIndex);
        this.addOns.add(addOn);
    }

    private void setAddOns(List<String> addOns) {
        this.addOns = addOns;
    }
}
