import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class allCapitals {
    public static void main(String[] args) {
        final String inPath = ".\\01.input1.txt";
        //final String inPath = ".\\03.input2.txt";

        final String outPath = ".\\03.output1.txt";
        //final String outPath = ".\\03.output2.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(inPath)); PrintWriter writer = new PrintWriter(outPath)) {
            String line = reader.readLine();

            while (line != null) {
                writer.println(line.toUpperCase());
                line = reader.readLine();
            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
