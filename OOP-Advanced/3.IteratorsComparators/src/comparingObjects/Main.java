package comparingObjects;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Set<Person> people1 = new TreeSet<>();
        Set<Person> people2 = new HashSet<>();

        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++) {
            String[] input = reader.readLine().split("\\s+");
            Person person = new Person(input[0], Integer.parseInt(input[1]));
            people1.add(person);
            people2.add(person);
        }

        System.out.println(people1.size());
        System.out.println(people2.size());

    }
}
