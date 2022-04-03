import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeMap;

public class sameVals {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] inputLine = scanner.nextLine().toCharArray();
        TreeMap<Character, Integer> result = new TreeMap<>();

        for (char el : inputLine){
            result.put(el, result.containsKey(el)?result.get(el)+1:1);
        }

        for (Character key : result.keySet()) {
            System.out.println(key + ": " + result.get(key) + " time/s");
        }
    }
}
