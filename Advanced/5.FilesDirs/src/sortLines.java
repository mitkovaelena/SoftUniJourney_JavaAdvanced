import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class sortLines {
    public static void main(String[] args) {
        Path inPath = Paths.get(".\\input1.txt");
        Path outPath = Paths.get( ".\\output5.txt");

        try {
            List<String> lines = Files.readAllLines(inPath);
            Collections.sort(lines);
            Files.write(outPath,lines);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
