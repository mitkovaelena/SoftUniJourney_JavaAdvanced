package SystemSplit.Components.HardwareComponents;

import SystemSplit.Components.Component;
import SystemSplit.Components.SoftwareComponents.SoftwareComponent;

public abstract class HardwareComponent extends Component {
    private int capacity;
    private int memory;
    private int maxCapacity;
    private int maxMemory;

    public HardwareComponent() {
    }

    protected HardwareComponent(String name, String type) {
        super(name, type);
    }

    public void registerSoftwareComponent(SoftwareComponent softwareComponent){
        if(this.getCapacity()-softwareComponent.getCapacity() >= 0 && this.getMemory()-softwareComponent.getMemory() >= 0 ) {
            this.setCapacity(this.getCapacity() - softwareComponent.getCapacity());
            this.setMemory(this.getMemory() - softwareComponent.getMemory());
        }
        else {
            throw new IllegalArgumentException("Not enough capacity/memory");
        }
    };

    public void removeSoftwareComponent(SoftwareComponent softwareComponent){
        this.setCapacity(this.getCapacity()+softwareComponent.getCapacity());
        this.setMemory(this.getMemory()+softwareComponent.getMemory());
    };

    protected void setMaxCapacity(int capacity) {
        this.maxCapacity = capacity;
        this.setCapacity(capacity);
    }

    protected void setMaxMemory(int memory) {
        this.maxMemory = memory;
        this.setMemory(memory);
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public int getMaxMemory() {
        return maxMemory;
    }

    private void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    private void setMemory(int memory) {
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
