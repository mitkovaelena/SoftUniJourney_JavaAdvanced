import java.util.Arrays;
import java.util.Scanner;

public class vehiclePark {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] cars = scanner.nextLine().split("[ ]+");
        int soldCars = 0;

        while(true){
            String[] command = scanner.nextLine().split("[ ]+");
            if(command[0].equals("End")) break;
            String vehicle = command[0].toLowerCase().charAt(0) + command[2];
            if(Arrays.asList(cars).contains(vehicle)){
                int price = ((int)(command[0].toLowerCase().charAt(0)))*Integer.parseInt(command[2]);
                soldCars++;
                System.out.printf("Yes, sold for %d$\n", price);
                for (int i = 0; i < cars.length; i++) {
                    if(cars[i].equals(vehicle)){
                        cars[i] = "0";
                        break;
                    }

                }
            }
            else{
                System.out.printf("No\n");
            }
        }

        cars = Arrays.stream(cars).filter(e -> !e.equals("0")).toArray(String[]::new);
        System.out.println("Vehicles left: " + String.join(", ", cars));
        System.out.println("Vehicles sold: " + soldCars);

    }
}
