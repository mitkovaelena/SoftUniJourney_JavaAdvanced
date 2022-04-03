import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class CatLady {
    public static void main(String[] args) throws IOException {
        HashMap<String, String> cats = new HashMap<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String command = reader.readLine();
            if ("End".equals(command)) {
                break;
            }
            String line[] = command.split("\\s+");
            cats.put(line[1], command);
        }
        String command = reader.readLine();
        System.out.println(cats.get(command));
    }
}
