package PawInc.Animals;

public class Dog extends Animal {
    private int learnedCommands;

    public Dog(String name, int age, int learnedCommands) {
        super(name, age);
        this.learnedCommands = learnedCommands;
    }

    public int getLearnedCommands() {
        return learnedCommands;
    }

    public void setLearnedCommands(int learnedCommands) {
        this.learnedCommands = learnedCommands;
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
