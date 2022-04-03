import java.util.ArrayDeque;
import java.util.Locale;
import java.util.Scanner;

public class recursiveFibbonacci {
    public static void main(String[] args) {

    Locale.setDefault(Locale.ROOT);
    Scanner scanner = new Scanner(System.in);
    ArrayDeque<Long> fibbonacci = new ArrayDeque<>();

    int n = scanner.nextInt();

        if(n==0) {
        System.out.println("1");
        return;
    }
        fibbonacci.push(1L);
        fibbonacci.push(1L);
        System.out.println(fibonacci(fibbonacci,n));
}


    private static long fibonacci(ArrayDeque<Long> deque, int num){


        if(deque.size()==num+1){
            return deque.pop();
        }
        long a= deque.pop();
        long b= deque.pop();
        deque.push(b);
        deque.push(a);
        deque.push(a+b);
        return fibonacci(deque,num);

    }
}

