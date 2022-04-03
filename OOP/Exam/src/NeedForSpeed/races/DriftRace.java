package NeedForSpeed.races;

import NeedForSpeed.cars.Car;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DriftRace extends Race {
    public DriftRace(int length, String route, int prizePool) {
        super(length, route, prizePool);
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
        Map<Car,Integer> overallPerformance = new LinkedHashMap<>();
        this.getParticipants().stream().forEachOrdered(x -> overallPerformance.put(x, (x.getSuspension() + x.getDurability())));

        Map<Car, Integer> sortedOverallPerformance = new LinkedHashMap<Car, Integer>();
        overallPerformance.entrySet().stream()
                .sorted(Map.Entry.<Car, Integer> comparingByValue().reversed()).limit(3)
                .forEachOrdered(x -> sortedOverallPerformance.put(x.getKey(), x.getValue()));

        return Collections.unmodifiableMap(sortedOverallPerformance);

    }

}
