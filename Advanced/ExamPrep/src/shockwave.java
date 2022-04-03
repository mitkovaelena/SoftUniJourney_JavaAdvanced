import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class shockwave {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] dims = reader.readLine().split(" ");
        int rows = Integer.parseInt(dims[0]);
        int cols = Integer.parseInt(dims[1]);

        Integer[][] matrix = new Integer[rows][cols];

        for (int i = 0; i < rows; i++) {
            matrix[i] = new Integer[cols];
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = 0;
            }
        }

        String[] command = reader.readLine().split(" ");
        while(!command[0].equals("Here")){
            int startRow = Integer.parseInt(command[0]);
            int startCol = Integer.parseInt(command[1]);
            int endRow = Integer.parseInt(command[2]);
            int endCol = Integer.parseInt(command[3]);

            for (int i = startRow; i <= endRow; i++) {
                for (int j = startCol; j <= endCol; j++) {
                    try{
                        matrix[i][j] = matrix[i][j]+1;
                    }catch (Exception e){
                        continue;
                    }
                }
            }
            command = reader.readLine().split(" ");
        }

        StringBuilder output = new StringBuilder("");
        for (Integer[] line : matrix) {
            for (int i = 0; i < line.length; i++) {
                output.append(line[i] + " ");
            }
            output.append("\n");
        }
        System.out.println(output.toString());
    }
}
