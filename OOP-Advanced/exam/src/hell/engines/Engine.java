package hell.engines;


import hell.commands.Executable;
import hell.core.ManagingSystemImpl;
import hell.interfaces.InputReader;
import hell.interfaces.OutputWriter;
import hell.interpreters.CommandInterpreter;
import hell.interpreters.Interpreter;
import hell.io.ConsoleReader;
import hell.io.ConsoleWriter;

import java.lang.reflect.InvocationTargetException;

public class Engine implements Runnable {
    private InputReader inputReader;
    private OutputWriter outputWriter;
    private Interpreter commandInterpreter;

    public Engine() {
        this.inputReader = new ConsoleReader();
        this.outputWriter = new ConsoleWriter();
        this.commandInterpreter = new CommandInterpreter(new ManagingSystemImpl());
    }

    public void run() {
        String command;

        do {
            command = this.inputReader.readLine();
            try {
                Executable executable = this.commandInterpreter.interpretCommand(command);
                this.outputWriter.writeLine(executable.execute());
            } catch (NoSuchFieldException | ClassNotFoundException | InvocationTargetException | InstantiationException | IllegalAccessException | NoSuchMethodException e) {
                this.outputWriter.writeLine(e.getMessage());
            }
        } while (!"Quit".equals(command));

    }
}

