package collectionHierarchy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String output = "";

        AddCollection addCollection = new AddCollection();
        AddRemoveCollection addRemoveCollection = new AddRemoveCollection();
        MyList myList = new MyList();

        String[] input = reader.readLine().split("\\s+");
        Integer numberOfOperations = Integer.parseInt(reader.readLine());

        for (String s : input){
            output += addCollection.add(s).toString() + " ";
        }
        output = output.trim();
        output += "\n";
        for (String s : input){
            output += addRemoveCollection.add(s).toString() + " ";
        }
        output = output.trim();
        output += "\n";
        for (String s : input){
            output += myList.add(s).toString() + " ";
        }
        output = output.trim();
        output += "\n";

        for (int i = 0; i < numberOfOperations; i ++){
            output += addRemoveCollection.remove() + " ";
        }
        output = output.trim();
        output += "\n";
        for (int i = 0; i < numberOfOperations; i ++){
            output += myList.remove() + " ";
        }
        output = output.trim();
        output += "\n";

        System.out.println(output);
    }
}
