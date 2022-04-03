package NeedForSpeed;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        CarManager carManager = new CarManager();
        boolean isRunning = true;

        while (isRunning) {
            String[] command = reader.readLine().split(" ");

            if (command[0].equals("Cops")) {
                isRunning = false;
                break;
            }
            switch (command[0]) {
                case "register":
                    carManager.register(Integer.parseInt(command[1]), command[2], command[3], command[4], Integer.parseInt(command[5]), Integer.parseInt(command[6]), Integer.parseInt(command[7]), Integer.parseInt(command[8]), Integer.parseInt(command[9]));
                    break;
                case "check":
                    System.out.println(carManager.check(Integer.parseInt(command[1])));
                    break;
                case "open":
                    if (command[2].equals("TimeLimit") || command[2].equals("Circuit")) {
                        carManager.open(Integer.parseInt(command[1]), command[2], Integer.parseInt(command[3]), command[4], Integer.parseInt(command[5]), Integer.parseInt(command[6]));
                    } else {
                        carManager.open(Integer.parseInt(command[1]), command[2], Integer.parseInt(command[3]), command[4], Integer.parseInt(command[5]));
                    }
                    break;
                case "participate":
                    carManager.participate(Integer.parseInt(command[1]), Integer.parseInt(command[2]));
                    break;
                case "start":
                    System.out.print(carManager.start(Integer.parseInt(command[1])));
                    break;
                case "park":
                    carManager.park(Integer.parseInt(command[1]));
                    break;
                case "unpark":
                    carManager.unpark(Integer.parseInt(command[1]));
                    break;
                case "tune":
                    carManager.tune(Integer.parseInt(command[1]), command[2]);
                    break;
                default:
                    break;
            }
        }
    }

}
