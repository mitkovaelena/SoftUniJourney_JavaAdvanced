import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class validTime {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();

        String regex = "^(0[1-9]|1[12]):([0-5][0-9]):([0-5][0-9]) [AP]M$";

        while(!line.equals("END")){
            if(Pattern.matches(regex, line)){
                System.out.println("valid");
            } else {
                System.out.println("invalid");
            }

            line = reader.readLine();
        }
    }

    public static void secondSolution(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();

        Pattern pattern = Pattern.compile("^(\\d{2}):(\\d{2}):(\\d{2}) [AP]M$");

        while(!line.equals("END")){
            Matcher matcher = pattern.matcher(line);

            if (matcher.find()){
                int hour = Integer.parseInt(matcher.group(1));
                int minutes = Integer.parseInt(matcher.group(2));
                int secs = Integer.parseInt(matcher.group(3));

                if (hour >= 1 && hour <=12 && minutes >= 1 && minutes <=59 && secs >= 1 && secs <=59){
                    System.out.println("valid");
                }else {
                    System.out.println("invalid");
                }

            }else {
                System.out.println("invalid");
            }

            line = reader.readLine();
        }
    }
}
