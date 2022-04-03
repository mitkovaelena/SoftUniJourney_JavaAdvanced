import java.util.ArrayDeque;
import java.util.Scanner;

public class ReverseStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] inputStr = scanner.nextLine().split(" ");
        ArrayDeque<String> stack = new ArrayDeque<>();
        for (int i = 0; i < inputStr.length; i++) {
            stack.push(inputStr[i]);
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop()+" ");
        }

    }
}
