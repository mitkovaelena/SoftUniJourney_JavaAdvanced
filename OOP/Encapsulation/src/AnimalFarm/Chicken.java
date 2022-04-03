package AnimalFarm;

public class Chicken {
    private String name;
    private Integer age;

    public Chicken(String name, Integer age) {
        this.setName(name);
        this.setAge(age);
    }

    private void setName(String name) {
        if(name == null || name.length() < 1 || name.equals(" ") || name.isEmpty()){
            throw new IllegalArgumentException("Name cannot be empty.");
        }
        this.name = name;
    }

    private void setAge(Integer age) {
        if(age < 0 || age > 15){
            throw new IllegalArgumentException("Age should be between 0 and 15.");
        }
        this.age = age;
    }

    public Double productPerDay(){
        return calculateProductPerDay();
    }

    private Double calculateProductPerDay(){
        Double eggs = 0.0;
        if(this.age < 6){
            eggs = 2d;
        }
        else if(this.age <= 12){
            eggs = 1d;
        }
        else {
            eggs = 0.75;
        }
        return eggs;
    }

    @Override
    public String toString() {
        return "Chicken " + this.name + " (age " + this.age + ") can produce " + String.format("%.0f", this.productPerDay()) + " eggs per day.";
    }
}
