package app.waste_disposal.models.strategies;

import app.waste_disposal.contracts.ProcessingData;
import app.waste_disposal.contracts.Waste;

public class BurnableGarbageDisposalStrategy extends BaseGarbageDisposalStrategy {

    @Override
    public ProcessingData processGarbage(Waste garbage) {
        super.setEnergyProduced(super.getTotalGarbageVolume(garbage));
        super.setEnergyUsed(super.getTotalGarbageVolume(garbage)*0.2);

        return super.getProcessingData();
    }

}
