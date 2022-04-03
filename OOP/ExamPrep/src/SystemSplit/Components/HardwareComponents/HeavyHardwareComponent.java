package SystemSplit.Components.HardwareComponents;

public class HeavyHardwareComponent extends HardwareComponent {


    public HeavyHardwareComponent(String name, int capacity, int memory) {
        super(name, "Heavy");
        this.setMaxCapacity(capacity);
        this.setMaxMemory(memory);
    }

    @Override
    protected void setMaxCapacity(int capacity) {
        capacity *= 2;
        super.setMaxCapacity(capacity);
    }

    @Override
    protected void setMaxMemory(int memory) {
        memory -= memory/4;
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
