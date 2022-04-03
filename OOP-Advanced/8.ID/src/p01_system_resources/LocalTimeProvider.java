package p01_system_resources;

import java.time.LocalTime;

public class LocalTimeProvider implements TimeProvider {
    private LocalTime time;

    public LocalTimeProvider() {
        this.time = LocalTime.now();
    }

    @Override
    public int getHour() {
        return this.time.getHour();
    }
}
