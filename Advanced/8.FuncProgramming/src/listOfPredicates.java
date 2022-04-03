import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class listOfPredicates {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Integer upperBound = Integer.parseInt(reader.readLine());
        int[] intArr = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        BiPredicate<Integer, Integer> isDivisible = (n, d) -> n % d == 0;

        for (int i = 1; i <= upperBound; i++) {
            boolean isNotDiv = false;
            for(Integer num : intArr){
                if(!isDivisible.test(i,num)){
                    isNotDiv = true;
                    break;
                }
            }
            if(!isNotDiv){
                System.out.print(i + " ");
            }
        }
    }
}
