package warningLevels;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String deafaultImportance = reader.readLine();
        Logger logger = new Logger(deafaultImportance);

        while (true){
            String[] msgString = reader.readLine().split(": ");
            if(msgString[0].equals("END")) break;

            logger.receiveMessage(msgString[1], msgString[0]);

        }

        Iterable<Message> messages = logger.getMessages();

        for(Message msg : messages){
            System.out.println(msg);
        }
    }
}
