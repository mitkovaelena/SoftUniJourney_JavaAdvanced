package e01_BoatRacingSimulator.contracts;

public interface IBoat extends IModelable{

    boolean isMotorBoat();
    double calculateRaceSpeed(IRace race);
}
