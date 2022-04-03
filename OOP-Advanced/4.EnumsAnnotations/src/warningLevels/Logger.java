package warningLevels;

import java.util.ArrayList;
import java.util.List;

public class Logger {
    private List<Message> messages;
    private Importance deafaultImportance;

    public Logger(String importance) {
        this.messages = new ArrayList<>();
        this.deafaultImportance = Enum.valueOf(Importance.class, importance);

    }

    public void receiveMessage(String msg, String importance){
        Importance imp = Enum.valueOf(Importance.class, importance);
        if (imp.compareTo(this.deafaultImportance) >= 0){
            Message message = new Message(msg, imp);
            this.messages.add(message);
        }
    }

    public  Iterable<Message> getMessages(){
       // this.messages.sort(Message.BY_IMPORTANCE);
        return messages;
    }
}
