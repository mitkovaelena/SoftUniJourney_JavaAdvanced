import java.util.Scanner;

public class ReadInput {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String word1 = scanner.next();
        String word2 = scanner.next();
        int num1 = scanner.nextInt();
        double num2 = scanner.nextDouble();
        double num3 = scanner.nextDouble();
        String word3 = scanner.next();

        int sum = (int) (num1+num2+num3);

        System.out.println(word1 + " " + word2 + " " + word3 + " " + sum);

    }
}
