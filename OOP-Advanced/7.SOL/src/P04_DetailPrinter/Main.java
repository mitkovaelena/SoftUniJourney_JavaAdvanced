package P04_DetailPrinter;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Employee employee = new Employee("Ivo");
        Set<String> documents = new HashSet<>();
        Collections.addAll(documents, "E", "l", "i") ;
        Employee manager = new Manager("Elena", documents);

        Set<Employee> employees = new HashSet<>();
        Collections.addAll(employees, employee, manager) ;
        DetailsPrinter dp = new DetailsPrinter(employees);
        dp.printDetails();


    }
}
