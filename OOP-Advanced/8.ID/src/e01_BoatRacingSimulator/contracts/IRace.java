package e01_BoatRacingSimulator.contracts;

import e01_BoatRacingSimulator.exeptions.DuplicateModelException;

import java.util.List;

public interface IRace
{
    int getDistance();

    int getWindSpeed ();

    int getOceanCurrentSpeed();

    Boolean getAllowsMotorboats ();

    void addParticipant(IBoat boat) throws DuplicateModelException;

    List<IBoat> getParticipants();
}
