package twoStackIterator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        CustomStack stack = new CustomStack();

        while (true) {
            String[] input = reader.readLine().split("\\s+");
            if (input[0].equals("END")) break;
            switch (input[0]) {
                case "Push":
                    for (int i = 1; i < input.length; i++) {
                        stack.push(Integer.valueOf(input[i].replace(",","")));
                    }
                    break;
                case "Pop":
                    if(!stack.pop()){
                        System.out.println("No elements");
                    }
                    break;
            }
        }

        for (int i = 0; i < 2; i++) {
            for (Object o : stack) {
                System.out.println(o);
            }
        }
    }
}
