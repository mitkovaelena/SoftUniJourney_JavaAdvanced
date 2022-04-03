package Exer1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        LinkedHashSet<Employee> employees = new LinkedHashSet<>();
        TreeMap<String, ArrayList<Double>> departments = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String[] line = reader.readLine().split("\\s+");
            Employee empl = new Employee(line);
            employees.add(empl);

            if(!departments.containsKey(line[3])) departments.put(line[3], new ArrayList<Double>());
            ArrayList<Double> temp = departments.get(line[3]);
            temp.add(Double.parseDouble(line[1]));
            departments.put(line[3], temp);
        }

        Map<String, Double> mappedDepartments = new HashMap<>();
        departments.entrySet().stream().forEachOrdered( x-> mappedDepartments.put(x.getKey(), x.getValue()
                .stream().mapToDouble(Double::valueOf).sum() / x.getValue().size()));

        Map<String, Double> sortedDepartments = new HashMap<>();
        mappedDepartments.entrySet().stream()
                .sorted(Map.Entry.<String, Double> comparingByValue().reversed())
                .forEachOrdered(x -> sortedDepartments.put(x.getKey(), x.getValue()));

        String depart = "";
        for(String d : sortedDepartments.keySet()) {
            depart = d;
            System.out.println("Highest Average Salary: " + d);
            break;
        }

        String finalDepart = depart;
        employees.stream().filter(x -> Objects.equals(x.getDepartment(), finalDepart)).sorted((d1, d2) -> Double.compare(d2.getSalary(), d1.getSalary()))
                .forEach(x -> System.out.println(String.format("%s %.2f %s %d", x.getName(), x.getSalary(), x.getEmail(), x.getAge())));
    }
}
