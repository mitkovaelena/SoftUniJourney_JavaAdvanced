import java.util.Scanner;

public class MaxSumSubmatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] line = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(line[0]);
        int cols = Integer.parseInt(line[1]);
        int[][] matrix = new int[rows][cols];

        int maxSum = Integer.MIN_VALUE;
        int maxIndX = 0;
        int maxIndY = 0;

        for (int row = 0; row < matrix.length; row++) {
            String[] reminder = scanner.nextLine().split(" ");
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = Integer.parseInt(reminder[col]);
            }
        }
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if(row<matrix.length-1 && col <matrix[row].length-1 && row>=1 && col>=1){
                    int sum  = matrix[row-1][col-1] + matrix[row-1][col] + matrix[row-1][col+1]+matrix[row][col-1] +  matrix[row][col] + matrix[row][col+1] + matrix[row+1][col-1]+matrix[row+1][col]+matrix[row+1][col+1];
                    if(sum > maxSum){
                        maxSum = sum;
                        maxIndX = row;
                        maxIndY = col;
                    }
                }
            }
        }
        System.out.println("Sum = " + maxSum);
        System.out.printf("%d %d %d\n%d %d %d\n%d %d %d", matrix[maxIndX-1][maxIndY-1],matrix[maxIndX-1][maxIndY], matrix[maxIndX-1][maxIndY+1],matrix[maxIndX][maxIndY-1], matrix[maxIndX][maxIndY], matrix[maxIndX][maxIndY+1], matrix[maxIndX+1][maxIndY-1], matrix[maxIndX+1][maxIndY], matrix[maxIndX+1][maxIndY+1]);
    }
}
