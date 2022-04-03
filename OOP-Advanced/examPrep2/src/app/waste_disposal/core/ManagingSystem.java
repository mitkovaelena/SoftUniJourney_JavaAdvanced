package app.waste_disposal.core;

import app.waste_disposal.contracts.Waste;

import java.lang.reflect.InvocationTargetException;

public interface ManagingSystem {
    String processGarbage (Waste garbage) throws ClassNotFoundException;

    String getStatus();

    String changeManagementRequirement(double energyBalance, double capitalBalance, String garbageType);

    Waste createGarbage(String name, double weight, double volumePerKg, String type) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException ;
}
