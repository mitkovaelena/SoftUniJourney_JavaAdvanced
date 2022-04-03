package models.centers;

public interface EmergencyCenter {
    String getName();

    Integer getAmountOfMaximumEmergencies();

    Boolean isForRetirement();

    int getProcessedEmergencies();

    void processedEmergency();
}
