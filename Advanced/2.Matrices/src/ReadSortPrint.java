import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class ReadSortPrint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        String[] lines = new String[n];
        for (int i = 0; i < n; i++) {
            lines[i] = scanner.nextLine();
        }
        Arrays.sort(lines);
        System.out.println(String.join("\n", lines));
    }
}
