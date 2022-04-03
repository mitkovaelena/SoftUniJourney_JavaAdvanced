package app.waste_disposal.models.strategies;

import app.waste_disposal.contracts.ProcessingData;
import app.waste_disposal.contracts.Waste;

public class StorableGarbageDisposalStrategy extends BaseGarbageDisposalStrategy {

    @Override
    public ProcessingData processGarbage(Waste garbage) {
        super.setEnergyUsed(super.getTotalGarbageVolume(garbage)*0.13);
        super.setCapitalUsed(super.getTotalGarbageVolume(garbage)*0.65);

        return super.getProcessingData();
    }

}
