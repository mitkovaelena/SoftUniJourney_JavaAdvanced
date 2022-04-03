package SystemSplit.Components.HardwareComponents;

public class PowerHardwareComponent extends HardwareComponent {

    public PowerHardwareComponent(String name, int capacity, int memory) {
        super(name, "Power");
        this.setMaxCapacity(capacity);
        this.setMaxMemory(memory);
    }

    @Override
    protected void setMaxCapacity(int capacity) {
        capacity -= (capacity*3)/4;
        super.setMaxCapacity(capacity);
    }

    @Override
    protected void setMaxMemory(int memory) {
        memory += (memory*3)/4;
        super.setMaxMemory(memory);
    }

    @Override
    public int getCapacity() {
        return super.getCapacity();
    }

    @Override
    public int getMemory() {
        return super.getMemory();
    }
}
