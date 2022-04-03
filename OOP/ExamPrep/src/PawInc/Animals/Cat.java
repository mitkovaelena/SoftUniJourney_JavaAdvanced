package PawInc.Animals;

public class Cat extends Animal{
    private int inteligenceCoefficient;

    public Cat(String name, int age, int inteligenceCoefficient) {
        super(name, age);
        this.inteligenceCoefficient = inteligenceCoefficient;
    }

    public int getInteligenceCoefficient() {
        return inteligenceCoefficient;
    }

    public void setInteligenceCoefficient(int inteligenceCoefficient) {
        this.inteligenceCoefficient = inteligenceCoefficient;
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    protected void setName(String name) {
        super.setName(name);
    }

    @Override
    public int getAge() {
        return super.getAge();
    }

    @Override
    protected void setAge(int age) {
        super.setAge(age);
    }

    @Override
    public boolean isCleansed() {
        return super.isCleansed();
    }

    @Override
    protected void setCleansed(boolean cleansed) {
        super.setCleansed(cleansed);
    }

    @Override
    public boolean isCastrated() {
        return super.isCastrated();
    }

    @Override
    protected void setCastrated(boolean castrated) {
        super.setCastrated(castrated);
    }
}
