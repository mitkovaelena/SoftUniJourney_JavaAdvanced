import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class formattingNums {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        Integer num1 = scanner.nextInt();
        Double num2 = scanner.nextDouble();
        Double num3 = scanner.nextDouble();

        String formatted = Integer.toString(num1,2);
        while (formatted.length() < 10){
            formatted = "0" + formatted;
        }
        if(formatted.length()>10){
            formatted = formatted.substring(0,10);
        }

        System.out.printf("|%-10X|%s|%10.2f|%-10.3f|", num1, formatted ,num2,num3);
    }
}
