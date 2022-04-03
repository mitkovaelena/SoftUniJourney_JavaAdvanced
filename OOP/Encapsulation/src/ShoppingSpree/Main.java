package ShoppingSpree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String command = reader.readLine();

        Map<String, Person> people = new LinkedHashMap<>();
        Map<String, Product> products = new LinkedHashMap<>();

        String[] instructions = command.split(";");
        for(String s : instructions){
            String[] prs = s.split("=");
            try {
                Person person = new Person(prs[0], Double.parseDouble(prs[1]));
                people.put(prs[0], person);
            } catch (IllegalArgumentException iae){
                System.out.println(iae.getMessage());
                return;
            }
        }

        command = reader.readLine();
        instructions = command.split(";");
        for(String s : instructions){
            String[] prd = s.split("=");
            try {
                Product product = new Product(prd[0], Double.parseDouble(prd[1]));
                products.put(prd[0], product);
            } catch (IllegalArgumentException iae){
                System.out.println(iae.getMessage());
                return;
            }
        }
        command=reader.readLine();

        while (!command.equals("END")){
            String[] pp = command.split(" ");
            Person p = people.get(pp[0]);
            p.buyProduct(products.get(pp[1]));
            command = reader.readLine();
        }

        for(String p : people.keySet()){
            System.out.println(p + " - " + people.get(p).getBagOfProducts());
        }
    }
}
