package app.waste_disposal.factory;

import app.waste_disposal.contracts.Waste;

import java.lang.reflect.InvocationTargetException;

public interface GarbageFactory {

    Waste createGarbage(String name, double weight, double volumePerKg, String type) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException;

}
