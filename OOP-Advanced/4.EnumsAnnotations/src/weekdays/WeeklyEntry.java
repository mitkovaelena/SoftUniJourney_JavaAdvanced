package weekdays;

import java.util.Comparator;

public class WeeklyEntry {
    public static final Comparator<WeeklyEntry> BY_WEEKDAY = getComparatorByWeekday();

    private Weekday weekday;
    private String notes;

    public WeeklyEntry(String weekday, String notes) {
        this.weekday = Enum.valueOf(Weekday.class, weekday.toUpperCase());
        this.notes = notes;
    }

    @Override
    public String toString() {
        return String.format("%s - %s", this.weekday.toString(), this.notes);
    }

    private static Comparator<WeeklyEntry> getComparatorByWeekday() {
        return (e1,e2) -> e1.weekday.compareTo(e2.weekday);
    }
}
