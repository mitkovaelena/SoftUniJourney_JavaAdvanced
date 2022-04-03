package NeedForSpeed.cars;

public abstract class Car {
    private String brand;
    private String model;
    private int yearOfProduction;
    private int horsepower;
    private int acceleration;
    private int suspension;
    private int durability;

    protected Car(String brand, String model, int yearOfProduction, int horsepower, int acceleration, int suspension, int durability) {
        this.setBrand(brand);
        this.setModel(model);
        this.setYearOfProduction(yearOfProduction);
        this.setHorsepower(horsepower);
        this.setAcceleration(acceleration);
        this.setSuspension(suspension);
        this.setDurability(durability);
    }

    protected void setBrand(String brand) {
        this.brand = brand;
    }

    protected void setModel(String model) {
        this.model = model;
    }

    protected void setYearOfProduction(int yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }

    protected void setHorsepower(int horsepower) {
        this.horsepower = horsepower;
    }

    protected void setAcceleration(int acceleration) {
        this.acceleration = acceleration;
    }

    protected void setSuspension(int suspension) {
        this.suspension = suspension;
    }

    public void setDurability(int durability) {
        this.durability = durability;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getYearOfProduction() {
        return yearOfProduction;
    }

    public int getHorsepower() {
        return horsepower;
    }

    public int getAcceleration() {
        return acceleration;
    }

    public int getSuspension() {
        return suspension;
    }

    public int getDurability() {
        return durability;
    }

    public void increaseHorsepower(int index){
        this.setHorsepower(this.getHorsepower()+index);
    }

    public void increaseSuspension(int index){
        this.setSuspension(this.getSuspension()+(index/2));
    }

    public abstract void tune(int tuneIndex, String addOn);

    @Override
    public String toString() {
        return String.format("%s %s %d\n" +
                        "%d HP, 100 m/h in %d s\n" +
                        "%d Suspension force, %d Durability\n",
                this.getBrand(), this.getModel(), this.getYearOfProduction(),
                this.getHorsepower(), this.getAcceleration(), this.getSuspension(), this.getDurability());
    }
}
