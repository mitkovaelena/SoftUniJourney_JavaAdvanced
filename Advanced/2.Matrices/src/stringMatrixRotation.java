import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class stringMatrixRotation {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inputLine = reader.readLine();
        Integer rotations = Integer.parseInt(inputLine.split("[]\\(\\)]")[1]);
        rotations /=90;
        rotations %= 4;
        String matrixLine = "";
        inputLine = reader.readLine();
        Integer maxLen = 0;

        while (!inputLine.equals("END")){
            if(inputLine.length()> maxLen) maxLen = inputLine.length();
            matrixLine += inputLine + "\n";
            inputLine = reader.readLine();
        }

        String[] matrixL = matrixLine.split("\n");
        String output = "";

        switch (rotations){
            case 0:
                System.out.println(matrixLine);
                return;
            case 1:

                for (int j = 0; j < maxLen; j++) {
                    for (int i = matrixL.length-1; i >= 0; i--) {
                        try {
                            output += matrixL[i].charAt(j);
                        }catch (Exception e){
                            output += " ";
                        }
                    }
                    output +="\n";
                }
                System.out.println(output);

                return;
            case 2:
                System.out.println(new StringBuilder(matrixLine).reverse().toString());
                return;
            case 3:

                for (int j = 0; j < maxLen; j++) {
                    for (int i = matrixL.length-1; i >= 0; i--) {
                        try {
                            output += matrixL[i].charAt(j);
                        }catch (Exception e){
                            output += " ";
                        }
                    }
                    output +="\n";
                }
                System.out.println(new StringBuilder(output).reverse().toString());
                return;
        }
    }
}
