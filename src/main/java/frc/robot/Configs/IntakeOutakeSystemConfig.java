package frc.robot.Configs;

public class IntakeOutakeSystemConfig {
    // Spark Motor CAN Bus IDs
    public int FeederRollerID = 6; // Intake on sparkmax
    public int IntakeLauncherRollerID = 5; // SHOOT on sparkmax

    // Smart Current Limits for Motor
    public int IntakeSCL = 1000;
    public int FeederSCL = 1000;


    // Motor Voltages for Commands
    public double EjectIntakeVoltage = 10;
    public double EjectFeederVoltage = 7;

    public double IntakeIntakeVoltage = -6;
    public double IntakeFeederVoltage = -9;

    public double LaunchIntakeVoltage = 10.6;
    public double LaunchFeederVoltage = 9;

    public double SpinUpIntakeVoltage = 10.6;
    public double SpinUpFeederVoltage = -6;
    
}
