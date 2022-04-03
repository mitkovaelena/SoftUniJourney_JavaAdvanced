package eightTuple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Tuple> list = new ArrayList<>();

        String[] line1 = reader.readLine().split("\\s+");
        String fullName = line1[0] + " " + line1[1];

        list.add(new Tuple<String,String ,String>(fullName, line1[2], line1[3]));

        String[] line2 = reader.readLine().split("\\s+");

        list.add(new Tuple<String,Integer ,Boolean>(line2[0], Integer.parseInt(line2[1]), line2[2].equals("drunk")));

        String[] line3 = reader.readLine().split("\\s+");

        list.add(new Tuple<String,Double,String>(line3[0], Double.parseDouble(line3[1]), line3[2]));

        list.forEach(System.out::println);
    }
}
