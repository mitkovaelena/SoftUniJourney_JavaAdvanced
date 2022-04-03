import java.io.*;

public class read3rdLines {
    public static void main(String[] args) {
        String inPath = ".\\input1.txt";
        String outPath = ".\\output4.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(inPath)); PrintWriter writer = new PrintWriter(outPath)) {
            String line = reader.readLine();
            int counter = 1;
            while (line != null) {
                if(counter % 3 == 0) {
                    writer.println(line);
                }
                line = reader.readLine();
                counter++;
            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
