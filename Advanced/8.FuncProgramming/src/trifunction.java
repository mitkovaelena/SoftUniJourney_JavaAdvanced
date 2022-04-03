import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class trifunction {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Integer n = Integer.parseInt(reader.readLine());
        String[] input = reader.readLine().split("\\s+");

        for(String s : input){
            int sum = 0;
            for(Character ch : s.toCharArray()){
                sum += (int) ch;
            }
            if(sum >= n){
                System.out.println(s);
                return;
            }
        }
    }
}
