package e02_Blobs.commandInterpreter.commands;

import e02_Blobs.commandInterpreter.CommandInterpreter;
import e02_Blobs.interfaces.Blob;
import e02_Blobs.interfaces.OutputWriter;

public class StatusCommand extends CommandImpl {
    private OutputWriter writer;

    public StatusCommand(CommandInterpreter commandInterpreter) {
        super(commandInterpreter);
        this.writer = commandInterpreter.getOutputWriter();
    }

    @Override
    public void execute(String... params) {
        writer.write(this.toString());
        this.getRepository().updateStats();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for(Blob blob : super.getRepository().getAllBlobs()){
            if(blob.getHealth() > 0) {
                sb.append("Blob " + blob.getName() + ": " + blob.getHealth() + " HP, " + blob.getDamage() + " Damage\n");
            } else {
                sb.append("Blob " + blob.getName() + " KILLED\n");
            }
        }
        return sb.toString();
    }
}
