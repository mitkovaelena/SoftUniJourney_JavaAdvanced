package app.waste_disposal.interpreters;


import app.waste_disposal.commands.Executable;

import java.lang.reflect.InvocationTargetException;

public interface Interpreter {
    Executable interpretCommand(String command) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException;
}
