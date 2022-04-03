package NeedForSpeed;

import NeedForSpeed.cars.Car;
import NeedForSpeed.cars.PerformanceCar;
import NeedForSpeed.cars.ShowCar;
import NeedForSpeed.garages.Garage;
import NeedForSpeed.races.*;

import java.util.*;

public class CarManager {
    private Map<Integer, Car> cars;
    private Map<Integer, Race> races;
    private Garage garage;
    private List<Car> carsParticipatingInRaces;

    public CarManager() {
        this.cars = new LinkedHashMap<>();
        this.races = new LinkedHashMap<>();
        this.garage = new Garage();
        this.carsParticipatingInRaces = new ArrayList<>();
    }

    public void register(int id, String type, String brand, String model, int yearOfProduction, int horsepower, int acceleration, int suspension, int durability) {
        Car car;
        switch (type) {
            case "Performance":
                car = new PerformanceCar(brand, model, yearOfProduction, horsepower, acceleration, suspension, durability);
                cars.put(id, car);
                break;
            case "Show":
                car = new ShowCar(brand, model, yearOfProduction, horsepower, acceleration, suspension, durability);
                cars.put(id, car);
                break;
        }

    }

    public String check(int id) {
        return cars.get(id).toString();
    }

    public void open(int id, String type, int length, String route, int prizePool) {
        Race race;
        switch (type) {
            case "Casual":
                race = new CasualRace(length, route, prizePool);
                races.put(id, race);
                break;
            case "Drag":
                race = new DragRace(length, route, prizePool);
                races.put(id, race);
                break;
            case "Drift":
                race = new DriftRace(length, route, prizePool);
                races.put(id, race);
                break;
        }
    }

    public void open(int id, String type, int length, String route, int prizePool, int bonusParam) {
        Race race;
        switch (type) {
            case "TimeLimit":
                race = new TimeLimitRace(length, route, prizePool, bonusParam);
                races.put(id, race);
                break;
            case "Circuit":
                race = new CircuitRace(length, route, prizePool, bonusParam);
                races.put(id, race);
                break;
        }
    }

    public void participate(int carId, int raceId) {
        if (!races.get(raceId).getClass().getSimpleName().equals("TimeLimitRace") || races.get(raceId).getParticipants().size() == 0) {
            if (!garage.getParkedCars().contains(cars.get(carId)) && races.containsKey(raceId) && cars.containsKey(carId)) {
                races.get(raceId).addParticipant(cars.get(carId));
                carsParticipatingInRaces.add(cars.get(carId));
            }
        }
    }

    public String start(int id) {
        if (races.containsKey(id) && !races.get(id).getParticipants().isEmpty()) {
            String output = races.get(id).toString();

            Map<Car, Integer> winners = races.get(id).start();

            for (int i = 0; i < carsParticipatingInRaces.size(); i++) {
                if (races.get(id).getParticipants().contains(carsParticipatingInRaces.get(i))) {
                    races.get(id).removeParticipant(carsParticipatingInRaces.get(i));
                    carsParticipatingInRaces.remove(i);
                    i--;
                }
            }

            int i = 1;
            for (Car car : winners.keySet()) {
                int moneyWon = 0;

                switch (i) {
                    case 1:
                        if (!races.get(id).getClass().getSimpleName().equals("CircuitRace")) {
                            moneyWon = (races.get(id).getPrizePool() * 50) / 100;
                        } else {
                            moneyWon = (races.get(id).getPrizePool() * 40) / 100;
                        }
                        break;
                    case 2:
                        moneyWon = (races.get(id).getPrizePool() * 30) / 100;
                        break;
                    case 3:
                        moneyWon = (races.get(id).getPrizePool() * 20) / 100;
                        break;
                    case 4:
                        moneyWon = (races.get(id).getPrizePool() * 10) / 100;
                        break;
                }

                output += String.format("%d. %s %s %dPP - $%d\n",
                        i++, car.getBrand(), car.getModel(), winners.get(car), moneyWon);
            }

            races.remove(id);
            return output;
        }
        return "Cannot start the race with zero participants.\n";
    }

    public void park(int id) {
        if (!carsParticipatingInRaces.contains(cars.get(id))) {
            garage.addCar(cars.get(id));
        }
    }

    public void unpark(int id) {
        if (garage.getParkedCars().contains(cars.get(id))) {
            garage.removeCar(cars.get(id));
        }
    }

    public void tune(int tuneIndex, String addOn) {
        if (!garage.getParkedCars().isEmpty()) {
            garage.tune(tuneIndex, addOn);
        }
    }

}
