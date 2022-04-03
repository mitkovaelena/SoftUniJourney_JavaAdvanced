import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class consumerPrint {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Integer len = Integer.parseInt(reader.readLine());
        String[] names = reader.readLine().split("\\s+");

        Consumer<String> printer = n -> System.out.println(n);
        Predicate<String> lengthChecker = w -> w.length()<=len;

        for(String name : names){
            if(lengthChecker.test(name))
            printer.accept(name);
        }
    }
}
