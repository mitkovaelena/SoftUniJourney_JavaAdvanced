package SystemSplit.Components.SoftwareComponents;

public class LightSoftwareComponent extends SoftwareComponent {

    public LightSoftwareComponent(String name, int capacity, int memory) {
        super(name, "Light");
        this.setCapacity(capacity);
        this.setMemory(memory);
    }

    @Override
    protected void setCapacity(int capacity) {
        capacity += capacity/2;
        super.setCapacity(capacity);
    }

    @Override
    protected void setMemory(int memory) {
        memory -= memory/2;
        super.setMemory(memory);
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
