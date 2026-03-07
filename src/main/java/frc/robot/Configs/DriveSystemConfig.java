package frc.robot.Configs;

public class DriveSystemConfig {
    // Spark Motor CAN Bus IDs
    public int FLeftMotorID = 2;
    public int FRightMotorID = 1;
    public int BLeftMotorID = 4;
    public int BRightMotorID = 3;

    // SparkMax Configs
    public int GlobalSCL = 50;
    public int GlobalVC = 12;
    public int CANTimeout = 250;

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
