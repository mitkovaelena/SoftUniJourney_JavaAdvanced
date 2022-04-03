package e01_BoatRacingSimulator.Core;

import e01_BoatRacingSimulator.contracts.ICommandHandler;
import e01_BoatRacingSimulator.database.BoatSimulatorDatabase;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Engine {
    private CommandHandler commandHandler;

    public Engine(CommandHandler commandHandler)
    {
        this.commandHandler = commandHandler;
    }

    public Engine()
    {
        this.commandHandler = new CommandHandler(new BoatSimulatorDatabase());
    }

    public ICommandHandler getCommandHandler;

    public void run()
    {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        List<String> parameters;

        while (!line.equals("End"))
        {
            String name = "";

            List<String> tokens = Arrays.asList(line.split("\\\\"));
            name = tokens.get(0);
            parameters = tokens.stream().skip(1).collect(Collectors.toList());

            try
            {
                String commandResult = this.commandHandler.executeCommand(name, parameters);
                System.out.println(commandResult);
            }
            catch (Exception ex)  //ToDo
            {
                System.out.println(ex.getMessage());
            }
            line = scanner.nextLine();
        }
    }
}
