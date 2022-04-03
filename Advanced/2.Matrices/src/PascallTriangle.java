import java.util.Arrays;
import java.util.Scanner;

public class PascallTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[][] pascalTriangle = new String[n][n];
        pascalTriangle[0][0] = "1";
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if(j == 0) pascalTriangle[i][j] = "1";
                else if(j == i) pascalTriangle[i][j] = "1";
                else pascalTriangle[i][j] = Long.toString(Long.parseLong(pascalTriangle[i-1][j]) + Long.parseLong(pascalTriangle[i-1][j-1]));
            }
        }
        for(String[] line : pascalTriangle){
            String[] lineFiltered = Arrays.stream(line).filter(s -> s != null).toArray(String[]::new);
            System.out.println(String.join(" ", lineFiltered));
        }
    }
}
