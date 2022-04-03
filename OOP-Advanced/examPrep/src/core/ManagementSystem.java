package core;

import models.centers.EmergencyCenter;
import models.emergencies.Emergency;

public interface ManagementSystem {
    String registerPropertyEmergency(Emergency emergency);

    String registerHealthEmergency(Emergency emergency);

    String registerOrderEmergency(Emergency emergency);

    String registerFireServiceCenter(EmergencyCenter emergencyCenter);

    String registerMedicalServiceCenter(EmergencyCenter emergencyCente);

    String registerPoliceServiceCenter(EmergencyCenter emergencyCente);

    String processEmergencies(String type);

    String emergencyReport();
}
