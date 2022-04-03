package app.waste_disposal.commands;

import app.waste_disposal.annotations.InjectArgs;
import app.waste_disposal.core.ManagingSystem;
import app.waste_disposal.contracts.Waste;

import java.lang.reflect.InvocationTargetException;

public class ProcessGarbageCommand extends BaseCommand {

    @InjectArgs
    private String[] params;
    private Waste garbage;

    public ProcessGarbageCommand(ManagingSystem managingSystem) {
        super(managingSystem);
    }

    @Override
    public String execute() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        String name = this.params[0];
        double weight = Double.parseDouble(this.params[1]);
        double volumePerKg = Double.parseDouble(this.params[2]);
        String type = this.params[3];

        this.garbage = super.getManagingSystem().createGarbage(name,weight,volumePerKg,type);

        return super.getManagingSystem().processGarbage(this.garbage);
    }
}
