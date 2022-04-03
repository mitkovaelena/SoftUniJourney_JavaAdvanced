package e02_Blobs.commandInterpreter.commands;

import e02_Blobs.commandInterpreter.CommandInterpreter;
import e02_Blobs.interfaces.Attack;
import e02_Blobs.interfaces.Behaviour;
import e02_Blobs.interfaces.Blob;
import e02_Blobs.models.blobs.BlobImpl;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class CreateCommand extends CommandImpl {
    private static final String BEHAVIOURS_PACKAGE = "e02_Blobs.models.behaviours.";
    private static final String ATTACKS_PACKAGE = "e02_Blobs.models.attacks.";

    public CreateCommand(CommandInterpreter commandInterpreter) {
        super(commandInterpreter);
    }

    @Override
    public void execute(String... params) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class<Behaviour> behaviourClass = (Class<Behaviour>) Class.forName(BEHAVIOURS_PACKAGE + params[3]);
        Constructor<Behaviour> behaviourConstructor = behaviourClass.getDeclaredConstructor();
        Behaviour behaviour = behaviourConstructor.newInstance();

        Class<Attack> attackClass = (Class<Attack>) Class.forName(ATTACKS_PACKAGE + params[4]);
        Constructor<Attack> attackConstructor = attackClass.getDeclaredConstructor();
        Attack attack = attackConstructor.newInstance();

        Blob blob = new BlobImpl(params[0], Integer.parseInt(params[1]), Integer.parseInt(params[2]), behaviour, attack);
        this.getRepository().add(blob);
        this.getRepository().updateStats();
    }

}
