package telephony;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] phoneNums = reader.readLine().split(" ");
        String[] sites = reader.readLine().split(" ");

        Smartphone smartphone = new Smartphone();

        for(String phone : phoneNums){
            System.out.println(smartphone.call(phone));
        }

        for(String site : sites){
            System.out.println(smartphone.browze(site));
        }
    }
}
