import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class maxElement {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int commandsNum = scanner.nextInt();
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int maxEl = Integer.MIN_VALUE;
        for (int i = 0; i <= commandsNum; i++) {
            String[] command = scanner.nextLine().split(" ");
            switch (command[0]){
                case "1": stack.push(Integer.parseInt(command[1]));
                    if(maxEl< Integer.parseInt(command[1]) )
                        maxEl = Integer.parseInt(command[1]);
                    break;
                case "2": int poppedEl = stack.pop();
                    if(maxEl == poppedEl )
                        maxEl = MaxElement(stack);
                    break;
                case "3":
                    System.out.println(maxEl);
                    break;
            }
        }
    }

    private static int MaxElement(ArrayDeque<Integer> stack) {
        int maxElement = Integer.MIN_VALUE;
        Integer[] tempArr = new Integer[stack.size()];
        int i = 0;
        while (!stack.isEmpty()) {
            tempArr[i++] = stack.pop();
        }
        Collections.addAll(stack, tempArr);
        Arrays.sort(tempArr);
        return tempArr[tempArr.length-1];
    }
}
