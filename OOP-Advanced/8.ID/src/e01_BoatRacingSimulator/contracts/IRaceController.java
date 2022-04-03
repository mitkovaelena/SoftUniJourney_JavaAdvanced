package e01_BoatRacingSimulator.contracts;

import e01_BoatRacingSimulator.exeptions.*;

public interface IRaceController {  //ToDo part in more controllers
    IRace getCurrentRace();

    String openRace(int distance, int windSpeed, int oceanCurrentSpeed, Boolean allowsMotorboats) throws RaceAlreadyExistsException;

    String signUpBoat(String model) throws NonExistantModelException, DuplicateModelException, NoSetRaceException;

    String startRace() throws InsufficientContestantsException, NoSetRaceException;

    String getStatistic();
}
