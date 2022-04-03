import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class setsOfElemens {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.nextLine();
        LinkedHashSet<Integer> one = new LinkedHashSet<>();
        LinkedHashSet<Integer> two = new LinkedHashSet<>();

        for (int i = 0; i < n; i++){
            String line = scanner.nextLine();
            one.add(Integer.parseInt(line));
        }

        for (int i = 0; i < m; i++){
            String line = scanner.nextLine();
            two.add(Integer.parseInt(line));
        }

        for(Integer element : one){
            if(two.contains(element)) {
                System.out.print(element + " ");
                two.remove(element);
            }
        }

        for(Integer element : two){
            if(one.contains(element)) {
                System.out.print(element + " ");
            }
        }
    }
}
