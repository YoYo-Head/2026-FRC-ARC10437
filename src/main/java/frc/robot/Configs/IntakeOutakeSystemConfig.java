package frc.robot.Configs;

public class IntakeOutakeSystemConfig {
    // Spark Motor CAN Bus IDs
    public int FeederRollerID = 6; 
    public int IntakeLauncherRollerID = 5; // SHOOT on sparkmax

    // Smart Current Limits for Motor
    public int IntakeSCL = 1000;
    public int FeederSCL = 1000;

    // Motor Voltages for Commands
    public double EjectIntakeVoltage = 10;
    public double EjectFeederVoltage = 8;

    public double IntakeIntakeVoltage = -10;
    public double IntakeFeederVoltage = -12;

    public double LaunchIntakeVoltage = 11.6;
    public double LaunchFeederVoltage = 9;

    public double SpinUpIntakeVoltage =  11.6;
    public double SpinUpFeederVoltage = -6;

    // positive intake means that the launcher spins in the direction of launching and intake spinning in the direction of outake
    // positive feeder means the feeder spins in the direction of outake
    
}
