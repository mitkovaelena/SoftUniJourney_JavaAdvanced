package SystemSplit.Components;

public abstract class Component {
    private String name;
    private String type;

    public Component() {
    }

    protected Component(String name, String type) {
        this.setName(name);
        this.setType(type);
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public abstract int getCapacity();

    public abstract int getMemory();
}
