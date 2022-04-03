package weekdays;

public class Main {
    public static void main(String[] args) {
        WeeklyCalendar wc = new WeeklyCalendar();
        wc.addEntry("Friday", "sleep");
        wc.addEntry("Thursday", "sleep");
        Iterable<WeeklyEntry> schedule = wc.getWeeklySchedule();

        for(WeeklyEntry we : schedule){
            System.out.println(we);
        }
    }
}
