import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class matchFullName {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String text = reader.readLine();
        while (!text.equals("end")) {
            String regex = "^[A-Z][a-z]{1,} [A-Z][a-z]{1,}$";

            if (Pattern.matches(regex,text)) {
                System.out.println(text);
            }
            text = reader.readLine();
        }
    }
}
