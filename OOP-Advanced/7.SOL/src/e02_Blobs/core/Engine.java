package e02_Blobs.core;

import e02_Blobs.commandInterpreter.CommandInterpreter;
import e02_Blobs.interfaces.InputReader;
import e02_Blobs.io.ConsoleInputReader;
import e02_Blobs.io.ConsoleOutputWriter;

import java.lang.reflect.InvocationTargetException;

public class Engine {
    private InputReader inputReader;
    private CommandInterpreter commandInterpreter;

    public Engine() {
        this.inputReader = new ConsoleInputReader();
        this.commandInterpreter = new CommandInterpreter(new ConsoleOutputWriter(), new BlobsRepository());
    }

    public void run() {
        String command;

        while (!"drop".equals(command = this.inputReader.readLine())) {
            try {
                this.commandInterpreter.interpretCommand(command);
            } catch (ClassNotFoundException | InvocationTargetException | InstantiationException | IllegalAccessException | NoSuchMethodException e) {
                e.printStackTrace();
            }

        }
    }

}
