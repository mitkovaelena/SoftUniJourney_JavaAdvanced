package Exer3;

public class Person {
    private String firstName;
    private String lastName;
    private Integer age;
    private Double salary;

    Person(String firstName, String lastName, Integer age, Double salary) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setAge(age);
        this.setSalary(salary);
    }

    private void setSalary(Double salary) {
        if(salary <= 460 ){
            throw new IllegalArgumentException("Salary cannot be less than 460 leva");
        }
        this.salary = salary;
    }

    private Integer getAge() {
        return age;
    }

    private void setFirstName(String firstName) {
        if(firstName.length()< 3){
            throw new IllegalArgumentException("First name cannot be less than 3 symbols");
        }
        this.firstName = firstName;
    }

    private void setLastName(String lastName) {
        if(lastName.length()< 3){
            throw new IllegalArgumentException("Last name cannot be less than 3 symbols");
        }
        this.lastName = lastName;
    }

    private void setAge(Integer age) {
        if(age <=0 ){
            throw new IllegalArgumentException("Age cannot be zero or negative integer");
        }
        this.age = age;
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

    void increaseSalary(Double bonus) {
        if(this.getAge() < 30 ) bonus /= 2;
        this.setSalary(this.salary * bonus/100 + this.salary);
    }


    @Override
    public String toString() {
        return this.getFirstName() + " " + this.getLastName() + " get " + this.getSalary() + " leva";
    }
}
