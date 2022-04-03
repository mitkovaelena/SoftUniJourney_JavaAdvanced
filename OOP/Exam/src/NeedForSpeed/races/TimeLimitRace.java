package NeedForSpeed.races;

import NeedForSpeed.cars.Car;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class TimeLimitRace extends Race {
    private int goldTime;

    public TimeLimitRace(int length, String route, int prizePool, int goldTime) {
        super(length, route, prizePool);
        this.setGoldTime(goldTime);
    }

    public int getGoldTime() {
        return goldTime;
    }

    public void setGoldTime(int goldTime) {
        this.goldTime = goldTime;
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

        return Collections.unmodifiableMap(new LinkedHashMap<>());
    }

    @Override
    public String toString() {
        Car participant = this.getParticipants().get(0);
        Integer timePoints = this.getLength() *((participant.getHorsepower()/100)*participant.getAcceleration());
        String  earnedTime = "";
        Integer  wonPrize = 0;

        if (timePoints <= this.getGoldTime()){
            earnedTime = "Gold";
            wonPrize = this.getPrizePool();
        } else if (timePoints <= this.getGoldTime()+15){
            earnedTime = "Silver";
            wonPrize = (this.getPrizePool()*50)/100;
        } else {
            earnedTime = "Bronze";
            wonPrize = (this.getPrizePool()*30)/100;
        }

       return super.toString()+ String.format("%s %s - %d s.\n" +
                        "%s Time, $%d.\n",
                participant.getBrand(), participant.getModel(), timePoints, earnedTime, wonPrize);
    }
}
