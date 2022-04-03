import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

public class take2 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] intArr = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        IntStream.of(intArr).distinct()  //unique
                .filter(x -> x >= 10 && x<=20)
                .limit(2)
                .forEach(x -> System.out.print(x + " "));
    }
}
