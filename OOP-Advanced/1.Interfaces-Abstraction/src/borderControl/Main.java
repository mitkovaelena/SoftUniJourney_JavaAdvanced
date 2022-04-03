package borderControl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Buyer> buyers = new LinkedHashMap();
        Integer n  = Integer.parseInt(reader.readLine());


        for (int i = 0; i < n; i++) {
            String[] info = reader.readLine().split(" ");

            switch (info.length){
                case 3: {
                    Buyer rebel = new Rebel(info[0], Integer.parseInt(info[1]), info[2]);
                    buyers.put(info[0], rebel);
                    break;
                }
                case 4: {
                    Buyer person = new Person(info[0], Integer.parseInt(info[1]), info[2], info[3]);
                    buyers.put(info[0],person);
                    break;
                }
            }
        }

        while (true){
            String name = reader.readLine();

            if(name.equals("End")){
                break;
            }

            if(buyers.containsKey(name)){
                buyers.get(name).buyFood();
            }
        }

        System.out.println(buyers.values().stream().map(x -> x.getFood()).mapToInt(Integer::intValue).sum());
    }
}
