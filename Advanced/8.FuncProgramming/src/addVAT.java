import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class addVAT {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split("\\s*,\\s*");

        Function<String, Double> parser = x -> Double.parseDouble(x);
        UnaryOperator<Double> plusVAT = x -> x*1.2;

        System.out.println("Prices with VAT:");
        for(String i : input){
            System.out.println(String.format("%.2f", plusVAT.apply(parser.apply(i))).replaceAll("\\.", ","));
        }
    }
}
