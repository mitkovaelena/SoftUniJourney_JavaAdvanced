import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class truckTour {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        ArrayDeque<String> pumps = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            pumps.add(scanner.nextLine() + " "+ i);
        }
        int i = 0;
        String  ind = "";
        int sum = 0;
            while(i < n){
                String fuelDistStr = pumps.poll();
                pumps.offer(fuelDistStr);
                String[] fuelDist = fuelDistStr.split(" ");
                sum += Integer.parseInt(fuelDist[0]);
                if(i == 0) ind = fuelDist[2];
                i++;
                if(sum < Integer.parseInt(fuelDist[1])){
                    sum = 0;
                    i = 0;
                }
                else{
                    sum -= Integer.parseInt(fuelDist[1]);
                }
            }
        System.out.println(ind);
    }
}
