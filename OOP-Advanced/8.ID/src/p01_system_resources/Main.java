package p01_system_resources;

public class Main {
    public static void main(String[] args) {
        GreetingClock greetingClock = new GreetingClock(new LocalTimeProvider(), new CustomConsoleWriter());
        greetingClock.greeting();
    }
}
