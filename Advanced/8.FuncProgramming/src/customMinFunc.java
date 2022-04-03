import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Function;

public class customMinFunc {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        ArrayList<Integer> numbs = new ArrayList();
        ArrayList<Integer> odd = new ArrayList();

        Function<Integer, Boolean> parser = x -> numbs.add(x);

        for(Integer i : input){
            parser.apply(i);
        }
        numbs.sort((a,b)->a-b);
        numbs.forEach(a->{
            if(a % 2 != 0)
                odd.add(a);
        });
        numbs.removeIf(a -> a % 2 != 0);
        odd.forEach(a->{
            if(a % 2 != 0)
            numbs.add(a);
        });
        System.out.println(numbs.toString().replaceAll("\\[|\\]", "").replaceAll(",", ""));
    }
}
