import java.util.Scanner;

public class formattingNums {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Integer num1 = scanner.nextInt();
        Double num2 = scanner.nextDouble();
        Double num3 = scanner.nextDouble();

        String formatted = ("0000000000" + Integer.toString(num1,2)).substring( Integer.toString(num1,2).length());

        System.out.printf("|%-10X|%s|%10.2f|%-10.3f|", num1, formatted ,num2,num3);

    }
}
