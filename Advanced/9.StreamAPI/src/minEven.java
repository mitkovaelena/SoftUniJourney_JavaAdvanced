import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class minEven {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int sum = Arrays.stream(reader.readLine().split("\\s+"))
                .filter( x -> x.matches("^[-+]?\\d+$"))
                .mapToInt(Integer::parseInt)
                .sum();
        if(sum != 0){
            System.out.printf("%d", sum);
        }else {
            System.out.println("No match");
        }
    }
}
