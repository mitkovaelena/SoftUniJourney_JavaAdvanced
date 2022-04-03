package SystemSplit.Components.SoftwareComponents;

import SystemSplit.Components.Component;

public abstract class SoftwareComponent extends Component {
    private int capacity;
    private int memory;

    public SoftwareComponent() {
    }

    protected SoftwareComponent(String name, String type) {
        super(name, type);
    }

    protected void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    protected void setMemory(int memory) {
        this.memory = memory;
    }

    @Override
    public int getCapacity() {
        return this.capacity;
    }

    @Override
    public int getMemory() {
        return this.memory;
    }

}
