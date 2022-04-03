import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class predicateParty {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] people = reader.readLine().split("\\s+");
        String command = reader.readLine();
        Integer[] printNums = new Integer[people.length];

        for (int i = 0; i < people.length; i++) {
            printNums[i] = 1;
        }

        while (!command.equals("Print")) {
            String[] commandLine = command.split("\\s*;\\s*");
            switch (commandLine[1]) {
                case "Starts with":
                    if(commandLine[0].equals("Add filter")) {
                        for (int i = 0; i < people.length; i++) {
                            if(people[i].startsWith(commandLine[2]))
                                printNums[i] = 0;
                        }
                    }
                    else{
                        for (int i = 0; i < people.length; i++) {
                            if(people[i].startsWith(commandLine[2]))
                                printNums[i] = 1;
                        }
                    }
                    break;
                case "Ends with":
                    if(commandLine[0].equals("Add filter")) {
                        for (int i = 0; i < people.length; i++) {
                            if(people[i].endsWith(commandLine[2]))
                                printNums[i] = 0;
                        }
                    }
                    else{
                        for (int i = 0; i < people.length; i++) {
                            if(people[i].endsWith(commandLine[2]))
                                printNums[i] = 1;
                        }
                    }
                    break;
                case "Length":
                    if(commandLine[0].equals("Add filter")) {
                        for (int i = 0; i < people.length; i++) {
                            if (people[i].length() == commandLine[2].length()) {
                                printNums[i] = 0;
                            }
                        }
                    }
                    else{
                        for (int i = 0; i < people.length; i++) {
                            if(people[i].length() == commandLine[2].length())
                                printNums[i] = 1;
                        }
                    }
                    break;
                case "Contains":
                    if(commandLine[0].equals("Add filter")) {
                        for (int i = 0; i < people.length; i++) {
                            if(people[i].contains(commandLine[2]))
                                printNums[i] = 0;
                        }
                    }
                    else{
                        for (int i = 0; i < people.length; i++) {
                            if(people[i].contains(commandLine[2]))
                                printNums[i] = 1;
                        }
                    }
                    break;
            }
            command = reader.readLine();
        }

        String output = "";
        for (int i = 0; i < people.length; i++) {
            if (printNums[i] != 0) {
                output+= people[i] + " ";
            }
        }
        if(output.length()>0)
            System.out.println(output.trim());

    }

}
