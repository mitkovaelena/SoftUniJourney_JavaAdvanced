package enums;

public enum EmergencyLevel {
    MINOR,
    MAJOR,
    DISASTER;

    @Override
    public String toString() {
        return super.name().charAt(0) + super.name().substring(1).toLowerCase();
    }
}
