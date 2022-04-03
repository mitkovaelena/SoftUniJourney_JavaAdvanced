import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeSet;

public class phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputLine = "";
        HashMap<String,String> guests = new HashMap<>();

        while(true){
            inputLine = scanner.nextLine();
            if(inputLine.equals("search")) break;
            String[] line = inputLine.split("-");
                guests.put(line[0],line[1]);
        }

        while(true){
            inputLine = scanner.nextLine();
            if(inputLine.equals("stop")) break;
            if(guests.containsKey(inputLine)){
                    System.out.println(inputLine + " -> " + guests.get(inputLine));
                }
                else
                    System.out.println("Contact "+ inputLine + " does not exist.");
        }
    }
}
