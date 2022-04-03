import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.TreeSet;

public class uniqueUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        TreeSet<String> users = new TreeSet<>();
        for (int i = 0; i < n; i++){
            String[] line = scanner.nextLine().split(" ");
            for (String l : line) {
                users.add(l);
            }
        }

        for(String user : users){
            System.out.print(user + " ");
        }
    }
}
