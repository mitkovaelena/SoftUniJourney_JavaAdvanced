package e02_Blobs.commandInterpreter;

import e02_Blobs.interfaces.Command;
import e02_Blobs.interfaces.OutputWriter;
import e02_Blobs.interfaces.Repository;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class CommandInterpreter {
    private static final String COMMANDS_PACKAGE = "e02_Blobs.commandInterpreter.commands.";

    private OutputWriter writer;
    private Repository repository;

    public CommandInterpreter(OutputWriter writer, Repository repository) {
        this.writer = writer;
        this.repository = repository;
    }

    public Repository getRepository() {
        return repository;
    }

    public OutputWriter getOutputWriter() {
        return writer;
    }

    public void interpretCommand(String command) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        String[] commandArgs = command.split(" ");
        String commandName = commandArgs[0].substring(0,1).toUpperCase() + commandArgs[0].substring(1) + "Command";

        String[] params = new String[commandArgs.length-1];
        for (int i = 0; i < params.length; i++) {
            params[i] = commandArgs[i+1];
        }

        executeCommand(commandName, params);
    }

    public void executeCommand(String commandName, String... params) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class<Command> commandClass = (Class<Command>) Class.forName(COMMANDS_PACKAGE + commandName);
        Constructor<Command> constructor = commandClass.getDeclaredConstructor(CommandInterpreter.class);
        Command command = constructor.newInstance(this);
        command.execute(params);
    }
}
