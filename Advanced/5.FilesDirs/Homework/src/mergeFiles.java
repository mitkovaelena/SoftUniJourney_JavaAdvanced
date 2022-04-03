import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


public class mergeFiles {
    public static void main(String[] args) {
        Path inPath1 = Paths.get(".\\07.input1.txt");
        Path inPath2 = Paths.get(".\\07.input2.txt");
        Path outPath = Paths.get(".\\07.output1.txt");

        try {
            List<String> file1 = Files.readAllLines(inPath1);
            List<String> file2 = Files.readAllLines(inPath2);

            for(String s : file2){
                file1.add(s);
            }

            Files.write(outPath,file1);

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
