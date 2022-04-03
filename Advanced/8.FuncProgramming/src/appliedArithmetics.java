import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.Function;

public class appliedArithmetics {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split("\\s+");
        String command = reader.readLine();
        while (!command.equals("end")){
               switch (command){
                   case "add":
                       for (int i = 0; i < input.length; i++) {
                           input[i] = String.valueOf(Integer.parseInt(input[i])+1);
                       }
                       break;
                   case "multiply":
                       for (int i = 0; i < input.length; i++) {
                           input[i] = String.valueOf(Integer.parseInt(input[i])*2);
                       }
                       break;
                   case "subtract":
                       for (int i = 0; i < input.length; i++) {
                           input[i] = String.valueOf(Integer.parseInt(input[i])-1);
                       }
                       break;
                   case "print":
                       System.out.println(String.join(" ", input));;
                       break;
               }
               command = reader.readLine();
            }
    }
}
