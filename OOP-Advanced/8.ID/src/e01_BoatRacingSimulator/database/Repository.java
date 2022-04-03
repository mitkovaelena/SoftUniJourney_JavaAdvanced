package e01_BoatRacingSimulator.database;

import e01_BoatRacingSimulator.Utility.Constants;
import e01_BoatRacingSimulator.contracts.IModelable;
import e01_BoatRacingSimulator.contracts.IRepository;
import e01_BoatRacingSimulator.exeptions.DuplicateModelException;
import e01_BoatRacingSimulator.exeptions.NonExistantModelException;

import java.util.HashMap;

public class Repository<T extends IModelable> implements IRepository {
    private HashMap<String, IModelable> itemsByModel;

    public Repository()
    {
        this.setItemsByModel(new HashMap<String, IModelable>());
    }

    protected HashMap<String, IModelable> getItemsByModel() {
        return this.itemsByModel;
    }

    protected void setItemsByModel(HashMap<String, IModelable> itemsByModel) {
        this.itemsByModel = itemsByModel;
    }

    @Override
    public void add(IModelable item) throws DuplicateModelException {
        if (this.itemsByModel.containsKey(item.getModel()))
        {
            throw new DuplicateModelException(Constants.DUPLICATE_MODEL_MESSAGE);
        } else {
            this.itemsByModel.put(item.getModel(), item);
        }
    }

    @Override
    public IModelable getItem(String model) throws NonExistantModelException {
        if (!this.itemsByModel.containsKey(model))
        {
            throw new NonExistantModelException(Constants.NON_EXISTANT_MODEL_MESSAGE);
        }

        return this.itemsByModel.get(model);
    }

}
