package InterestRate;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private int age;
    private List<BankAccount> accounts;

    public Person(String name, int age) {
        this(name, age, new ArrayList<BankAccount>());
    }

    public Person(String name, int age, List<BankAccount> accounts) {
        this.name = name;
        this.age = age;
        this.accounts = accounts;
    }

    public double getBalance(){
        return this.accounts.stream().mapToDouble(s -> s.getBalance()).sum();
    }
}
