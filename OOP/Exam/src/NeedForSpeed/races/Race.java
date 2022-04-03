package NeedForSpeed.races;

import NeedForSpeed.cars.Car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public abstract class Race {
    private int length;
    private String route;
    private int prizePool;
    private List<Car> participants;

    protected Race(int length, String route, int prizePool) {
        this.setLength(length);
        this.setRoute(route);
        this.setPrizePool(prizePool);
        this.setParticipants(new ArrayList<>());
    }

    protected void setLength(int length) {
        this.length = length;
    }

    protected void setRoute(String route) {
        this.route = route;
    }

    protected void setPrizePool(int prizePool) {
        this.prizePool = prizePool;
    }

    public int getLength() {
        return length;
    }

    public String getRoute() {
        return route;
    }

    public int getPrizePool() {
        return prizePool;
    }

    public List<Car> getParticipants() {
        return Collections.unmodifiableList(participants);
    }

    protected void setParticipants(List<Car> participants) {
        this.participants = participants;
    }

    public void addParticipant(Car car) {
        this.participants.add(car);
    }

    public void removeParticipant(Car car) {
        this.participants.remove(car);
    }

    public abstract Map<Car, Integer> start();

    @Override
    public String toString() {
        return String.format("%s - %d\n",
                this.getRoute(), this.getLength());
    }
}