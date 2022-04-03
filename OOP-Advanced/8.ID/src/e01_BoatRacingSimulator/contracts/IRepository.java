package e01_BoatRacingSimulator.contracts;

import e01_BoatRacingSimulator.exeptions.DuplicateModelException;
import e01_BoatRacingSimulator.exeptions.NonExistantModelException;

public interface IRepository<T extends IModelable> {
    void add(T item) throws DuplicateModelException;

    T getItem(String model) throws NonExistantModelException;
}
