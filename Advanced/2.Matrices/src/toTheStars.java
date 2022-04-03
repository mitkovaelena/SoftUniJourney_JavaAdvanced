import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class toTheStars {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] starOne = reader.readLine().split(" ");
        String[] starTwo = reader.readLine().split(" ");
        String[] starThree = reader.readLine().split(" ");

        String[] initCoord = reader.readLine().split(" ");
        Double x = Double.parseDouble(initCoord[0]);
        Double y = Double.parseDouble(initCoord[1]);
        Double turns = Double.parseDouble(reader.readLine());

        for (int i = 0; i <= turns; i++) {
            if((x <= Double.parseDouble(starOne[1])+1 && x>= Double.parseDouble(starOne[1])-1)
                && (y<= Double.parseDouble(starOne[2])+1 && y>= Double.parseDouble(starOne[2])-1)){
                System.out.println(starOne[0].toLowerCase());
            }
            else if((x<= Double.parseDouble(starTwo[1])+1 && x>= Double.parseDouble(starTwo[1])-1)
                    && (y<= Double.parseDouble(starTwo[2])+1 && y>= Double.parseDouble(starTwo[2])-1)){
                System.out.println(starTwo[0].toLowerCase());
            }
            else  if((x<= Double.parseDouble(starThree[1])+1 && x>= Double.parseDouble(starThree[1])-1)
                    && (y<= Double.parseDouble(starThree[2])+1 && y>= Double.parseDouble(starThree[2])-1)){
                System.out.println(starThree[0].toLowerCase());
            }
            else {
                System.out.println("space");
            }
            y++;
        }
    }
}
