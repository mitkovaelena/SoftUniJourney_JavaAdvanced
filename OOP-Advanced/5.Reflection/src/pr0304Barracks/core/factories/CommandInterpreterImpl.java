package pr0304Barracks.core.factories;

import pr0304Barracks.contracts.*;

import java.lang.reflect.Constructor;

public class CommandInterpreterImpl implements CommandInterpreter {

    private static final String COMMANDS_PACKAGE = "pr0304Barracks.core.commands.";
    private Repository repository;
    private UnitFactory unitFactory;

    public CommandInterpreterImpl(Repository repository, UnitFactory unitFactory) {
        this.repository = repository;
        this.unitFactory = unitFactory;
    }

    @Override
    public Executable interpretCommand(String[] data, String commandName) {
        try {
            commandName = Character.toUpperCase(commandName.charAt(0))+ commandName.substring(1);
            Class<Executable> commandClass = (Class<Executable>) Class.forName(COMMANDS_PACKAGE + commandName );
            Constructor constructor = commandClass.getDeclaredConstructor(String[].class,
                    Repository.class, UnitFactory.class);
            Executable executable = (Executable) constructor.newInstance(data, this.repository, this.unitFactory);
            return executable;
        } catch (ClassNotFoundException cnfe) {
            throw new RuntimeException("Invalid command!");
        } catch (Exception e) {
            throw new RuntimeException("Something went wrong");
        }
    }
}
