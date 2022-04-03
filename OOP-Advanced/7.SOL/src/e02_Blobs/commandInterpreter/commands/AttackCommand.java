package e02_Blobs.commandInterpreter.commands;

import e02_Blobs.commandInterpreter.CommandInterpreter;
import e02_Blobs.interfaces.Blob;

public class AttackCommand extends CommandImpl {

    public AttackCommand(CommandInterpreter commandInterpreter) {
        super(commandInterpreter);
    }

    @Override
    public void execute(String... params) {
        Blob attacker = super.getRepository().getBlobByName(params[0]);
        Blob target = super.getRepository().getBlobByName(params[1]);
        this.getRepository().updateStats();
        attacker.attack(target);
    }
}
