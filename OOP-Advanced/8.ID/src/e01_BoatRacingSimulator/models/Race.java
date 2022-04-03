package e01_BoatRacingSimulator.models;

import e01_BoatRacingSimulator.Utility.Constants;
import e01_BoatRacingSimulator.Utility.Validator;
import e01_BoatRacingSimulator.contracts.IBoat;
import e01_BoatRacingSimulator.contracts.IRace;
import e01_BoatRacingSimulator.exeptions.DuplicateModelException;

import java.util.*;

public class Race implements IRace {
    private int distance;
    private int windSpeed;
    private int oseanCurrentSpeed;
    private Boolean allowsMotorBoats;
    private Map<String, IBoat> registeredBoats;

    public Race(int distance, int windSpeed, int oceanCurrentSpeed, Boolean allowsMotorBoats) {
        this.setDistance(distance);
        this.setWindSpeed(windSpeed);
        this.setOseanCurrentSpeed(oceanCurrentSpeed);
        this.setAllowsMotorBoats(allowsMotorBoats);
        this.registeredBoats = new LinkedHashMap<>();
    }

    @Override
    public int getDistance() {
        return distance;
    }

    private void setDistance(int distance) {
        Validator.validatePropertyValue(distance, "Distance");
        this.distance = distance;
    }

    @Override
    public int getWindSpeed() {
        return windSpeed;
    }

    private void setWindSpeed(int windSpeed) {
        this.windSpeed = windSpeed;
    }

    public int getOceanCurrentSpeed() {
        return oseanCurrentSpeed;
    }

    private void setOseanCurrentSpeed(int oseanCurrentSpeed) {
        this.oseanCurrentSpeed = oseanCurrentSpeed;
    }

    public Boolean getAllowsMotorboats() {
        return allowsMotorBoats;
    }

    private void setAllowsMotorBoats(Boolean allowsMotorBoats) {
        this.allowsMotorBoats = allowsMotorBoats;
    }

    protected Map<String, IBoat> getRegisteredBoats() {
        return Collections.unmodifiableMap(this.registeredBoats);
    }

    public void addParticipant(IBoat boat) throws DuplicateModelException {
        if (this.getRegisteredBoats().containsKey(boat.getModel())) {
            throw new DuplicateModelException(Constants.DUPLICATE_MODEL_MESSAGE);
        }
        this.registeredBoats.put(boat.getModel(), boat);
    }

    public List<IBoat> getParticipants() {
        return Collections.unmodifiableList(new ArrayList<IBoat>(this.registeredBoats.values()));
    }
}