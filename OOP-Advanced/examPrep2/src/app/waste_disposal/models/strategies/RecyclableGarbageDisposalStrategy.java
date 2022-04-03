package app.waste_disposal.models.strategies;

import app.waste_disposal.contracts.ProcessingData;
import app.waste_disposal.contracts.Waste;

public class RecyclableGarbageDisposalStrategy extends BaseGarbageDisposalStrategy {

    @Override
    public ProcessingData processGarbage(Waste garbage) {
        super.setEnergyUsed(super.getTotalGarbageVolume(garbage)*0.5);
        super.setCapitalEarned(garbage.getWeight()*400);

        return super.getProcessingData();
    }
}
