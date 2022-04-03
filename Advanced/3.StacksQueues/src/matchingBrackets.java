import java.util.ArrayDeque;
import java.util.Scanner;

public class matchingBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputStr = scanner.nextLine();
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < inputStr.length(); i++) {
            if(inputStr.charAt(i) == '(') {
                stack.push(i);
            }
            if(inputStr.charAt(i) == ')'){
                Integer firstInd = stack.pop();
                System.out.println(inputStr.substring(firstInd,i+1));
            }
        }
    }
}
