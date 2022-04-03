import java.util.ArrayDeque;
import java.util.Scanner;

public class balancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputStr = scanner.nextLine();
        ArrayDeque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < inputStr.length(); i++) {
            if(inputStr.charAt(i) == ')'){
                if(stack.isEmpty() || stack.pop() != '('){
                    System.out.println("NO");
                    return;
                }
            }
            else if(inputStr.charAt(i) == ']'){
                if(stack.isEmpty() || stack.pop() != '['){
                    System.out.println("NO");
                    return;
                }
            }
            else if(inputStr.charAt(i) == '}'){
                if(stack.isEmpty() || stack.pop() != '{'){
                    System.out.println("NO");
                    return;
                }
            }
            else stack.push(inputStr.charAt(i));
        }

        if(!stack.isEmpty()){
            System.out.println("NO");
            return;
        }
        System.out.println("YES");

    }
}
