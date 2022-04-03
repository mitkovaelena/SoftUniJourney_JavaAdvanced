package e01_BoatRacingSimulator.controllers;

import e01_BoatRacingSimulator.contracts.IFactory;
import e01_BoatRacingSimulator.contracts.IModelable;
import e01_BoatRacingSimulator.database.BoatSimulatorDatabase;
import e01_BoatRacingSimulator.enumeration.EngineType;
import e01_BoatRacingSimulator.exeptions.DuplicateModelException;
import e01_BoatRacingSimulator.exeptions.NonExistantModelException;
import e01_BoatRacingSimulator.models.boats.*;
import e01_BoatRacingSimulator.models.engines.BaseEngine;
import e01_BoatRacingSimulator.models.engines.JetEngine;
import e01_BoatRacingSimulator.models.engines.SterndriveEngine;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class Factory implements IFactory {
    private BoatSimulatorDatabase database;

    public Factory(BoatSimulatorDatabase database) {
        this.setDatabase(database);
    }

    private void setDatabase(BoatSimulatorDatabase database) {
        this.database = database;
    }

    public BoatSimulatorDatabase getDatabase() {
        return this.database;
    }

    @Override
    public String createBoatEngine(String model, int horsepower, int displacement, EngineType engineType) throws DuplicateModelException {
        IModelable engine;
        switch (engineType) {
            case JET:
                engine = new JetEngine(model, horsepower, displacement);
                break;
            case STERNDRIVE:
                engine = new SterndriveEngine(model, horsepower, displacement);
                break;
            default:
                throw new NotImplementedException();
        }

        this.database.getEngines().add(engine);
        StringBuilder sb = new StringBuilder("Engine model ");
        sb.append(model).append(" with ").append(horsepower).append(" HP and displacement ")
                .append(displacement).append(" cm3 created successfully.");
        return sb.toString();
    }

    @Override
    public String createRowBoat(String model, int weight, int oars) throws DuplicateModelException {
        BaseBoat boat = new RowBoat(model, weight, oars);
        this.database.getBoats().add(boat);
        StringBuilder sb = new StringBuilder("Row boat with model ");
        sb.append(model).append(" registered successfully.");
        return sb.toString();
    }

    @Override
    public String createSailBoat(String model, int weight, int sailEfficiency) throws DuplicateModelException {
        BaseBoat boat = new SailBoat(model, weight, sailEfficiency);
        this.database.getBoats().add(boat);
        StringBuilder sb = new StringBuilder("Sail boat with model ");
        sb.append(model).append(" registered successfully.");
        return sb.toString();
    }

    @Override
    public String createPowerBoat(String model, int weight, String firstEngineModel, String secondEngineModel) throws NonExistantModelException, DuplicateModelException {
        BaseEngine firstEngine = (BaseEngine) this.database.getEngines().getItem(firstEngineModel);
        BaseEngine secondEngine = (BaseEngine) this.database.getEngines().getItem(secondEngineModel);
        BaseEngine[] engines = {firstEngine, secondEngine};
        BaseBoat boat = new PowerBoat(model, weight, engines);
        this.database.getBoats().add(boat);
        StringBuilder sb = new StringBuilder("Power boat with model ");
        sb.append(model).append(" registered successfully.");
        return sb.toString();
    }

    @Override
    public String createYacht(String model, int weight, String engineModel, int cargoWeight) throws NonExistantModelException, DuplicateModelException {
        BaseEngine engine = (BaseEngine) this.database.getEngines().getItem(engineModel);
        BaseBoat boat = new Yacht(model, weight, engine, cargoWeight);
        this.database.getBoats().add(boat);
        StringBuilder sb = new StringBuilder("Yacht with model ");
        sb.append(model).append(" registered successfully.");
        return sb.toString();
    }

}
