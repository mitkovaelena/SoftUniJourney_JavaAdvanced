package hell.commands;

import java.lang.reflect.InvocationTargetException;

public interface Executable {
    String execute() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException;
}
