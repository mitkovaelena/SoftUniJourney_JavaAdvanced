package e01_BoatRacingSimulator.controllers;

import e01_BoatRacingSimulator.Utility.Constants;
import e01_BoatRacingSimulator.contracts.IBoat;
import e01_BoatRacingSimulator.contracts.IRace;
import e01_BoatRacingSimulator.database.BoatSimulatorDatabase;
import e01_BoatRacingSimulator.exeptions.*;
import e01_BoatRacingSimulator.models.Race;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class RaceController implements e01_BoatRacingSimulator.contracts.IRaceController {
    private IRace currentRace;
    private BoatSimulatorDatabase database;

    public RaceController(BoatSimulatorDatabase database) {
        this.setCurrentRace(null);   //ToDo
        this.setDatabase(database);
    }

    @Override
    public IRace getCurrentRace() {
        return this.currentRace;
    }

    private void setCurrentRace(IRace currentRace) {
        this.currentRace = currentRace;
    }

    public BoatSimulatorDatabase getDatabase() {
        return database;
    }

    private void setDatabase(BoatSimulatorDatabase database) {
        this.database = database;
    }

    public String openRace(int distance, int windSpeed, int oceanCurrentSpeed, Boolean allowsMotorboats) throws RaceAlreadyExistsException {
        IRace race = new Race(distance, windSpeed, oceanCurrentSpeed, allowsMotorboats);
        this.validateRaceIsEmpty();
        this.currentRace = race;
        StringBuilder sb = new StringBuilder("A new race with distance ");
        sb.append(distance).append(" meters, wind speed ").append(windSpeed)
                .append(" m/s and ocean current speed ").append(oceanCurrentSpeed).append(" m/s has been set.");
        return sb.toString();
    }

    public String signUpBoat(String model) throws NonExistantModelException, DuplicateModelException, NoSetRaceException {
        IBoat boat = this.database.getBoats().getItem(model);
        this.validateRaceIsSet();
        if (!this.currentRace.getAllowsMotorboats() && boat.isMotorBoat()) {
            throw new IllegalArgumentException(Constants.INCORRECT_BOAT_TYPE_MESSAGE);
        }
        this.currentRace.addParticipant(boat);
        StringBuilder sb = new StringBuilder("Boat with model ");
        sb.append(model).append(" has signed up for the current Race.");
        return sb.toString();
    }

    public String startRace() throws InsufficientContestantsException, NoSetRaceException {
        this.validateRaceIsSet();
        List<IBoat> participants = this.currentRace.getParticipants();
        if (participants.size() < 3) {
            throw new InsufficientContestantsException(Constants.INSUFFICIENT_CONTESTANTS_MESSAGE);
        }

        Map<IBoat, Double> winners = findFastest(participants);

        StringBuilder result = new StringBuilder();

        int i = 0;
        for (Map.Entry<IBoat, Double> entry : winners.entrySet()) {
            if (i == 3)break;
            String place = "";
            switch (i){
                case 0: place = "First";
                break;
                case 1: place = "Second";
                    break;
                case 2: place = "Third";
                    break;
            }

            result.append(place).append(" place: ").append(entry.getKey().getClass().getSimpleName().toString())
                    .append(" Model: ").append(entry.getKey().getModel()).append(" Time: ")
                    .append(isFinished(entry.getValue())).append("\n");
            i++;
        }

        this.currentRace = null;

        return result.substring(0, result.length()-1).toString();
    }

    private String isFinished(Double key) {
        if (key <= 0 || key.equals(Double.POSITIVE_INFINITY) || key.equals(Double.NEGATIVE_INFINITY)) {
            return "Did not finish!";
        }
        return String.format("%.2f sec", key);
    }

    @Override
    public String getStatistic() {
        //TODO Bonus Task Implement me
        return null;
    }

    private Map<IBoat, Double> findFastest(List<IBoat> participants) {
        Map<IBoat, Double> positiveTime = new LinkedHashMap<>();
        Map<IBoat, Double> negativeTime = new LinkedHashMap<>();
        for (IBoat participant : participants) {
            Double speed = participant.calculateRaceSpeed(this.currentRace);
            Double time = this.currentRace.getDistance() / speed;
            if(time > 0) {
                positiveTime.put(participant, time);
            } else {
                negativeTime.put(participant,time);
            }
        }
        Map<IBoat, Double> sortedParticipants = new LinkedHashMap<IBoat, Double>();
        positiveTime.entrySet().stream()
                .sorted(Map.Entry.<IBoat, Double> comparingByValue())
                .forEachOrdered(x -> sortedParticipants.put(x.getKey(), x.getValue()));
        negativeTime.entrySet().stream()
                .forEachOrdered(x -> sortedParticipants.put(x.getKey(), x.getValue()));

        return sortedParticipants;
    }

    private void validateRaceIsSet() throws NoSetRaceException {
        if (this.currentRace == null) {
            throw new NoSetRaceException(Constants.NO_SET_RACE_MESSAGE);
        }
    }

    private void validateRaceIsEmpty() throws RaceAlreadyExistsException {
        if (this.currentRace != null) {
            throw new RaceAlreadyExistsException(Constants.RACE_ALREADY_EXISTS_MESSAGE);
        }
    }
}
