import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class extractInts {
    public static void main(String[] args) {
        String inPath = ".\\input1.txt";
        String outPath = ".\\output3.txt";

        try (Scanner scanner = new Scanner(new FileInputStream(inPath)); PrintWriter writer = new PrintWriter(outPath)) {
            while (scanner.hasNext()) {
                if(scanner.hasNextInt()) {
                    writer.println(scanner.nextInt());
                }
                scanner.next();
            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
