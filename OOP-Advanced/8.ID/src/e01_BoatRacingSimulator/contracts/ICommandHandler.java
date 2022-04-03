package e01_BoatRacingSimulator.contracts;

import e01_BoatRacingSimulator.exeptions.*;

import java.util.List;

public interface ICommandHandler {
    String executeCommand(String name, List<String> parameters) throws DuplicateModelException, NonExistantModelException, RaceAlreadyExistsException, NoSetRaceException, InsufficientContestantsException;
}
