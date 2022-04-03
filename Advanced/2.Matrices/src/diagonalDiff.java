import java.util.Scanner;

public class diagonalDiff {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        int[][] matrix = new int[n][n];

        int dia1 = 0;
        int dia2 = 0;

        for (int row = 0; row < matrix.length; row++) {
            String[] reminder = scanner.nextLine().split(" ");
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = Integer.parseInt(reminder[col]);
            }
            dia1 += Integer.parseInt(reminder[row]);
            dia2 += Integer.parseInt(reminder[reminder.length-1-row]);
        }

        System.out.println(Math.abs(dia1-dia2));

    }
}
