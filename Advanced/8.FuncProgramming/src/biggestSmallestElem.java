import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class biggestSmallestElem {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] intArr = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        String command = reader.readLine();
        ArrayList<Integer> numbs = new ArrayList();

        for(Integer i : intArr){
            numbs.add(i);
        }

        numbs.sort((a,b) -> a-b);

        try {
            switch (command) {
                case "minEven":
                    numbs.removeIf(n -> n % 2 != 0);
                    System.out.println(numbs.get(0));
                    return;
                case "maxEven":
                    numbs.removeIf(n -> n % 2 != 0);
                    System.out.println(numbs.get(numbs.size() - 1));
                    return;
                case "minOdd":
                    numbs.removeIf(n -> n % 2 == 0);
                    System.out.println(numbs.get(0));
                    return;
                case "maxOdd":
                    numbs.removeIf(n -> n % 2 == 0);
                    System.out.println(numbs.get(numbs.size() - 1));
                    return;
            }
        }catch (Exception e){
            return;
        }

    }
}
