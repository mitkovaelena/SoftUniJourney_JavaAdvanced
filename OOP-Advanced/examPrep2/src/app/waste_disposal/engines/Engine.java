package app.waste_disposal.engines;


import app.waste_disposal.commands.Executable;
import app.waste_disposal.core.ManagingSystemImpl;
import app.waste_disposal.factory.GarbageFactoryImpl;
import app.waste_disposal.interpreters.CommandInterpreter;
import app.waste_disposal.interpreters.Interpreter;
import app.waste_disposal.io.ConsoleReader;
import app.waste_disposal.io.ConsoleWriter;
import app.waste_disposal.io.Reader;
import app.waste_disposal.io.Writer;
import app.waste_disposal.DefaultGarbageProcessor;
import app.waste_disposal.DefaultStrategyHolder;

import java.lang.reflect.InvocationTargetException;

public class Engine implements Runnable{
    private Reader inputReader;
    private Writer outputWriter;
    private Interpreter commandInterpreter;

    public Engine() {
        this.inputReader = new ConsoleReader();
        this.outputWriter = new ConsoleWriter();
        this.commandInterpreter = new CommandInterpreter(
                new ManagingSystemImpl(
                        new DefaultGarbageProcessor(new DefaultStrategyHolder()),
                        new GarbageFactoryImpl()
                ));
    }

    public void run() {
        String command;

        while (!"TimeToRecycle".equals(command = this.inputReader.read())) {
            try {
                Executable executable = this.commandInterpreter.interpretCommand(command);
                this.outputWriter.write(executable.execute());
            } catch (ClassNotFoundException | InvocationTargetException | InstantiationException | IllegalAccessException | NoSuchMethodException e) {
                this.outputWriter.write(e.getMessage());
            }

        }
    }

}

