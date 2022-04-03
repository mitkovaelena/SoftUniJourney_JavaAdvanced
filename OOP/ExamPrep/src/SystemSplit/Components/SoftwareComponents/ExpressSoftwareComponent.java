package SystemSplit.Components.SoftwareComponents;

public class ExpressSoftwareComponent extends SoftwareComponent {

    public ExpressSoftwareComponent(String name, int capacity, int memory) {
        super(name, "Express");
        this.setCapacity(capacity);
        this.setMemory(memory);
    }

    @Override
    protected void setCapacity(int capacity) {
        super.setCapacity(capacity);
    }

    @Override
    protected  void setMemory(int memory) {
        memory *= 2;
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
