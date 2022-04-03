import java.util.Scanner;

public class greeting {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String word1 = scanner.nextLine();
        String word2 = scanner.nextLine();

        if(word1.isEmpty()) word1 = "*****";
        if(word2.isEmpty()) word2 = "*****";

        System.out.println("Hello, " + word1 + " " + word2 + "!");

    }
}
