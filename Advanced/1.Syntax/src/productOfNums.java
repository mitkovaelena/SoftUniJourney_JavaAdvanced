import java.math.BigDecimal;
import java.util.Scanner;

public class productOfNums {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        BigDecimal product = new BigDecimal(1);
        int i = n;
        while (n<=m){
            product = product.multiply(new BigDecimal(n));
            n++;
        }
        System.out.printf("product[%s..%s] = %s",i,m, product);
    }
}
