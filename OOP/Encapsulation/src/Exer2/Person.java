package Exer2;

public class Person {
    private String firstName;
    private String lastName;
    private Integer age;
    private Double salary;

    Person(String firstName, String lastName, Integer age, Double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.salary = salary;
    }

    private void setSalary(Double salary) {
        this.salary = salary;
    }

    private Integer getAge() {
        return age;
    }

    private void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    private void setLastName(String lastName) {
        this.lastName = lastName;
    }

    private void setAge(Integer age) {
        this.age = age;
    }

    void increaseSalary(Double bonus) {
        if(this.getAge() < 30 ) bonus /= 2;
        this.setSalary(this.salary * bonus/100 + this.salary);
    }

    private String getFirstName() {
        return firstName;
    }

    private String getLastName() {
        return lastName;
    }

    private Double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return this.getFirstName() + " " + this.getLastName() + " get " + this.getSalary() + " leva";
    }
}
