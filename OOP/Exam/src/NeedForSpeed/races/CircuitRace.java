package NeedForSpeed.races;

import NeedForSpeed.cars.Car;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CircuitRace extends Race {
    private int laps;

    public CircuitRace(int length, String route, int prizePool, int laps) {
        super(length, route, prizePool);
        this.setLaps(laps);
    }

    public int getLaps() {
        return laps;
    }

    public void setLaps(int laps) {
        this.laps = laps;
    }

    @Override
    public int getLength() {
        return super.getLength();
    }

    @Override
    public String getRoute() {
        return super.getRoute();
    }

    @Override
    public int getPrizePool() {
        return super.getPrizePool();
    }

    @Override
    protected void setLength(int length) {
        super.setLength(length);
    }

    @Override
    protected void setRoute(String route) {
        super.setRoute(route);
    }

    @Override
    protected void setPrizePool(int prizePool) {
        super.setPrizePool(prizePool);
    }

    @Override
    public List<Car> getParticipants() {
        return super.getParticipants();
    }

    @Override
    protected void setParticipants(List<Car> participants) {
        super.setParticipants(participants);
    }

    @Override
    public Map<Car, Integer> start() {
        Map<Car, Integer> overallPerformance = new LinkedHashMap<>();

        for(Car c : this.getParticipants()){
            c.setDurability(c.getDurability()-(this.getLength()*this.getLength()*this.getLaps()));
        }

        this.getParticipants().stream().forEachOrdered(x -> overallPerformance.put(x, ((x.getHorsepower() / x.getAcceleration()) + (x.getSuspension() + x.getDurability()))));

        Map<Car, Integer> sortedOverallPerformance = new LinkedHashMap<Car, Integer>();
        overallPerformance.entrySet().stream()
                .sorted(Map.Entry.<Car, Integer>comparingByValue().reversed()).limit(4)
                .forEachOrdered(x -> sortedOverallPerformance.put(x.getKey(), x.getValue()));


        return Collections.unmodifiableMap(sortedOverallPerformance);
    }

    @Override
    public String toString() {
        return String.format("%s - %d\n",
                this.getRoute(), this.getLength()*this.getLaps());
    }
}
