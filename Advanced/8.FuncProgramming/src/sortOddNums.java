import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class sortOddNums {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split("\\s+");
        Integer i = Integer.parseInt(reader.readLine());
        List<Integer> nums = new ArrayList<>();

        for(int j = input.length-1; j>=0; j--){
            nums.add(Integer.parseInt(input[j]));
        }
        nums.removeIf(n -> n % i == 0);

        System.out.println(nums.toString().replaceAll("\\[|\\]", "").replaceAll(",", ""));
    }
}
