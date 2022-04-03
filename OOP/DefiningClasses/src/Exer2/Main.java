package Exer2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        LinkedHashSet<Car> cars = new LinkedHashSet<>();
        HashMap<String, Engine> engines = new HashMap();

        for (int i = 0; i < n; i++) {
            String[] line = reader.readLine().split("\\s+");
            if(line.length == 2) {
                Engine engine = new Engine(line[0],Integer.parseInt(line[1]));
                engines.put(line[0], engine);
            }
            else if(line.length == 4) {
                Engine engine = new Engine(line[0],Integer.parseInt(line[1]), Integer.parseInt(line[2]), line[3]);
                engines.put(line[0], engine);
            }
            else if(line.length == 3 && Character.isLetter(line[2].charAt(0))) {
                Engine engine = new Engine(line[0],Integer.parseInt(line[1]), line[2]);
                engines.put(line[0], engine);
            }
            else {
                Engine engine = new Engine(line[0],Integer.parseInt(line[1]), Integer.parseInt(line[2]));
                engines.put(line[0], engine);
            }
        }

        int m = Integer.parseInt(reader.readLine());

        for (int i = 0; i < m; i++) {
            String[] line = reader.readLine().split("\\s+");
            if(line.length == 2) {
                Car car = new Car(line[0], engines.get(line[1]));
                cars.add(car);
            }
            else if(line.length == 4) {
                Car car = new Car(line[0], engines.get(line[1]), Integer.parseInt(line[2]), line[3]);
                cars.add(car);
            }
            else if(line.length == 3 && Character.isLetter(line[2].charAt(0))) {
                Car car = new Car(line[0], engines.get(line[1]), line[2]);
                cars.add(car);
            }
            else {
                Car car = new Car(line[0], engines.get(line[1]), Integer.parseInt(line[2]));
                cars.add(car);
            }
        }

        for(Car c : cars){
            System.out.println(c);
        }
    }
}
