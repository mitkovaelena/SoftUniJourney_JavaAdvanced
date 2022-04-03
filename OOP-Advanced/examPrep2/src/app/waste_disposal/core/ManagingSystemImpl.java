package app.waste_disposal.core;

import app.waste_disposal.contracts.GarbageProcessor;
import app.waste_disposal.contracts.ProcessingData;
import app.waste_disposal.contracts.Waste;
import app.waste_disposal.factory.GarbageFactory;
import app.waste_disposal.models.data.ManagementRequirement;
import app.waste_disposal.models.data.ManagementRequirementImpl;

import java.lang.reflect.InvocationTargetException;

public class ManagingSystemImpl implements ManagingSystem {
    private static final String WASTE_PACKAGE = "app.waste_disposal.models.waste.";
    private static final String GARBAGE_STRING = "Garbage";

    private double energyBalance;
    private double capitalBalance;
    private GarbageProcessor garbageProcessor;
    private GarbageFactory garbageFactory;
    private ManagementRequirement managementRequirement;

    public ManagingSystemImpl(GarbageProcessor garbageProcessor, GarbageFactory garbageFactory) {
        this.garbageProcessor = garbageProcessor;
        this.garbageFactory = garbageFactory;
        this.managementRequirement = null;
    }

    private double getEnergyBalance() {
        return energyBalance;
    }

    private double getCapitalBalance() {
        return capitalBalance;
    }

    private void setEnergyBalance(double energyBalance) {
        this.energyBalance += energyBalance;
    }

    private void setCapitalBalance(double capitalBalance) {
        this.capitalBalance += capitalBalance;
    }


    @Override
    public Waste createGarbage(String name, double weight, double volumePerKg, String type) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        return this.garbageFactory.createGarbage(name, weight, volumePerKg, type);
    }

    @Override
    public String processGarbage(Waste garbage) throws ClassNotFoundException {
        if (this.isForProcessing(garbage)) {
            ProcessingData processingData = this.garbageProcessor.processWaste(garbage);
            this.setEnergyBalance(processingData.getEnergyBalance());
            this.setCapitalBalance(processingData.getCapitalBalance());

            return String.format("%.2f kg of %s successfully processed!", garbage.getWeight(), garbage.getName());
        }
        return "Processing Denied!";
    }

    @Override
    public String getStatus() {
        return String.format("Energy: %.2f Capital: %.2f", this.getEnergyBalance(), this.getCapitalBalance());
    }

    public String changeManagementRequirement(double energyBalance, double capitalBalance, String garbageType) {
      this.managementRequirement = new ManagementRequirementImpl(energyBalance, capitalBalance, garbageType);
        return "Management requirement changed!";
    }

    private boolean isForProcessing(Waste garbage) throws ClassNotFoundException {
        Class typeClass = garbage.getClass();
        if (this.managementRequirement == null || (this.getEnergyBalance() > this.managementRequirement.getMinEnergyBalance() && this.getCapitalBalance() > this.managementRequirement.getMinCapitalBalance())){
            return true;
        }
        Class deniedWasteTypeClass = Class.forName(WASTE_PACKAGE + this.managementRequirement.getDeniedGarbage() + GARBAGE_STRING);

        return !deniedWasteTypeClass.equals(typeClass);
    }
}
