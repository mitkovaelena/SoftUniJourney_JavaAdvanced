import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class averageOfDoubles {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.printf("%.2f", Arrays.stream(reader.readLine().split("\\s+"))
                    .filter(x -> !x.isEmpty())
                    .mapToDouble(Double::parseDouble)
                    .average().getAsDouble()
            );
        }catch (Exception e){
            System.out.println("No match");
        }
    }
}
