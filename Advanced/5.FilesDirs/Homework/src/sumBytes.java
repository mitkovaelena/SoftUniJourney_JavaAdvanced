import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class sumBytes {
    public static void main(String[] args) {
        final String inPath = ".\\01.input1.txt";
       //final String inPath = ".\\01.input2.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(inPath))) {
            String line = reader.readLine();
            int sum = 0;
            while (line != null) {
                for(char c : line.toCharArray()){
                  sum += (int)c;
                }
                line = reader.readLine();
            }
            System.out.println(sum);

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
