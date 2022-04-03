package mood3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] gameObj = reader.readLine().split("\\s+\\|\\s+");
        GameObject gameObject = null;

        switch (gameObj[1]){
            case "Archangel":
                gameObject = new Archangel(gameObj[0], gameObj[1], Integer.parseInt(gameObj[2]),Integer.parseInt(gameObj[3]) );
                break;
            case "Demon":
                gameObject = new Demon(gameObj[0], gameObj[1], Double.parseDouble(gameObj[2]),Integer.parseInt(gameObj[3]) );
                break;
        }

        System.out.println(gameObject.toString());
    }
}
