import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public class stockSpanProblem {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Integer n = Integer.parseInt(reader.readLine());

        NavigableMap<Integer,Integer> numsSorted = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            Integer crntPrice = Integer.parseInt(reader.readLine());
            numsSorted.put(crntPrice, i);
            try {
                Map<Integer,Integer> tailMap  = numsSorted.tailMap(crntPrice);

                NavigableMap<Integer, Integer> sortedTailMap = new TreeMap<>();
                tailMap.entrySet().stream()
                        .forEachOrdered(x -> sortedTailMap.put(x.getValue(), x.getKey()));
                Integer ind = sortedTailMap.pollLastEntry().getKey();
                ind = sortedTailMap.pollLastEntry().getKey();

                System.out.println(i-ind);
            } catch (Exception e){
                System.out.println(i+1);
            }

        }

    }
}
