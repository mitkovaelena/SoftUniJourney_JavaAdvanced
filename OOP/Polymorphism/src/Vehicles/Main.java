package Vehicles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] carString = reader.readLine().split(" ");
        String[] truckString = reader.readLine().split(" ");
        String[] busString = reader.readLine().split(" ");

        try {
            Car car = new Car(Double.parseDouble(carString[1]), Double.parseDouble(carString[2]),  Double.parseDouble(carString[3]));
            Truck truck = new Truck(Double.parseDouble(truckString[1]), Double.parseDouble(truckString[2]),  Double.parseDouble(truckString[3]));
            Bus bus = new Bus(Double.parseDouble(busString[1]), Double.parseDouble(busString[2]),  Double.parseDouble(busString[3]));

        Integer n = Integer.parseInt(reader.readLine());
            DecimalFormat df = new DecimalFormat("#.#########################");
            for (int i = 0; i < n; i++) {
            String[] line = reader.readLine().split(" ");

            if (line[0].equals("Drive")) {
                if (line[1].equals("Car")) {
                    try {
                        car.drive(Double.parseDouble(line[2]));
                        System.out.println(String.format("Car travelled %s km", df.format(Double.parseDouble(line[2]))));
                    } catch (IllegalArgumentException iae){
                        System.out.println(line[1] + iae.getMessage());
                    }
                } else if(line[1].equals("Bus")) {
                    try {
                        bus.setEmpty(false);
                        bus.drive(Double.parseDouble(line[2]));
                        System.out.println(String.format("Bus travelled %s km", df.format(Double.parseDouble(line[2]))));
                    } catch (IllegalArgumentException iae){
                        System.out.println(line[1] + iae.getMessage());
                    }
                }else {
                    try {
                        truck.drive(Double.parseDouble(line[2]));
                        System.out.println(String.format("Truck travelled %s km", df.format(Double.parseDouble(line[2]))));
                    } catch (IllegalArgumentException iae) {
                        System.out.println(line[1] + iae.getMessage());
                    }
                }
            } else if(line[0].equals("DriveEmpty")) {
                try {
                    bus.setEmpty(true);
                    bus.drive(Double.parseDouble(line[2]));
                    System.out.println(String.format("Bus travelled %s km", df.format(Double.parseDouble(line[2]))));
                } catch (IllegalArgumentException iae){
                    System.out.println(line[1] + iae.getMessage());
                }
            }else {
                    if (line[1].equals("Car")) {
                        try {
                            car.refuel(Double.parseDouble(line[2]));
                        } catch (IllegalArgumentException iae) {
                            System.out.println(iae.getMessage());
                        }
                    } else if(line[1].equals("Bus")) {
                        try{
                            bus.refuel(Double.parseDouble(line[2]));
                        } catch (IllegalArgumentException iae) {
                            System.out.println(iae.getMessage());
                        }
                    } else {
                            try{
                                truck.refuel(Double.parseDouble(line[2]));
                            } catch (IllegalArgumentException iae) {
                                System.out.println(iae.getMessage());
                            }
                        }
                    }
                }
        System.out.println("Car" + car.toString());
        System.out.println("Truck" + truck.toString());
        System.out.println("Bus" + bus.toString());
        } catch (IllegalArgumentException iae){
            System.out.println(iae.getMessage());
        }
    }
}
