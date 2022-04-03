import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class terroristsWin {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String text = reader.readLine();

        while (true) {
            Integer ind1 = text.indexOf('|');
            if(ind1 == -1) break;
            Integer ind2 = text.indexOf('|', ind1+1);
            if(ind2 == -1) break;
            Integer power = 0;
          for(Character ch : text.substring(ind1+1,ind2).toCharArray()){
                power += (int) ch;
          }
          power %= 10;
            Integer startInd = Math.max(ind1-power, 0);
            Integer endInd = Math.min(ind2+power+1, text.length());

            text = text.substring(0, startInd) + new String(new char[endInd-startInd]).replace("\0", ".") + text.substring(endInd);
        }
        System.out.println(String.join("", text));
    }
}
