import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.HashSet;

public class countCharTypes {
    public static void main(String[] args) {
        final String inPath = ".\\04.input1.txt";
        final String outPath = ".\\04.output1.txt";

        HashSet vowelsSet = new HashSet();
        Collections.addAll(vowelsSet, 'a', 'e', 'i', 'o', 'u');
        HashSet punctuationSet = new HashSet();
        Collections.addAll(punctuationSet, ',', '.', '!', '?');

        try (BufferedReader reader = new BufferedReader(new FileReader(inPath));PrintWriter writer = new PrintWriter(outPath)) {
            String line = reader.readLine();

            int vowels = 0;
            int consonants = 0;
            int punctuation  = 0;

            while (line != null) {
                for(Character c : line.toCharArray()){
                    if(Character.isAlphabetic(c)) {
                        if (vowelsSet.contains(c)) vowels++;
                        else consonants++;
                    }
                    else if (punctuationSet.contains(c)) punctuation++;

                }

                line = reader.readLine();
            }

           writer.println("Vowels: " + vowels);
           writer.println("Consonants: " + consonants);
           writer.println("Punctuation: " + punctuation);


        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
