import java.util.Scanner;

public class desimalToBase7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num1 = scanner.nextInt();

        System.out.println(Integer.toString(num1,7));
    }
}
