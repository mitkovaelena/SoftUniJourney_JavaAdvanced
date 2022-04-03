package app.waste_disposal.interpreters;

import app.waste_disposal.annotations.InjectArgs;
import app.waste_disposal.commands.Executable;
import app.waste_disposal.core.ManagingSystem;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class CommandInterpreter implements Interpreter {
    private static final String COMMANDS_PACKAGE = "app.waste_disposal.commands.";
    private static final String COMMAND_STRING = "Command";

    private ManagingSystem managingSystem;

    public CommandInterpreter(ManagingSystem managingSystem) {
        this.managingSystem = managingSystem;
    }

    public ManagingSystem getManagingSystem() {
        return managingSystem;
    }

    @Override
    public Executable interpretCommand(String command) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        String[] commandArgs = command.split("[|\\s]+");

        String commandName = commandArgs[0];
        String[] params = new String[commandArgs.length-1];

        if (commandArgs.length > 1) {
            System.arraycopy(commandArgs, 1, params, 0, params.length);
        }

        return executeCommand(commandName, params);
    }

    private Executable executeCommand(String commandName, String[] params) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class<Executable> commandClass = (Class<Executable>) Class.forName(COMMANDS_PACKAGE + commandName + COMMAND_STRING);
        Constructor<Executable> constructor = commandClass.getDeclaredConstructor(ManagingSystem.class);
        Executable command = constructor.newInstance(this.getManagingSystem());
        this.injectDependencies(command, params);
        return command;
    }

    private void injectDependencies(Executable command, String[] params) throws IllegalAccessException {
        Field[] fields = command.getClass().getDeclaredFields();

        for (Field field : fields) {
            if (field.isAnnotationPresent(InjectArgs.class)) {
                field.setAccessible(true);
                field.set(command, params);
                return;
            }
        }
    }
}
