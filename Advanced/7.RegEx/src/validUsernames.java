import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class validUsernames {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();

        String regex = "^[\\w-]{3,16}$";

        while(!line.equals("END")){
            if(Pattern.matches(regex, line)){
                System.out.println("valid");
            } else {
                System.out.println("invalid");
            }

            line = reader.readLine();
        }
    }
}
