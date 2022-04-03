import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class sumBigNums {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BigInteger num1 = new BigInteger(reader.readLine());
        BigInteger num2 = new BigInteger(reader.readLine());
        BigInteger result = num1.multiply(num2);


        System.out.println(result.toString());
    }
}
