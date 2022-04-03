import java.util.Scanner;

public class expression {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        double num1 = scanner.nextDouble();
        double num2 = scanner.nextDouble();
        double num3 = scanner.nextDouble();

        double f1 = Math.pow((num1*num1 + num2*num2)/(num1*num1 - num2*num2), (num1+num2+num3)/(Math.sqrt(num3)) );
        double f2 = Math.pow((num1*num1 + num2*num2 - Math.pow(num3, 3)),(num1-num2));
        double diff = Math.abs(((num1+num2+num3)/3)-((f1+f2)/2));
        System.out.printf("F1 result: %.2f; F2 result: %.2f; Diff: %.2f", f1, f2, diff);
    }
}
