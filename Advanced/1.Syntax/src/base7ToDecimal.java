import java.util.Scanner;

public class base7ToDecimal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] str = scanner.next().toCharArray();
        int v = 0;
        int total = 0;
        int pow = 0;
        for(int i = str.length-1; i > -1; i--){
            char c = str[i];
            if (c >= '0' && c <= '9') {
                v = c - '0';
            }
            total += v * Math.pow(7,pow);
            pow++;
        }
        System.out.println(total);
    }
}
