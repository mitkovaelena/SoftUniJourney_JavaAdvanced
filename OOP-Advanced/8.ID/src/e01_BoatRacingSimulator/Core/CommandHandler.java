package e01_BoatRacingSimulator.Core;

import e01_BoatRacingSimulator.Utility.Constants;
import e01_BoatRacingSimulator.contracts.ICommandHandler;
import e01_BoatRacingSimulator.contracts.IFactory;
import e01_BoatRacingSimulator.contracts.IRaceController;
import e01_BoatRacingSimulator.controllers.Factory;
import e01_BoatRacingSimulator.controllers.RaceController;
import e01_BoatRacingSimulator.database.BoatSimulatorDatabase;
import e01_BoatRacingSimulator.enumeration.EngineType;
import e01_BoatRacingSimulator.exeptions.*;

import java.util.List;

public class CommandHandler implements ICommandHandler {
    private IRaceController controller;
    private IFactory factory;

    public CommandHandler(IRaceController controller) {
        this.setContrller(controller);
    }

    public CommandHandler(BoatSimulatorDatabase database) {
        this.setContrller(new RaceController(database));
        this.setFactory(new Factory(database));
    }

    public IRaceController getController() {
        return this.controller;
    }

    private void setContrller(IRaceController controller) {
        this.controller = controller;
    }
    private void setFactory(IFactory factory) {
        this.factory = factory;
    }

    public String executeCommand(String name, List<String> parameters) throws DuplicateModelException, NonExistantModelException, RaceAlreadyExistsException, NoSetRaceException, InsufficientContestantsException {
        switch (name) {
            case "CreateBoatEngine":
                EngineType engineType;
                if (parameters.get(3).equals("Jet")) {
                    return this.factory.createBoatEngine(
                            parameters.get(0),
                            Integer.parseInt(parameters.get(1)),
                            Integer.parseInt(parameters.get(2)),
                            EngineType.JET);
                } else if (parameters.get(3).equals("Sterndrive")) {
                    return this.factory.createBoatEngine(
                            parameters.get(0),
                            Integer.parseInt(parameters.get(1)),
                            Integer.parseInt(parameters.get(2)),
                            EngineType.STERNDRIVE);
                }
                throw new IllegalArgumentException(Constants.INCORRECT_ENGINE_TYPE_MESSAGE);
            case "CreateRowBoat":
                return this.factory.createRowBoat(
                        parameters.get(0),
                        Integer.parseInt(parameters.get(1)),
                        Integer.parseInt(parameters.get(2)));
            case "CreateSailBoat":
                return this.factory.createSailBoat(
                        parameters.get(0),
                        Integer.parseInt(parameters.get(1)),
                        Integer.parseInt(parameters.get(2)));
            case "CreatePowerBoat":
                return this.factory.createPowerBoat(
                        parameters.get(0),
                        Integer.parseInt(parameters.get(1)),
                        parameters.get(2),
                        parameters.get(3));
            case "CreateYacht":
                return this.factory.createYacht(
                        parameters.get(0),
                        Integer.parseInt(parameters.get(1)),
                        parameters.get(2),
                        Integer.parseInt(parameters.get(3)));
            case "OpenRace":
                return this.getController().openRace(
                        Integer.parseInt(parameters.get(0)),
                        Integer.parseInt(parameters.get(1)),
                        Integer.parseInt(parameters.get(2)),
                        Boolean.parseBoolean(parameters.get(3)));
            case "SignUpBoat":
                return this.getController().signUpBoat(parameters.get(0));
            case "StartRace":
                return this.getController().startRace();
            case "GetStatistic":
                return this.getController().getStatistic();
            default:
                throw new IllegalArgumentException();
        }
    }
}
