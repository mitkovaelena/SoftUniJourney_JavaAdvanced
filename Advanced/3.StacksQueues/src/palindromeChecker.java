import java.util.ArrayDeque;
import java.util.Scanner;

public class palindromeChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputStr = scanner.nextLine();
        ArrayDeque<Character> deque = new ArrayDeque<>();
        for (int i = 0; i < inputStr.length(); i++) {
            deque.add(inputStr.charAt(i));
        }
        while (deque.size()>1) {
            char first = deque.poll();
            char last = deque.pollLast();
            if(first != last){
                System.out.println("false");
                return;
            }
        }
        System.out.println("true");
    }
}
