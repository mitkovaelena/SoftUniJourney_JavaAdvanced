import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class lettersCount {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] words = reader.readLine().split("\\s+");
        double sum = 0;
        for(String w : words){
            Character letter1 = w.charAt(0);
            Character letter2 = w.charAt(w.length()-1);
            double num = Double.parseDouble(w.substring(1,w.length()-1));

            if(Character.isUpperCase(letter1)){
                num /= ((int)letter1-(int)'A'+1);
            }
            else{
                num *= (int)letter1-(int)'a'+1;
            }
            if(Character.isUpperCase(letter2)){
                num -= (int)letter2-(int)'A'+1;
            }
            else{
                num += (int)letter2-(int)'a'+1;
            }

            sum+=num;
        }
        System.out.printf("%.2f",sum);
    }
}
