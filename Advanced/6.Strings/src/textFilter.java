import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class textFilter {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] words = reader.readLine().split(", ");
        String text = (reader.readLine());

        for(String w : words){
           text =  text.replaceAll(w, new String(new char[w.length()]).replace("\0", "*"));
        }

        System.out.println(text);
    }
}
