package core;

import collection.EmergencyRegister;
import collection.Register;
import enums.EmergencyType;
import models.centers.EmergencyCenter;
import models.emergencies.Emergency;

import java.util.HashMap;
import java.util.Map;

public class EmergencyManagementSystem implements ManagementSystem {
    private Map<EmergencyType, Register<Emergency>> emergencyRegister;
    private Map<EmergencyType, Register<EmergencyCenter>> emergencyCentersRegister;
    private Map<EmergencyType, Integer> processedEmergencies;
    private int totalProcessedEmergencies;

    public EmergencyManagementSystem() {
        this.emergencyRegister = new HashMap<>();
        this.emergencyCentersRegister = new HashMap<>();
        this.processedEmergencies = new HashMap<>();
        initialiseMaps();
    }

    @Override
    public String registerPropertyEmergency(Emergency emergency) {
        this.emergencyRegister.get(EmergencyType.PROPERTY).enqueueEmergency(emergency);

        StringBuilder sb = new StringBuilder("Registered Public Property Emergency of level ");
        sb.append(emergency.getEmergencyLevel()).append(" at ").append(emergency.getRegistrationTime()).append(".");
        return sb.toString();
    }

    @Override
    public String registerHealthEmergency(Emergency emergency) {
        this.emergencyRegister.get(EmergencyType.HEALTH).enqueueEmergency(emergency);

        StringBuilder sb = new StringBuilder("Registered Public Health Emergency of level ");
        sb.append(emergency.getEmergencyLevel()).append(" at ").append(emergency.getRegistrationTime()).append(".");
        return sb.toString();
    }

    @Override
    public String registerOrderEmergency(Emergency emergency) {
        this.emergencyRegister.get(EmergencyType.ORDER).enqueueEmergency(emergency);

        StringBuilder sb = new StringBuilder("Registered Public Order Emergency of level ");
        sb.append(emergency.getEmergencyLevel()).append(" at ").append(emergency.getRegistrationTime()).append(".");
        return sb.toString();
    }

    @Override
    public String registerFireServiceCenter(EmergencyCenter emergencyCenter) {
        this.emergencyCentersRegister.get(EmergencyType.PROPERTY).enqueueEmergency(emergencyCenter);

        StringBuilder sb = new StringBuilder("Registered Fire Service Emergency Center - ");
        sb.append(emergencyCenter.getName()).append(".");
        return sb.toString();
    }

    @Override
    public String registerMedicalServiceCenter(EmergencyCenter emergencyCenter) {
        this.emergencyCentersRegister.get(EmergencyType.HEALTH).enqueueEmergency(emergencyCenter);

        StringBuilder sb = new StringBuilder("Registered Medical Service Emergency Center - ");
        sb.append(emergencyCenter.getName()).append(".");
        return sb.toString();
    }

    @Override
    public String registerPoliceServiceCenter(EmergencyCenter emergencyCenter) {
        this.emergencyCentersRegister.get(EmergencyType.ORDER).enqueueEmergency(emergencyCenter);

        StringBuilder sb = new StringBuilder("Registered Police Service Emergency Center - ");
        sb.append(emergencyCenter.getName()).append(".");
        return sb.toString();
    }

    @Override
    public String processEmergencies(String type) {
        Register centerRegistry = this.emergencyCentersRegister.get(Enum.valueOf(EmergencyType.class, type.toUpperCase()));
        Register emergencyRegistry = this.emergencyRegister.get(Enum.valueOf(EmergencyType.class, type.toUpperCase()));

        while (!centerRegistry.isEmpty()) {
            if (emergencyRegistry.isEmpty()) {
                break;
            }
            Emergency emergency = (Emergency) emergencyRegistry.dequeueEmergency();
            processEmergency(emergency, Enum.valueOf(EmergencyType.class, type.toUpperCase()));

            EmergencyCenter emergencyCenter = (EmergencyCenter) centerRegistry.dequeueEmergency();
            emergencyCenter.processedEmergency();

            if (!emergencyCenter.isForRetirement()) {
                centerRegistry.enqueueEmergency(emergencyCenter);
            }
        }
        StringBuilder sb = new StringBuilder();
        if (emergencyRegistry.isEmpty()) {
            sb.append("Successfully responded to all ").append(type).append(" emergencies.");
        } else {
            sb.append(type).append(" Emergencies left to process: ").append(emergencyRegistry.getSize()).append(".");
        }

        return sb.toString();
    }

    @Override
    public String emergencyReport() {

        StringBuilder sb = new StringBuilder();
        sb.append("PRRM Services Live Statistics\n")
                .append("Fire Service Centers: ").append(this.emergencyCentersRegister.get(EmergencyType.PROPERTY).getSize())
                .append("\nMedical Service Centers: ").append(this.emergencyCentersRegister.get(EmergencyType.HEALTH).getSize())
                .append("\nPolice Service Centers: ").append(this.emergencyCentersRegister.get(EmergencyType.ORDER).getSize())
                .append("\nTotal Processed Emergencies: ").append(this.totalProcessedEmergencies)
                .append("\nCurrently Registered Emergencies: ").append(this.emergencyRegister.values().stream().mapToInt(Register::getSize).sum())
                .append("\nTotal Property Damage Fixed: ").append(this.processedEmergencies.get(EmergencyType.PROPERTY))
                .append("\nTotal Health Casualties Saved: ").append(this.processedEmergencies.get(EmergencyType.HEALTH))
                .append("\nTotal Special Cases Processed: ").append(this.processedEmergencies.get(EmergencyType.ORDER));
        return sb.toString();
    }

    private void processEmergency(Emergency emergency, EmergencyType type) {
        this.totalProcessedEmergencies++;
        this.processedEmergencies.put(type, this.processedEmergencies.get(type) + (emergency).getResultAfterProcessing());
    }

    private void initialiseMaps() {
        EmergencyType[] emergencyTypes = EmergencyType.values();

        for (EmergencyType emergencyType : emergencyTypes) {
            this.emergencyRegister.put(emergencyType, new EmergencyRegister<Emergency>());
            this.emergencyCentersRegister.put(emergencyType, new EmergencyRegister<EmergencyCenter>());
            this.processedEmergencies.put(emergencyType, 0);
            this.totalProcessedEmergencies = 0;
        }
    }
}
