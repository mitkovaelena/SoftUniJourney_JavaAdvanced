package e01_BoatRacingSimulator.contracts;

import e01_BoatRacingSimulator.enumeration.EngineType;
import e01_BoatRacingSimulator.exeptions.DuplicateModelException;
import e01_BoatRacingSimulator.exeptions.NonExistantModelException;

public interface IFactory {
    String createBoatEngine(String model, int horsepower, int displacement, EngineType engineType) throws DuplicateModelException;

    String createRowBoat(String model, int weight, int oars) throws DuplicateModelException;

    String createSailBoat(String model, int weight, int sailEfficiency) throws DuplicateModelException;

    String createPowerBoat(String model, int weight, String firstEngineModel, String secondEngineModel) throws NonExistantModelException, DuplicateModelException;

    String createYacht(String model, int weight, String engineModel, int cargoWeight) throws NonExistantModelException, DuplicateModelException;


}
