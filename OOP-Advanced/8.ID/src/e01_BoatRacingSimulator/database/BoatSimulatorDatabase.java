package e01_BoatRacingSimulator.database;

import e01_BoatRacingSimulator.contracts.IBoat;
import e01_BoatRacingSimulator.contracts.IModelable;
import e01_BoatRacingSimulator.contracts.IRepository;

public class BoatSimulatorDatabase {
    IRepository<IBoat> boats;
    IRepository<IModelable> engines;

    public BoatSimulatorDatabase()
    {
        this.setBoats(new Repository<IBoat>());
        this.setEngines(new Repository<IModelable>());
    }

    public IRepository<IBoat> getBoats() {
        return this.boats;  //TODO
    }

    private void setBoats(IRepository<IBoat> boats) {
        this.boats = boats;
    }

    public IRepository<IModelable> getEngines() {
        return this.engines;
    }

    private void setEngines(IRepository<IModelable> engines) {
        this.engines = engines;
    }
}
