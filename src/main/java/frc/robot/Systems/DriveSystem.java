package frc.robot.Systems;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import com.revrobotics.spark.SparkBase;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;

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

        /* CONFIGURING THE FOLLOWER MOTORS */
        SparkMaxConfig globalConfig = new SparkMaxConfig();
        SparkMaxConfig rightLeaderConfig = new SparkMaxConfig();
        SparkMaxConfig leftLeaderConfig = new SparkMaxConfig();
        SparkMaxConfig followerConfigRight = new SparkMaxConfig();
        SparkMaxConfig followerConfigLeft = new SparkMaxConfig();

        globalConfig
            .smartCurrentLimit(50)
            .idleMode(IdleMode.kCoast);

        
        rightLeaderConfig
            .apply(globalConfig)
            .inverted(true);

        leftLeaderConfig
            .apply(globalConfig)
            .inverted(false);

        // On right side, motor B follows motor A
        followerConfigRight
            .apply(globalConfig)
            .follow(FRightMotor);

        // On left side, motor B follows motor A
        followerConfigLeft
            .apply(globalConfig)
            .follow(FLeftMotor); 


        FRightMotor.configure(rightLeaderConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
        FLeftMotor.configure(leftLeaderConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);

        BRightMotor.configure(followerConfigRight, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
        BLeftMotor.configure(followerConfigLeft, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    
        /* SETTING UP THE DRIVE TRAIN */
        // Setting up what motors are going to be used in 'drive' control system
        robotDrive = new DifferentialDrive(FRightMotor, FLeftMotor); 
    
    }
    
    public void drive(double speedInput, double turnInput) {
        double trueSpeed = speedInput * DSC.SpeedDivisor;
        double trueTurn  = turnInput  * DSC.TurnDivisor;

        robotDrive.arcadeDrive(-trueSpeed, trueTurn);

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
          });
    }

    
    public Command turn(double targetDegrees, InstrumentSystem instrumentSystem) {

        return run(() -> {

            double currentYaw = instrumentSystem.gyro.getYaw();
            double error = targetDegrees - currentYaw;

            double turnSpeed = DSC.TurnKP * error;

            turnSpeed = Math.max(-DSC.MaxTurnSpeed, Math.min(DSC.MaxTurnSpeed, turnSpeed));

            robotDrive.arcadeDrive(0, turnSpeed);

        })
        .until(() -> 
            Math.abs(targetDegrees - instrumentSystem.gyro.getYaw()) < 2
        )
        .finallyDo(interrupted -> {
            robotDrive.arcadeDrive(0, 0);
        });
}


}
