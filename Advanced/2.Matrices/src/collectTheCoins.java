import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class collectTheCoins {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[][] board = new String [4][];
        board[0] = reader.readLine().split("");
        board[1] = reader.readLine().split("");
        board[2] = reader.readLine().split("");
        board[3] = reader.readLine().split("");

        String[] commands = reader.readLine().split("");

        Integer coins = 0;
        Integer hits = 0;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                String[] strings = board[j];
                
            }
        }

        Integer x = 0;
        Integer y = 0;
       for(String command : commands){
           switch (command){
               case"V":
                   try {
                   if(board[y+1][x].equals("$")){
                       coins++;
                       board[y+1][x] = "a";
                   }
                       y += 1;
                   }catch (ArrayIndexOutOfBoundsException e){
                       hits++;
                   }
                   break;
               case">":
                   try {
                       if(board[y][x+1].equals("$")){
                           coins++;
                           board[y][x+1] = "a";
                       }
                       x += 1;
                   }catch (ArrayIndexOutOfBoundsException e){
                       hits++;
                   }
                   break;
               case"^":
                   try {
                       if(board[y-1][x].equals("$")){
                           coins++;
                           board[y-1][x] = "a";
                       }
                       y -= 1;
                   }catch (ArrayIndexOutOfBoundsException e){
                       hits++;
                   }
                   break;
               case"<":
                   try {
                       if(board[y][x-1].equals("$")){
                           coins++;
                           board[y][x-1] = "a";
                       }
                       x -= 1;
                   }catch (ArrayIndexOutOfBoundsException e){
                       hits++;
                   }
                   break;
           }
       }
        System.out.printf("Coins = %d%nWalls = %d", coins,hits);
    }
}
