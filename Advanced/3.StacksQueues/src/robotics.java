import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class robotics {
    public static void main(String[] args) {
        DateFormat format = new SimpleDateFormat("hh:mm:ss",Locale.US);
        Scanner scanner = new Scanner(System.in);
        String[] robotsStr = scanner.nextLine().split(";");

        Date startTime = null;
        String line = scanner.nextLine();
        try {
            startTime = format.parse(line);
        } catch (ParseException e) {
            return;
        }

        HashMap<String, Integer> robots = new HashMap<String, Integer>();
        ArrayDeque<String> products = new ArrayDeque<>();
        for(String robotStr : robotsStr){
            String[] robot = robotStr.split("-");
            robots.put(robot[0], Integer.parseInt(robot[1]));
        }
        String inputProduct = "";
        int i = 0;
        while (!inputProduct.equals("End")){
            inputProduct = scanner.nextLine();
            for(Map.Entry<String, Integer> r : robots.entrySet()) {
                String key = r.getKey();
                Integer value = r.getValue();
                if(value == i){
                    System.out.println(key + " - " + inputProduct + " ["+startTime + "]");
                }
            }
            i++;
            Date afterAddingSec = new Date(startTime.getTime()+ 1000);
            startTime = afterAddingSec;
        }
    }
}
