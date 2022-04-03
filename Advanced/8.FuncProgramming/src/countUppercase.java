import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Predicate;

public class countUppercase {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split(" ");

        Predicate<String> isUppercase = x -> x.toUpperCase().charAt(0) == x.charAt(0);

        int count = 0;
        String output = "";
        for(String s : input){
            if(isUppercase.test(s)){
                count++;
                output += s +"\n";
            }
        }
        System.out.println(count);
        System.out.println(output);
    }
}
