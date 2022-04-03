import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class unicodeChars {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        char[] words = reader.readLine().toCharArray();
        for(char w : words)
            System.out.print(String.format("\\u%04x", (int) w));
    }
}
