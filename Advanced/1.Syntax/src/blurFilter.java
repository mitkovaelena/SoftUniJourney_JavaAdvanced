import java.util.Scanner;

public class blurFilter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long blur = scanner.nextLong();
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        scanner.nextLine();
        String[][] matrix = new String[m][n];
        for (int i = 0; i < m; i++) {
            matrix[i]  = scanner.nextLine().split("[ ]+");
        }
        int y = scanner.nextInt();
        int x = scanner.nextInt();

        if(y<m && y>=0 && x<n && x>=0)matrix[y][x] = Long.toString(Long.parseLong(matrix[y][x]) + blur);
        if(y<m-1) matrix[y+1][x] = Long.toString(Long.parseLong(matrix[y+1][x]) + blur);
        if(y>=1) matrix[y-1][x] = Long.toString(Long.parseLong(matrix[y-1][x]) + blur);
        if(x<n-1) matrix[y][x+1] = Long.toString(Long.parseLong(matrix[y][x+1]) + blur);
        if(x>=1) matrix[y][x-1] = Long.toString(Long.parseLong(matrix[y][x-1]) + blur);
        if(y<m-1&& x<n-1) matrix[y+1][x+1] = Long.toString(Long.parseLong(matrix[y+1][x+1]) + blur);
        if(y>=1&& x<n-1) matrix[y-1][x+1] = Long.toString(Long.parseLong(matrix[y-1][x+1]) + blur);
        if(y>=1&& x>=1) matrix[y-1][x-1] = Long.toString(Long.parseLong(matrix[y-1][x-1]) + blur);
        if(y<m-1&& x>=1) matrix[y+1][x-1] = Long.toString(Long.parseLong(matrix[y+1][x-1]) + blur);

        for (int i = 0; i < m; i++) {
            System.out.println( String.join(" ", matrix[i]));
        }
    }
}
