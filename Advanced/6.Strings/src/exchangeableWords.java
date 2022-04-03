import java.util.HashMap;
import java.util.Scanner;

public class exchangeableWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String  word1 = scanner.next();
        String word2 = scanner.next();

        HashMap<Character,Character> keyPairs1 = new HashMap<>();
        HashMap<Character,Character> keyPairs2 = new HashMap<>();

        for (int i = 0; i < Math.min(word1.length(),word2.length()); i++) {
            if(keyPairs1.containsKey(word1.charAt(i))){
                if(!keyPairs1.get(word1.charAt(i)).equals(word2.charAt(i))) {
                    System.out.println("false");
                    return;
                }
            }
            else{
                keyPairs1.put(word1.charAt(i),word2.charAt(i));
            }

            if(keyPairs2.containsKey(word2.charAt(i))){
                if(!keyPairs2.get(word2.charAt(i)).equals(word1.charAt(i))) {
                    System.out.println("false");
                    return;
                }
            }
            else{
                keyPairs2.put(word2.charAt(i),word1.charAt(i));
            }
        }

        for (Character w : word1.toCharArray()){
            if(!keyPairs1.containsKey(w)){
                System.out.println("false");
                return;
            }
        }
        for (Character w : word2.toCharArray()){
            if(!keyPairs2.containsKey(w)){
                System.out.println("false");
                return;
            }
        }


        System.out.println("true");
    }
}
