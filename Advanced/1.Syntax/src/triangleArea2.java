import java.util.Scanner;

public class triangleArea2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int x1 = scanner.nextInt();
        int y1 = scanner.nextInt();
        int x2 = scanner.nextInt();
        int y2 = scanner.nextInt();
        int x3 = scanner.nextInt();
        int y3 = scanner.nextInt();

        System.out.printf("%d",area(x1,y1,x2,y2,x3,y3));

    }

    public static int area(int x1,int y1,int x2,int y2,int x3,int y3){
        return (int) Math.abs((x1*(y2-y3)+x2*(y3-y1)+x3*(y1-y2))/2);
    }
}
