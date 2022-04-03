import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class semanticHTML {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();
        String text = "";
        while (!line.equals("END")) {
            text += line + "\n";
            line = reader.readLine();
        }

        Pattern openTagPattern = Pattern.compile("<(\\s*div).+?((id|class)\\s*=\\s*\"(main|header|nav|article|section|aside|footer)\")[^>]*>");
        Pattern closeTagPattern = Pattern.compile("<\\/\\s*(div\\s*>\\s*<\\!--\\s*(main|header|nav|article|section|aside|footer)\\s*--)>");
        Matcher openTagMatcher = openTagPattern.matcher(text);
        Matcher closeTagMatcher = closeTagPattern.matcher(text);

        ArrayDeque<String> stack = new ArrayDeque<>();
        boolean hasFound = true;

        while (hasFound){
            hasFound = false;
            if(openTagMatcher.find()) {
                hasFound = true;
                stack.push(openTagMatcher.group());
            }
            if(closeTagMatcher.find()){
                hasFound = true;
                String openTag = stack.peek();
                Matcher tempMatcher = openTagPattern.matcher(openTag);
                tempMatcher.find();
                if(closeTagMatcher.group(2).equals(tempMatcher.group(4))){
                    openTag = stack.pop();
                    String tagName = tempMatcher.group(4);
                    text = text.replace(closeTagMatcher.group(1), tagName);
                    text = text.replace(tempMatcher.group(1), tagName);
                    String asd = text;
                    String bsd = tempMatcher.group(2);
                    text = text.replace(" " + tempMatcher.group(2), "");
                }
            }
        }

        System.out.println(text.replaceAll("[ ]+", " ").trim());
    }
}
