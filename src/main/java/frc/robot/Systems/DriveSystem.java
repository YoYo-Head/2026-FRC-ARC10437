package frc.robot.Systems;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import com.revrobotics.spark.SparkBase;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.Command;

import frc.robot.Configs.DriveSystemConfig;

import frc.robot.Systems.InstrumentSystem;

@SuppressWarnings("unused")
public class DriveSystem extends SubsystemBase {
    /* CREATING VARIABLES FOR DIFFERENT THINGS */
    // Creating 'drive'
    private DifferentialDrive robotDrive;
    private InstrumentSystem InstrumentSystem = new InstrumentSystem();
    private DriveSystemConfig DSC = new DriveSystemConfig();

    // Creating all the different SparkMaxes for driving motors
    private final SparkMax FRightMotor = new SparkMax(DSC.FRightMotorID, SparkMax.MotorType.kBrushed); // Front Right
    private final SparkMax BRightMotor = new SparkMax(DSC.BRightMotorID, SparkMax.MotorType.kBrushed);
    private final SparkMax FLeftMotor = new SparkMax(DSC.FLeftMotorID, SparkMax.MotorType.kBrushed);  // Front Left
    private final SparkMax BLeftMotor = new SparkMax(DSC.BLeftMotorID, SparkMax.MotorType.kBrushed);

    // Instrument system for gyro
    
    @SuppressWarnings("removal")
    public DriveSystem() {
        /* SETTING UP THE DRIVE TRAIN */
        // Setting up what motors are going to be used in 'drive' control system
        robotDrive = new DifferentialDrive(FRightMotor, FLeftMotor);
        robotDrive.setSafetyEnabled(false);

        /* INCREASING CANBUS IDLE TIME OF MOTORS */
        FRightMotor.setCANTimeout(DSC.CANTimeout);
        BRightMotor.setCANTimeout(DSC.CANTimeout);
        FLeftMotor.setCANTimeout(DSC.CANTimeout);
        BLeftMotor.setCANTimeout(DSC.CANTimeout);

        /* CONFIGURING THE FOLLOWER MOTORS */
        SparkMaxConfig globalConfig = new SparkMaxConfig();
        SparkMaxConfig rightLeaderConfig = new SparkMaxConfig();
        SparkMaxConfig leftLeaderConfig = new SparkMaxConfig();
        SparkMaxConfig rightFollowerConfig = new SparkMaxConfig();
        SparkMaxConfig leftFollowerConfig = new SparkMaxConfig();

        globalConfig
            .smartCurrentLimit(DSC.GlobalSCL)
            .voltageCompensation(DSC.GlobalVC)
            .idleMode(IdleMode.kCoast);

        rightLeaderConfig
            .apply(globalConfig)
            .inverted(true);

        leftLeaderConfig
            .apply(globalConfig)
            .inverted(false);

        // On right side, motor B follows motor A
        rightFollowerConfig
            .apply(globalConfig)
            .follow(FRightMotor);

        // On left side, motor B follows motor A
        leftFollowerConfig
            .apply(globalConfig)
            .follow(FLeftMotor); 

        FRightMotor.configure(rightLeaderConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
        FLeftMotor.configure(leftLeaderConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);

        BRightMotor.configure(rightFollowerConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
        BLeftMotor.configure(leftFollowerConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    
    } 
    
    public void drive(double speedInput, double turnInput) {
        double trueSpeed = speedInput * DSC.SpeedDivisor;
        double trueTurn  = turnInput  * DSC.TurnDivisor;

        robotDrive.arcadeDrive(trueSpeed, -trueTurn);

    }
     
        
    public Command forward(double metresTarget, InstrumentSystem instrumentSystem) {

        double time = (metresTarget + 0.66) / 0.565;

        return run(() -> {

            double yaw = instrumentSystem.gyro.getYaw();
            double correction = DSC.ForwardKP * -yaw / 180;

            robotDrive.arcadeDrive(DSC.ForwardSpeed, correction);

        }).withTimeout(time)
          .finallyDo(interrupted -> {
              robotDrive.arcadeDrive(0, 0);
              DriverStation.reportWarning("forward complete", false);
          });
    }

    
    public Command turn(double targetDegrees, InstrumentSystem instrumentSystem) {

        return run(() -> {

            double currentYaw = instrumentSystem.gyro.getYaw();
            double target = currentYaw - targetDegrees ;

            if (target < 360) return;

            double turnSpeed = DSC.MaxTurnSpeed;

            robotDrive.arcadeDrive(0, turnSpeed);

        })
        .until(() -> 
            Math.abs(targetDegrees - instrumentSystem.gyro.getYaw()) < 2
        )
        .finallyDo(interrupted -> {
            robotDrive.arcadeDrive(0, 0);
            DriverStation.reportWarning("turn complete", false);
        });
}


}
