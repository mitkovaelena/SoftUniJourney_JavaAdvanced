import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.function.BiFunction;
import java.util.function.Function;

public class findEvenOdd {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] inputLine = reader.readLine().split("\\s+");
        Integer lowerBound = Integer.parseInt(inputLine[0]);
        Integer upperBound = Integer.parseInt(inputLine[1]);
        String type = reader.readLine();
        
        BiFunction<String, Integer, Integer> caseHandler = (x,y) -> {
            switch (x){
                case "even":
                    if(y%2==0) return y;
                    else return y+1;
                case "odd":
                    if(y%2==0) return y+1;
                    else return y;
            }
            return 0;
        };

        for (int i = caseHandler.apply(type,lowerBound); i <= upperBound; i+=2) {
            System.out.print(i + " ");
        }
    }
}
