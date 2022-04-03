import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class sentenceExtractor {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String literal = reader.readLine();
        literal = " " + literal + " ";
        String text = reader.readLine();
        String patternStr = "[A-Z][^!.?]*[.!?]";
        Pattern pattern = Pattern.compile(patternStr);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            String m = matcher.group(0);
            if(m.indexOf(literal)>=0) {
                int ind = m.indexOf(literal);
                System.out.println(matcher.group(0));
            }
        }
    }
}
