package app.waste_disposal.factory;

import app.waste_disposal.contracts.Waste;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class GarbageFactoryImpl implements GarbageFactory {
    private static final String WASTE_PACKAGE = "app.waste_disposal.models.waste.";
    private static final String GARBAGE_STRING = "Garbage";

    @Override
    public Waste createGarbage(String name, double weight, double volumePerKg, String type) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        Class<Waste> wasteClass = (Class<Waste>) Class.forName(WASTE_PACKAGE + type + GARBAGE_STRING);
        Constructor<Waste> constructor = wasteClass.getDeclaredConstructor(String.class, double.class, double.class);
        return constructor.newInstance(name,weight,volumePerKg);
    }
}
