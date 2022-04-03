import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class baseNtoBase10 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] line = reader.readLine().split(" ");
        BigInteger n = new BigInteger(line[0]);
        String[] num = line[1].split("");
        BigInteger sum = new BigInteger("0");
        for (int i = 0; i < num.length; i++) {
            BigInteger crntNum = new BigInteger(num[num.length-1-i]);
            crntNum = crntNum.multiply(n.pow(i));
            sum = sum.add(crntNum);
        }
        System.out.println(sum.toString());
    }
}
