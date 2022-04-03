import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class inferno3 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] gems = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        String command = reader.readLine();
        Integer[] printNums = new Integer[gems.length];

        for (int i = 0; i < gems.length; i++) {
            printNums[i] = 1;
        }

        while (!command.equals("Forge")) {
            String[] commandLine = command.split("\\s*;\\s*");
            switch (commandLine[1]) {
                case "Sum Left":
                    if(commandLine[0].equals("Exclude")) {
                        for (int i = 0; i < gems.length; i++) {
                            if(i>0) {
                                if (gems[i] + gems[i - 1] == Integer.parseInt(commandLine[2]))
                                    printNums[i] = 0;
                            } else  {
                                if (gems[i] == Integer.parseInt(commandLine[2]))
                                    printNums[i] = 0;
                            }
                        }
                    }
                    else{
                        for (int i = 0; i < gems.length; i++) {
                            if(i>0) {
                                if (gems[i] + gems[i - 1] == Integer.parseInt(commandLine[2]))
                                    printNums[i] = 1;
                            } else  {
                                if (gems[i] == Integer.parseInt(commandLine[2]))
                                    printNums[i] = 1;
                            }
                        }
                    }
                    break;
                case "Sum Right":
                    if(commandLine[0].equals("Exclude")) {
                        for (int i = 0; i < gems.length; i++) {
                            if(i<gems.length-1) {
                                if (gems[i] + gems[i + 1] == Integer.parseInt(commandLine[2]))
                                    printNums[i] = 0;
                            } else  {
                                if (gems[i] == Integer.parseInt(commandLine[2]))
                                    printNums[i] = 0;
                            }
                        }
                    }
                    else{
                        for (int i = 0; i < gems.length; i++) {
                            if(i<gems.length-1) {
                                if (gems[i] + gems[i + 1] == Integer.parseInt(commandLine[2]))
                                    printNums[i] = 1;
                            } else  {
                                if (gems[i] == Integer.parseInt(commandLine[2]))
                                    printNums[i] = 1;
                            }
                        }
                    }
                    break;
                case "Sum Left Right":
                    if(commandLine[0].equals("Exclude")) {
                        for (int i = 0; i < gems.length; i++) {
                            int sum = gems[i];
                            if(i>0 ) {
                                sum += gems[i-1];
                            }
                            if ( i < gems.length-1){
                                sum += gems[i+1];
                            }
                            if (sum == Integer.parseInt(commandLine[2]))
                                printNums[i] = 0;
                        }
                    }
                    else{
                        for (int i = 0; i < gems.length; i++) {
                            int sum = gems[i];
                            if(i>0 ) {
                                sum += gems[i-1];
                            }
                            if ( i < gems.length-1){
                                sum += gems[i+1];
                            }
                            if (sum == Integer.parseInt(commandLine[2]))
                                printNums[i] = 1;
                        }
                    }
                    break;

            }
            command = reader.readLine();
        }

        String output = "";
        for (int i = 0; i < gems.length; i++) {
            if (printNums[i] != 0) {
                output+= gems[i] + " ";
            }
        }
        if(output.length()>0)
            System.out.println(output.trim());

    }

}
