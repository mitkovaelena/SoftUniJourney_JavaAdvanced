import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class districtMap {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = reader.readLine().split(" ");
        Integer boundry = Integer.parseInt(reader.readLine());
        HashMap<String, List<Integer>> cities = new HashMap<>();

        for (String t : tokens) {
            String[] line = t.split(":");
            String name = line[0];
            int population = Integer.parseInt(line[1]);
            cities.putIfAbsent(name, new ArrayList<>()) ;
            cities.get(name).add(population);
        }

        cities.entrySet().stream().
                filter(x -> x.getValue().stream().mapToInt(Integer::valueOf).sum() > boundry)
                .sorted((e1,e2) -> Integer.compare(
                        e2.getValue().stream().mapToInt(Integer::valueOf).sum(),
                        e1.getValue().stream().mapToInt(Integer::valueOf).sum())
                ).forEach( x -> {
            System.out.print(x.getKey() + ": ");
            x.getValue().stream()
                    .sorted((a, b) -> b.compareTo(a))
                    .limit(5)
                    .forEach(y -> System.out.printf(y + " "));
            System.out.println();
        });
    }
}
