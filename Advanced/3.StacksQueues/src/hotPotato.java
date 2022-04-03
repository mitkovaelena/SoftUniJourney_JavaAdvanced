import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class hotPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] tokens = scanner.nextLine().split("\\s+");
        int n = scanner.nextInt();
        ArrayDeque<String> queue = new ArrayDeque<>();
        Collections.addAll(queue, tokens );
        int i = 1;
        int count = 1;
        while (queue.size()>1){
            if(i == n){
                i=1;
                if(isPrime(count)) {
                    System.out.println("Prime " + queue.peek());
                    count++;
                }
                else {
                    System.out.println("Removed " + queue.poll());
                    count++;
                }
            }
            else {
                i++;
                String temp = queue.poll();
                queue.offer(temp);
            }
        }
        System.out.println("Last is " + queue.poll());
    }

    public static boolean isPrime(int n) {
        if(n <=1){
            return false;
        }

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if(n%i == 0 && n != i) return false;
        }
        return true;
    }
}
