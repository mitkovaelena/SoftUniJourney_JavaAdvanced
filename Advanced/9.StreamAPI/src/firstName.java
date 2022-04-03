import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class firstName {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> names = Arrays.asList(reader.readLine().split("\\s+"));
        String letters = reader.readLine();
        Optional<String> output = names.stream().sorted()
                .filter(x -> letters.toLowerCase().contains(x.substring(0,1).toLowerCase()))
                .limit(1)
                .findFirst();
        if (output.isPresent()){
            System.out.println(output.get());
        } else {
            System.out.println("No match");
        }
    }
}
