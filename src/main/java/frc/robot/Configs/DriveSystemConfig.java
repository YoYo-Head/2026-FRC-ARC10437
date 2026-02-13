package frc.robot.Configs;

public class DriveSystemConfig {
    // Spark Motor CAN Bus IDs
    public int FLeftMotorID = 1;
    public int FRightMotorID = 2;
    public int BLeftMotorID = 3;
    public int BRightMotorID = 4;

    // drive() variables
    public double SpeedDivisor = 1;
    public double TurnDivisor = 0.75;

    // forward() variables
    public int ForwardKP = 1;
    public double ForwardSpeed = 0.5;

    // turn() variables
    public double TurnKP = 0.01;
    public double MaxTurnSpeed = 0.6;

}
