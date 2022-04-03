import java.util.Arrays;
import java.util.Scanner;

public class fillMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] line = scanner.nextLine().split(", ");
        int n = Integer.parseInt(line[0]);
        String pattern = line[1];
        String[][] matrix = new String[n][n];
        if(pattern.equals("A")) matrix = PatternA(n);
        else if(pattern.equals("B")) matrix = PatternB(n);

        for(String[] l : matrix){
            System.out.println(String.join(" ", l));
        }

    }

    public static String[][] PatternA(int n) {
        String [][] matrix = new String[n][n];
        int count = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
               matrix[j][i] =  Integer.toString(count++);
            }
        }
        return matrix;
    }

    public static String[][] PatternB(int n) {
        String[][] matrix = new String[n][n];
        int count1 = 1;
        int count2 = 2*n;
        for (int i = 0; i < n; i++) {
            count1 = 1 + 2*n*(i/2);
            count2 = 2*n*((i+1)/2);

            for (int j = 0; j < n; j++) {
                if(i % 2 ==0)
                matrix[j][i] =  Integer.toString(count1++);
                else{
                    matrix[j][i] =  Integer.toString(count2--);
                }
            }
        }
        return matrix;
    }
}
