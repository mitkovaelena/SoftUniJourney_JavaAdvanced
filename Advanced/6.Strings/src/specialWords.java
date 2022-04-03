import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.TreeMap;

public class specialWords {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] words = reader.readLine().split(" ");
        String[] text = reader.readLine().split(" ");
        HashMap<String, Integer> wordOcc = new HashMap<>();
        for (String w : words) {
            wordOcc.put(w, 0);
        }
        for (String w : words) {
            for (String t : text) {
                if(w.equals(t))
                wordOcc.put(w, wordOcc.get(w)+1);
            }
        }

        for(String s: wordOcc.keySet()){
            System.out.println(s + " - " + wordOcc.get(s));
        }
    }
}
