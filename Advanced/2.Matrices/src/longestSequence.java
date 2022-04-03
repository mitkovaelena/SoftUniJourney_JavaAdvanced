import java.util.Scanner;

public class longestSequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] line = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(line[0]);
        int cols = Integer.parseInt(line[1]);
        String[][] matrix = new String[rows][cols];

        int maxLen = 0;
        String element = "";

        for (int row = 0; row < matrix.length; row++) {
            String[] reminder = scanner.nextLine().split(" ");
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = reminder[col];
            }
        }

        for (int row = 0; row < matrix.length; row++) {
            int currLen = 1;
            for (int col = 0; col < matrix[row].length-1; col++) {
                if(matrix[row][col].equals(matrix[row][col+1])){
                    currLen++;
                    if(col == matrix[row].length-2){
                        if(currLen>=maxLen){
                            maxLen = currLen;
                            element = matrix[row][col];
                            currLen = 1;
                        }
                    }
                }
                else{
                    if(currLen>=maxLen){
                        maxLen = currLen;
                        currLen = 1;
                    }
                }
            }
        }

        for (int row = 0; row < matrix.length; row++) {
            int currLen = 1;
            for (int col = 0; col < matrix[row].length - 1; col++) {
                if (matrix[col][row].equals(matrix[col+1][row])) {
                    currLen++;
                    if(col == matrix[row].length-2){
                        if(currLen>=maxLen){
                            maxLen = currLen;
                            element = matrix[col][row];
                            currLen = 1;
                        }
                    }
                } else {
                    if (currLen >= maxLen) {
                        maxLen = currLen;
                        element = matrix[col][row];
                        currLen = 1;
                    }
                }
            }
        }

        int currLen = 1;
        for (int row = 0; row < Math.min(matrix.length-1,matrix[0].length-1); row++) {
                if(matrix[row][row].equals(matrix[row+1][row+1])){
                    currLen++;
                    if(row == matrix[row].length-2){
                        if(currLen>=maxLen){
                            maxLen = currLen;
                            element = matrix[row][row];
                            currLen = 1;
                        }
                    }
                }
                else{
                    if(currLen>=maxLen){
                        maxLen = currLen;
                        element = matrix[row][row];
                        currLen = 1;
                    }
                }
        }

        for (int i = 0; i < maxLen; i++) {
                System.out.printf(element + ", ");
        }
    }
}
