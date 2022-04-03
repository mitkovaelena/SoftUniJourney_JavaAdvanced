import java.math.BigDecimal;
import java.util.Scanner;

public class euroTrip {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        double num1 = scanner.nextDouble();
        BigDecimal course = new BigDecimal("4210500000000");
        BigDecimal priceQuantity = new BigDecimal(num1*1.20);
        BigDecimal priceDM = course.multiply(priceQuantity);

        System.out.printf("%.2f marks", priceDM );

    }
}
