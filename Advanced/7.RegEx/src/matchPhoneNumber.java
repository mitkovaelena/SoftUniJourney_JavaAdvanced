import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class matchPhoneNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String text = reader.readLine();
        while (!text.equals("end")) {
            String regex = "^\\+359(-| )2\\1\\d{3}\\1\\d{4}$";

            if (Pattern.matches(regex,text)) {
                System.out.println(text);
            }
            text = reader.readLine();
        }
    }
}
