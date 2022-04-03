import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class groupNums {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] nums = scanner.nextLine().split(", ");
        ArrayList<ArrayList<Integer>>  reminderTo3 = new ArrayList<ArrayList<Integer>>() {
        };
        reminderTo3.add(0, new ArrayList<Integer>());
        reminderTo3.add(1, new ArrayList<Integer>());
        reminderTo3.add(2, new ArrayList<Integer>());
        for (String num : nums) {
            reminderTo3.get(Math.abs(Integer.parseInt(num)%3)).add(Integer.parseInt(num));
        }

        for(ArrayList ind : reminderTo3){
            System.out.println(ind.stream().map(Object::toString)
                    .collect(Collectors.joining(" ")));
        }
    }
}