import java.util.Scanner;

public class transportPrice {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        double km = scanner.nextDouble();
        String time = scanner.next();
        double price = 0;
        if (km < 20)
        {
            if (time.equals("day"))
            {
                price = 0.7 + (km * 0.79);
            }
            else if (time.equals("night"))
            {
                price = 0.7 + (km * 0.9);
            }
        }
        if (km < 100 && km >= 20)
        {
            price = km * 0.09;
        }
        if (km >= 100)
        {
            price = km * 0.06;
        }
        System.out.printf("%.2f", price);
    }
}
