package app.waste_disposal.models.strategies;

import app.waste_disposal.contracts.GarbageDisposalStrategy;
import app.waste_disposal.contracts.ProcessingData;
import app.waste_disposal.contracts.Waste;
import app.waste_disposal.models.data.ProcessingDataImpl;

public abstract class BaseGarbageDisposalStrategy implements GarbageDisposalStrategy {
    private double energyProduced;
    private double energyUsed;
    private double capitalEarned;
    private double capitalUsed;

    private double getEnergyProduced() {
        return energyProduced;
    }

    void setEnergyProduced(double energyProduced) {
        this.energyProduced = energyProduced;
    }

    private double getEnergyUsed() {
        return energyUsed;
    }

    void setEnergyUsed(double energyUsed) {
        this.energyUsed = energyUsed;
    }

    private double getCapitalEarned() {
        return capitalEarned;
    }

    void setCapitalEarned(double capitalEarned) {
        this.capitalEarned = capitalEarned;
    }

    private double getCapitalUsed() {
        return capitalUsed;
    }

    void setCapitalUsed(double capitalUsed) {
        this.capitalUsed = capitalUsed;
    }

    double getTotalGarbageVolume(Waste garbage){
        return  garbage.getWeight() * garbage.getVolumePerKg();
    }

    ProcessingData getProcessingData(){
        return new ProcessingDataImpl(this.getEnergyBalance(), this.getCapitalBalance());
    }

    private double getEnergyBalance(){
        return this.getEnergyProduced()-this.getEnergyUsed();
    }

    private double getCapitalBalance(){
        return this.getCapitalEarned()-this.getCapitalUsed();
    }
}
