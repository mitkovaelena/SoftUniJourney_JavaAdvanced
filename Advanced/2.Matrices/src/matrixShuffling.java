import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class matrixShuffling {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] inputLine = reader.readLine().split(" ");
        Integer y = Integer.parseInt(inputLine[0]);
        Integer x = Integer.parseInt(inputLine[1]);


        String[][] matrix = new String [y][];

        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = reader.readLine().split(" ");
        }
        inputLine = reader.readLine().split(" ");
        while (!inputLine[0].equals("END")){
            if (inputLine.length != 5 || !inputLine[0].equals("swap")) {
                System.out.println("Invalid input!");
                inputLine = reader.readLine().split(" ");
                continue;
            }
                try {
                    String temp = matrix[Integer.parseInt(inputLine[3])][Integer.parseInt(inputLine[4])];
                    matrix[Integer.parseInt(inputLine[3])][Integer.parseInt(inputLine[4])] = matrix[Integer.parseInt(inputLine[1])][Integer.parseInt(inputLine[2])];
                    matrix[Integer.parseInt(inputLine[1])][Integer.parseInt(inputLine[2])] = temp;

                    for(String[] l : matrix){
                        System.out.println(String.join(" ", l));
                    }

                }catch (Exception e){
                    System.out.println("Invalid input!");
                }
                inputLine = reader.readLine().split(" ");
            }
        }
    }