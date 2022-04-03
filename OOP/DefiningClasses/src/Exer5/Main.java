package Exer5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        LinkedHashMap<String, Car> cars = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] line = reader.readLine().split("\\s+");
            Car car = new Car(line[0], Double.parseDouble(line[1]), Double.parseDouble(line[2]));
            cars.put(line[0], car);
        }

        while (true) {
            String command = reader.readLine();
            if ("End".equals(command)) {
                break;
            }
            String[] line = command.split("\\s+");
            Car car = cars.get(line[1]);
            car.isFuelSufficientForRide(Double.parseDouble(line[2]));
            cars.put(line[1], car);
        }

        for(Car c : cars.values()){
            System.out.println(c);
        }

    }
}
