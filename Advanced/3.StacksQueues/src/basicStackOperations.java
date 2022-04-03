import java.util.ArrayDeque;
import java.util.Scanner;

public class basicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] inputStr = scanner.nextLine().split(" ");
        String[] inputStack = scanner.nextLine().split(" ");
        ArrayDeque<String> stack = new ArrayDeque<>();
        for (int i = 0; i < Integer.parseInt(inputStr[0]); i++) {
            stack.push(inputStack[i]);
        }
        for (int i = 0; i < Integer.parseInt(inputStr[1]); i++) {
            stack.pop();
        }

        int minElement = Integer.MAX_VALUE;
        while (!stack.isEmpty()) {
            String popped = stack.pop();
            if(popped.equals(inputStr[2])){
                System.out.println("true");
                return;
            }
            else if(minElement>Integer.parseInt(popped)){
                minElement=Integer.parseInt(popped);
            }
        }
        System.out.println(minElement == Integer.MAX_VALUE ? 0 : minElement);
    }
}
