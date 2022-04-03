import java.util.Scanner;

public class gameOfNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int players = scanner.nextInt();
        String winner = "";
        int winnerScore = Integer.MIN_VALUE;
        for (int i = 0; i < players; i++) {
            String playerName = scanner.next();
            int playerScore = scanner.nextInt();
            for (int j = 0; j < playerName.length(); j++) {
                if((int)playerName.charAt(j) % 2 == 0)
                    playerScore +=  (int)playerName.charAt(j);
                else
                    playerScore -=  (int)playerName.charAt(j);
            }
            if(winnerScore < playerScore){
                winnerScore = playerScore;
                winner = playerName;
            }
        }
        System.out.printf("The winner is %s - %d points",winner,winnerScore);
    }
}
