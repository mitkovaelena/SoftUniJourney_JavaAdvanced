import java.io.*;

public class sumLines {
    public static void main(String[] args) {
       final String inPath = ".\\01.input1.txt";
       //final String inPath = ".\\01.input2.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(inPath))) {
            String line = reader.readLine();

            while (line != null) {

                int sum = 0;
                for(char c : line.toCharArray()){
                  sum += (int)c;
                }
                System.out.println(sum);
                line = reader.readLine();
            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
