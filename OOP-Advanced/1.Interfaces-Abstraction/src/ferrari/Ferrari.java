package ferrari;

public class Ferrari implements Car{
private String driver;
private final String model = "488-Spider";

    public Ferrari(String driver) {
        this.driver = driver;
    }

    public String getModel() {
        return model;
    }

    public String getDriver() {
        return driver;
    }

    @Override
    public String getBrakes() {
        return brakes;
    }

    @Override
    public String getGasPedal() {
        return gasPedal;
    }
}
