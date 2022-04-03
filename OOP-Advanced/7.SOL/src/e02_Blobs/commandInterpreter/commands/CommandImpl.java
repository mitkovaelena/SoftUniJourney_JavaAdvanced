package e02_Blobs.commandInterpreter.commands;

import e02_Blobs.commandInterpreter.CommandInterpreter;
import e02_Blobs.interfaces.Command;
import e02_Blobs.interfaces.Repository;

public abstract class CommandImpl implements Command {
    private CommandInterpreter commandInterpreter;

    protected CommandImpl(CommandInterpreter commandInterpreter) {
        this.commandInterpreter = commandInterpreter;
    }

    protected Repository getRepository() {
        return this.commandInterpreter.getRepository();
    }
}
