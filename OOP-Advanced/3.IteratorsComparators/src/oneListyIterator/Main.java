package oneListyIterator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String[] input = reader.readLine().split("\\s+");
            if (input[0].equals("END")) break;
            CommandInterpreter.interpretCommand(input);
        }
    }
}
