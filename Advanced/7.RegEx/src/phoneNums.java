import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class phoneNums {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();
        String text = "";
        while(!line.equals("END")){
            text += line;
            line = reader.readLine();
        }

        String patternStr = "([A-Z][a-zA-Z]*)[^A-Za-z\\+\\d]*(\\+?\\d[\\d\\(\\)\\/,\\.\\- ]*\\d)";
        Pattern pattern = Pattern.compile(patternStr);
        Matcher matcher = pattern.matcher(text);

        if(matcher.find()) {
            System.out.print("<ol>");
            do{
                String m = matcher.group(2).replaceAll("[\\(\\)\\/,\\.\\- ]", "");
                System.out.print("<li><b>" + matcher.group(1) + ":</b> " + m + "</li>");
            }while (matcher.find());
            System.out.print("</ol>");
        }else {
            System.out.print("<p>No matches!</p>");
        }
    }
}
