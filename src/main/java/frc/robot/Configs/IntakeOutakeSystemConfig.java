package frc.robot.Configs;

public class IntakeOutakeSystemConfig {
    // Spark Motor CAN Bus IDs
    public int FeederRollerID = 5; 
    public int IntakeLauncherRollerID = 6; // SHOOT on sparkmax
    public int BackRollerID = 7; // Back intake sytem on sparkmax

    // Smart Current Limits for Motor
    public int IntakeSCL = 1000;
    public int FeederSCL = 1000;

    // Motor Voltages for Commands
    public double EjectIntakeVoltage = -10;
    public double EjectFeederVoltage = 8;

    public double IntakeIntakeVoltage = 7;
    public double IntakeFeederVoltage = -10;
    public double IntakeBackVoltage = -13;

    public double LaunchIntakeVoltage = 10.6;
    public double LaunchFeederVoltage = 9;

    public double SpinUpIntakeVoltage = 10.6;
    public double SpinUpFeederVoltage = -6;

    // positive intake means that the launcher spins in the direction of launching and intake spinning in the direction of outake
    // positive feeder means the feeder spins in the direction of outake
    
}
