import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.regex.Pattern;

public class validUsernames2 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] text = reader.readLine().split("[ \\/\\\\(\\)]");
        ArrayDeque<String> usernames = new ArrayDeque<>();
        for(String t : text){
            if(isValid(t)) {
                usernames.offer(t);
            }
        }

        int maxLenght = Integer.MIN_VALUE;
        String maxLenUsernames = "";

        while (usernames.size()>1){
            String u1 = usernames.poll();
            String u2 = usernames.peek();

            if(u1.length()+u2.length()>maxLenght){
                maxLenght = u1.length()+u2.length();
                maxLenUsernames = u1 + "\n" + u2;
            }
        }
        System.out.println(maxLenUsernames);

    }
    public static boolean isValid(String line) throws IOException {
        String regex = "^[A-Za-z][\\w-]{2,25}$";
        if(Pattern.matches(regex, line)){
            return true;
        } else {
            return false;
        }
    }
}
