import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class boundedNums {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> boundries = Stream.of(reader.readLine().split("\\s+")).map(Integer::valueOf).sorted().collect(Collectors.toList());
        Stream.of(reader.readLine().split("\\s+")).map(Integer::valueOf)
                .filter(x -> x >= boundries.get(0) && x <= boundries.get(1))
                .forEach(y -> System.out.print(y + " "));
    }
}
