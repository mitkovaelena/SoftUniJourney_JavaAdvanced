package app.waste_disposal.models.data;

import app.waste_disposal.contracts.ProcessingData;

public class ProcessingDataImpl implements ProcessingData {

    private double energyBalance;
    private double capitalBalance;

    public ProcessingDataImpl(double energyBalance, double capitalBalance) {
        this.setEnergyBalance(energyBalance);
        this.setCapitalBalance(capitalBalance);
    }

    @Override
    public double getEnergyBalance() {
        return this.energyBalance;
    }

    @Override
    public double getCapitalBalance() {
        return this.capitalBalance;
    }

    private void setEnergyBalance(double energyBalance) {
        this.energyBalance = energyBalance;
    }

    private void setCapitalBalance(double capitalBalance) {
        this.capitalBalance = capitalBalance;
    }
}
