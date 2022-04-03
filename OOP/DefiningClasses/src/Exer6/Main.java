package Exer6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        LinkedHashMap<String, Car> cars = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] line = reader.readLine().split("\\s+");
            ArrayList<Double> pressures = new ArrayList<>();
            Collections.addAll(pressures, Double.parseDouble(line[5]),Double.parseDouble(line[7]),Double.parseDouble(line[9]),Double.parseDouble(line[11]));
            ArrayList<Double> ages = new ArrayList<>();
            Collections.addAll(ages, Double.parseDouble(line[6]),Double.parseDouble(line[8]),Double.parseDouble(line[10]),Double.parseDouble(line[12]));
            Car car = new Car(line[0], Integer.parseInt(line[1]),Integer.parseInt(line[2]),Integer.parseInt(line[3]),
                   line[4], pressures, ages);
            cars.put(line[0], car);
        }

        String command = reader.readLine();

        switch (command){
            case "fragile":
                cars.entrySet().stream().filter(x -> x.getValue().getTirePressures()< 1)
                        .forEachOrdered(x -> System.out.println(x.getKey()));
                break;
            case "flamable":
                cars.entrySet().stream().filter(x -> x.getValue().getEnginePower() > 250)
                        .forEachOrdered(x -> System.out.println(x.getKey()));
                break;
        }
    }
}
