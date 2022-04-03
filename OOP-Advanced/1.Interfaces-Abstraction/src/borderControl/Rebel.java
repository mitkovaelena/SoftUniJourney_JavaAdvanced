package borderControl;

public class Rebel implements Buyer{
    private String name;
    private Integer age;
    private String group;
    private Integer food;

    public Rebel(String name, Integer age, String group) {
        this.name = name;
        this.age = age;
        this.group = group;
        this.food = 0;
    }

    @Override
    public void buyFood() {
        this.food+=5;
    }

    @Override
    public Integer getFood() {
        return this.food;
    }
}
