package warningLevels;

import java.util.Comparator;

public class Message {
    public static final Comparator<Message> BY_IMPORTANCE = getComparatorByImportance();

    private String message;
    private Importance importance;

    public Message(String message, Importance importance) {
        this.message = message;
        this.importance = importance;
    }

    @Override
    public String toString() {
        return this.importance.toString() + ": " + this.message;
    }

    private static Comparator<Message> getComparatorByImportance() {
        return (e1,e2) -> e1.importance.compareTo(e2.importance);
    }
}
