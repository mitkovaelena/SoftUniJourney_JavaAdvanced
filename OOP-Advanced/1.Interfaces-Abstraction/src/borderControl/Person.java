package borderControl;

public class Person implements Identifiable, Birthable, Buyer {
    private String name;
    private Integer age;
    private String id;
    private String birthdate;
    private Integer food;

    public Person(String name, Integer age, String id, String birthdate) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.birthdate = birthdate;
        this.food = 0;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public String getBirthdate() {
        return this.birthdate;
    }

    @Override
    public void buyFood() {
        this.food+=10;
    }

    @Override
    public Integer getFood() {
        return this.food;
    }
}