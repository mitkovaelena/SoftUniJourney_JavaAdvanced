import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class lineNumbers {
    public static void main(String[] args) {
        final String inPath = ".\\05.input1.txt";
        final String outPath = ".\\05.output1.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(inPath));PrintWriter writer = new PrintWriter(outPath)) {
            String line = reader.readLine();

            int counter = 0;

            while (line != null) {
                writer.print(++counter + ". ");
                writer.println(line);

                line = reader.readLine();
            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
