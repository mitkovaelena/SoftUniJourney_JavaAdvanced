import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Scanner;

public class base10ToBaseN {
        public static void main(String[] args) throws IOException {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String[] line = reader.readLine().split(" ");
            BigInteger n = new BigInteger(line[0]);
            BigInteger num = new BigInteger(line[1]);
            StringBuilder sb = new StringBuilder();

            while(num.divide(n).compareTo(new BigInteger("0"))>0){
                sb.append(num.divideAndRemainder(n)[1]);
                num = num.divide(n);
            }
            sb.append(num);
            System.out.println(sb.reverse());
        }

}
