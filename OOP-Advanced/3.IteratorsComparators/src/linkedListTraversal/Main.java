package linkedListTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        CustomLinkedList<Integer> linkedList = new CustomLinkedList();
        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++) {
            String[] input = reader.readLine().split("\\s+");

            switch (input[0]) {
                case "Add":
                    linkedList.add(Integer.valueOf(input[1]));
                    break;
                case "Remove":
                    linkedList.remove(Integer.valueOf(input[1]));
                    break;
            }
        }

        System.out.println(linkedList.getSize());
        for (Object o : linkedList) {
            System.out.print(o + " ");
        }
    }
}
