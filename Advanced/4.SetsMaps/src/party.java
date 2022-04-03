import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

public class party {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputLine = "";
        TreeSet<String> guests = new TreeSet<>();
        while(!inputLine.equals("PARTY")){
            inputLine = scanner.next();
            if(inputLine.length() == 8){
                    guests.add(inputLine);
            }
        }

        while(!inputLine.equals("END")){
            inputLine = scanner.next();
                guests.remove(inputLine);
        }

        System.out.println(guests.size());
        if(!guests.isEmpty()){
            for(String guest : guests){
                System.out.println(guest);
            }
        }
    }
}
