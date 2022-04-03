import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;
import java.util.TreeSet;

public class reverseString {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] str = reader.readLine().split("[\\s+,.?!]");
        TreeSet<String> palindromes = new TreeSet();

        for(String s : str) {
            if(s.equals("")) continue;
            if(s.equals(new StringBuilder(s).reverse().toString())){
                palindromes.add(s);
            }
        }
        System.out.print(palindromes);
    }
}
