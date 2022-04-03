package engines;

import commands.Executable;
import core.EmergencyManagementSystem;
import interpreters.CommandInterpreter;
import interpreters.Interpreter;
import io.ConsoleReader;
import io.ConsoleWriter;
import io.Reader;
import io.Writer;

import java.lang.reflect.InvocationTargetException;

public class Engine implements Runnable{
    private Reader inputReader;
    private Writer outputWriter;
    private Interpreter commandInterpreter;

    public Engine() {
        this.inputReader = new ConsoleReader();
        this.outputWriter = new ConsoleWriter();
        this.commandInterpreter = new CommandInterpreter(new EmergencyManagementSystem());
    }

    public void run() {
        String command;

        while (!"EmergencyBreak".equals(command = this.inputReader.read())) {
            try {
                Executable executable = this.commandInterpreter.interpretCommand(command);
                this.outputWriter.write(executable.execute());
            } catch (ClassNotFoundException | InvocationTargetException | InstantiationException | IllegalAccessException | NoSuchMethodException e) {
                e.printStackTrace();
            }

        }
    }

}

