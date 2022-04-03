package genericBox;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Integer n = Integer.parseInt(reader.readLine());
        Box<Double> box = new Box();

        for (int i = 0; i < n; i++) {
            box.addElementInBox(Double.parseDouble(reader.readLine()));
        }

        Double elem = Double.parseDouble(reader.readLine());
        System.out.println(box.countGreaterThan(elem));
    }
}
