import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;

public class extractTags {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        String text = "";
        while(!line.equals("END")){
            text += line;
            line = scanner.nextLine();
        }

        Pattern pattern = Pattern.compile("<.+?>");
        Matcher matcher = pattern.matcher(text);

        while(matcher.find()){
            System.out.println(matcher.group());  
        }
    }
}