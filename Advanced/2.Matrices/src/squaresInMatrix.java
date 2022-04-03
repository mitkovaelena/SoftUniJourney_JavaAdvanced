import java.util.Scanner;

public class squaresInMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] line = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(line[0]);
        int cols = Integer.parseInt(line[1]);
        String[][] matrix = new String[rows][cols];

        int squares = 0;

        for (int row = 0; row < matrix.length; row++) {
            String[] reminder = scanner.nextLine().split(" ");
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = reminder[col];
            }
        }
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if(row<matrix.length-1 && col <matrix[row].length-1){
                   if(matrix[row][col].equals(matrix[row][col+1]) && matrix[row][col].equals(matrix[row+1][col]) && matrix[row][col].equals(matrix[row+1][col+1])) {
                       squares++;
                   }
                }
            }
        }
        System.out.println(squares);
    }
}
