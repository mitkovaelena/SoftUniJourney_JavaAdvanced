import java.lang.reflect.Array;
import java.util.*;

public class Voina {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] playerOne  = scanner.nextLine().split(" ");
        String[] playerTwo  = scanner.nextLine().split(" ");
        LinkedHashSet<String> firstPlayer = new LinkedHashSet<>();
        LinkedHashSet<String> secondPlayer  = new LinkedHashSet<>();
        Collections.addAll(firstPlayer,playerOne);
        Collections.addAll(secondPlayer ,playerTwo);
        for (int i = 0; i < 50; i++) {
           if(firstPlayer.isEmpty() || secondPlayer .isEmpty()){
               break;
            }

            String firstNumber = firstPlayer.iterator().next(); // take next num
            firstPlayer.remove(firstNumber);

            String secondNumber = secondPlayer.iterator().next();
            secondPlayer.remove(secondNumber);

            if (Integer.parseInt(firstNumber) > Integer.parseInt(secondNumber)) {
                firstPlayer.add(firstNumber);
                firstPlayer.add(secondNumber);
            } else if (Integer.parseInt(firstNumber) < Integer.parseInt(secondNumber)){
                secondPlayer.add(firstNumber);
                secondPlayer.add(secondNumber);
            }

        }

        if(firstPlayer.size()>secondPlayer.size()){
            System.out.println("First player win!");
        }
        else if(firstPlayer.size()<secondPlayer.size()){
            System.out.println("Second player win!");
        }
    }
}
