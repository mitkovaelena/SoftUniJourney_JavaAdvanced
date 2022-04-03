import java.util.Arrays;
import java.util.Scanner;

public class matrixPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] line = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(line[0]);
        int cols = Integer.parseInt(line[1]);
        String[][] matrix = new String[rows][cols];
        char a = 'a';
        a--;
        for (int i = 0; i < matrix.length; i++) {
            a++;
            for (int j = 0; j < matrix[0].length; j++) {
                String palindrome =  Character.toString(a) + Character.toString((char)(a+j)) + Character.toString(a);
               matrix[i][j] = palindrome;
            }
        }

        for(String[] l : matrix){
            System.out.println(String.join(" ", l));
        }
    }
}
