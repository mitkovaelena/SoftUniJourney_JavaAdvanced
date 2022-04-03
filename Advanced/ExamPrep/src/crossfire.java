import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class crossfire {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] dims = reader.readLine().split(" ");
        int rows = Integer.parseInt(dims[0]);
        int cols = Integer.parseInt(dims[1]);

        ArrayList<ArrayList<Integer>> matrix = new ArrayList<ArrayList<Integer>>();

        int count = 1;
        for (int i = 0; i < rows; i++) {
            matrix.add(new ArrayList<>());
            for (int j = 0; j < cols; j++) {
                matrix.get(i).add(count++);
            }
        }

        String[] command = reader.readLine().split(" ");
        while(!command[0].equals("Nuke")){
            int targetRow = Integer.parseInt(command[0]);
            int targetCol = Integer.parseInt(command[1]);
            int radius = Integer.parseInt(command[2]);

            for (int i = targetRow-radius; i <= targetRow+radius; i++) {
                if(i == targetRow) {
                    continue;
                }
                if(isInMatrix(matrix, i, targetCol)) {
                    matrix.get(i).remove(targetCol);
                }
            }

            for (int i = Math.max(targetCol-radius, 0); i <= targetCol+radius; i++) {
                if(isInMatrix(matrix, targetRow, Math.max(targetCol-radius, 0))) {
                    matrix.get(targetRow).remove(Math.max(targetCol-radius, 0));
                }
            }

            for (int i = 0; i < matrix.size(); i++) {
                if(matrix.get(i).isEmpty()) {
                    matrix.remove(i);
                    i--;
                }
            }

            command = reader.readLine().split(" ");
        }

        StringBuilder output = new StringBuilder("");
        for (ArrayList line : matrix) {
            for (int i = 0; i < line.size(); i++) {
                output.append(line.get(i) + " ");
            }
            output.append("\n");
        }
        System.out.println(output.toString());
    }

    private static boolean isInMatrix(ArrayList<ArrayList<Integer>> matrix, int row, int col) {
        return row >= 0 && row < matrix.size() && col>=0 && col < matrix.get(row).size();
    }
}
