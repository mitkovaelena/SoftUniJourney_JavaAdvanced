import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class filterByAge {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Integer n = Integer.parseInt(reader.readLine());
        LinkedHashMap<String, Integer> people = new LinkedHashMap<>();

        Function<String, Integer> parser = x -> Integer.parseInt(x);

        for (int i = 0; i < n; i++) {
            String[] input = reader.readLine().split("\\s*,\\s*");
            people.put(input[0], parser.apply(input[1]));
        }

        String condition = reader.readLine();
        Integer age = Integer.parseInt(reader.readLine());
        String format = reader.readLine();

        Map<String, Integer> peopleSorted = new LinkedHashMap<String, Integer>();
        people.entrySet().stream()
                .forEachOrdered(x -> {
                    if(isConditionFulfilled(condition,age,x.getValue())) {
                        peopleSorted.put(x.getKey(), x.getValue());
                    }
                });

        for(Map.Entry<String, Integer> person : peopleSorted.entrySet()) {
            switch (format) {
                case "name":
                    System.out.printf("%s%n", person.getKey(), person.getValue());
                    break;
                case "age":
                    System.out.printf("%d%n", person.getKey(), person.getValue());
                    break;
                case "name age":
                    System.out.printf("%s - %d%n", person.getKey(), person.getValue());
                    break;
            }
        }
    }

    public static boolean isConditionFulfilled(String condition, Integer ageBoundry, Integer age){
        switch (condition) {
            case "younger":
                return age <= ageBoundry;
            case "older":
                return age >= ageBoundry;
        }
        return false;
    }
}
