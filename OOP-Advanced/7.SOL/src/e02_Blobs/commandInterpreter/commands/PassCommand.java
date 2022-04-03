package e02_Blobs.commandInterpreter.commands;

import e02_Blobs.commandInterpreter.CommandInterpreter;

public class PassCommand extends CommandImpl {

    public PassCommand(CommandInterpreter commandInterpreter) {
        super(commandInterpreter);
    }

    @Override
    public void execute(String... params) {
        this.getRepository().updateStats();
    }
}
