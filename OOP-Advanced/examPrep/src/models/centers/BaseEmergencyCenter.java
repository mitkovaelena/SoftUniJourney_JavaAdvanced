package models.centers;

public abstract class BaseEmergencyCenter implements EmergencyCenter {
    private String name;

    private Integer amountOfMaximumEmergencies;

    private int processedEmergencies;

    protected BaseEmergencyCenter(String name, Integer amountOfMaximumEmergencies) {
        this.setName(name);
        this.setAmountOfMaximumEmergencies(amountOfMaximumEmergencies);
        this.processedEmergencies = 0;
    }

    @Override
    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    @Override
    public Integer getAmountOfMaximumEmergencies() {
        return amountOfMaximumEmergencies;
    }

    private void setAmountOfMaximumEmergencies(Integer amountOfMaximumEmergencies) {
        this.amountOfMaximumEmergencies = amountOfMaximumEmergencies;
    }

    @Override
    public int getProcessedEmergencies() {
        return this.processedEmergencies;
    }

    @Override
    public void processedEmergency() {
        this.processedEmergencies++;
    }

    @Override
    public Boolean isForRetirement() {
        return this.getProcessedEmergencies() == this.getAmountOfMaximumEmergencies();
    }
}
