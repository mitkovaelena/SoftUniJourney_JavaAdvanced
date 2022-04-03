import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class sumNums {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split("\\s*,\\s*");

        Function<String, Integer> parser = x -> Integer.parseInt(x);

        int sum = 0;

        for(String i : input){
            sum += parser.apply(i);
        }
        System.out.println("Count = " + input.length);
        System.out.println("Sum = " + sum);
    }
}
