import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class fixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<String,String> people = new LinkedHashMap<>();

        while(true){
            String name = scanner.nextLine();
            if(name.equals("stop")) break;
            String email = scanner.nextLine();
            if(email.toLowerCase().endsWith("us") || email.toLowerCase().endsWith("uk") || email.toLowerCase().endsWith("com")){
                continue;
            }
            else {
                people.put(name,email);
            }
        }

        for(String key : people.keySet()){
            System.out.println(key + " -> " + people.get(key));
        }
    }
}
