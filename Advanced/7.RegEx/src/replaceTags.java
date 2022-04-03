import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class replaceTags {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();
        String text = "";
        while (!line.equals("END")) {
            text += line + "\n";
            line = reader.readLine();
        }
        Pattern pattern = Pattern.compile("<a\\s+(href=[^>]+)>([^<]+)<\\/a>");
        Matcher matcher = pattern.matcher(text);
        text = matcher.replaceAll("[URL $1]$2[/URL]");

        System.out.println(text);
    }
}
