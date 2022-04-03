import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class parkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputLine = "";
        HashSet<String> parkingLot = new HashSet<>();
        while(!inputLine.equals("END")){
            inputLine = scanner.nextLine();
            String[] input = inputLine.split(", ");
            if(input[0].equals("IN")){
                parkingLot.add(input[1]);
            }
            else if(input[0].equals("OUT")){
                parkingLot.remove(input[1]);
            }
        }

        if(parkingLot.isEmpty()){
            System.out.println("Parking Lot is Empty");
            return;
        }
        for(String car : parkingLot){
            System.out.println(car);
        }
    }
}
