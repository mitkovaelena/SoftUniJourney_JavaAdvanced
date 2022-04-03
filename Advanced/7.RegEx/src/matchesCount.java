import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class matchesCount {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String text = reader.readLine();

        Pattern pattern = Pattern.compile("[0-9]+");
        Matcher matcher = pattern.matcher(text);

        while(matcher.find()){
            System.out.println(matcher.group());
        }
    }
}

// \d -digits
// \w [a-zA-Z0-9_]
// \D - [^0-9]
// ".+"  jhkl"dfsf"dghjbsk " - cqloto do posledniq "   <-> ".+?"  sushtoto [^"]+
// \b - granica na duma
// (?= ...) positive look ahead
//(?<= ...) look behind
//(?<name>....) named group
//(?: ...) non-capturing group
//...(..)...\1 shte machne sushtiq string kato v purvata grupa

//v [] ne se escape-va