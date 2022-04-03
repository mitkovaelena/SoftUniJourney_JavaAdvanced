package NeedForSpeed.cars;

public class ShowCar extends Car{
    private int stars;

    public ShowCar(String brand, String model, int yearOfProduction, int horsepower, int acceleration, int suspension, int durability) {
        super(brand, model, yearOfProduction, horsepower, acceleration, suspension, durability);
        this.setStars(0);
    }

    private void setStars(int stars) {
        this.stars = stars;
    }

    public int getStars() {
        return stars;
    }

    @Override
    public String toString() {
        String output = super.toString() ;
        output+= this.getStars() + " *";
        return output;
    }

    @Override
    protected void setHorsepower(int horsepower) {
        super.setHorsepower(horsepower);
    }

    @Override
    protected void setSuspension(int suspension) {
        super.setSuspension(suspension);
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
        this.setStars(this.getStars()+ tuneIndex);
    }
}
