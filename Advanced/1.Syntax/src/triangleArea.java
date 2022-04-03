import java.util.Scanner;

public class triangleArea {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        double num1 = scanner.nextDouble();
        double num2 = scanner.nextDouble();

        System.out.printf("Area = %.2f",area(num1,num2));

    }

    public static double area(double base, double height){
        return base*height/2;
    }
}
