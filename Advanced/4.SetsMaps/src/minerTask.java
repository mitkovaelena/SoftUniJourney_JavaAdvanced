import java.util.HashMap;
import java.util.Scanner;

public class minerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String,Integer> mine = new HashMap<>();

        while(true){
            String inputLine = scanner.nextLine();
            if(inputLine.equals("stop")) break;
            Integer quantity = Integer.parseInt(scanner.nextLine());
            if(mine.containsKey(inputLine)){
                mine.put(inputLine,mine.get(inputLine)+quantity);
            }
            else {
                mine.put(inputLine,quantity);
            }
        }

        for(String key : mine.keySet()){
                System.out.println(key + " -> " + mine.get(key));
        }
    }
}
