import java.util.Scanner;

public class charMultiplier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String  word1 = scanner.next();
        String word2 = scanner.next();
        int sum = 0;
        for (int i = 0; i < Math.max(word1.length(),word2.length()); i++) {
          sum += (int) (word1.length()>i?word1.charAt(i):1) * (int) (word2.length()>i?word2.charAt(i):1);
        }
        System.out.println(sum);
    }
}
