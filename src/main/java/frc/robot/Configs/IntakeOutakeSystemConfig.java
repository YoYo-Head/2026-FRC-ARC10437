package frc.robot.Configs;

public class IntakeOutakeSystemConfig {
    // Spark Motor CAN Bus IDs
    public int FeederRollerID = 5;
    public int IntakeLauncherRollerID = 6;

    // Smart Current Limits for Motor
    public int IntakeSCL = 1000;
    public int FeederSCL = 1000;


    // Motor Voltages for Commands
    public double EjectIntakeVoltage = 10;
    public double EjectFeederVoltage = -12;

    public double IntakeIntakeVoltage = 10;
    public double IntakeFeederVoltage = 9;

    public double LaunchIntakeVoltage = 10.6;
    public double LaunchFeederVoltage = 9;

    public double SpinUpIntakeVoltage = 10.6;
    public double SpinUpFeederVoltage = -6;
    
}
