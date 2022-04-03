import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class smallestElement {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split("\\s+");
        TreeMap<Integer, Integer> numbs = new TreeMap<>();

        for (int i = 0; i < input.length; i++) {
            numbs.put(Integer.parseInt(input[i]), i);
        }
        System.out.println(numbs.firstEntry().getValue());
    }
}
