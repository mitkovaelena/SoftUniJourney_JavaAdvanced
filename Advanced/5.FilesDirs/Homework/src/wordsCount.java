import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class wordsCount {
    public static void main(String[] args) {
        Path inTextPath = Paths.get(".\\06.input1.txt");
        Path inWordsPath = Paths.get(".\\06.input2.txt");
        Path outPath = Paths.get(".\\06.output1.txt");

        try {
            List<String> textLines = Files.readAllLines(inTextPath);
            List<String> wordsLines = Files.readAllLines(inWordsPath);
            HashMap<String, Integer> wordsCount = new HashMap<>();


            for(String line : wordsLines){
                for(String word : line.split(" ")){
                    int counter = 0;
                    for (String l : textLines){
                        for(String w : l.toLowerCase().split(" ")) {
                            if (w.equals(word.toLowerCase())) counter++;
                        }
                    }
                    wordsCount.put(word,counter);
                }
            }

            List<String> output = new LinkedList<>();
            wordsCount.entrySet().stream()
                    .sorted(Map.Entry.<String, Integer> comparingByValue().reversed())
                    .forEachOrdered(x -> output.add(x.getKey() + " - " +  x.getValue()));

            Files.write(outPath,output);

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
