package frc.robot.Systems;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkMaxConfig;

import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.Command;

import frc.robot.Configs.DriveSystemConfig;

public class DriveSystem extends SubsystemBase {
    /* CREATING VARIABLES FOR DIFFERENT THINGS */
    // Creating 'drive'
    private DifferentialDrive robotDrive;
    private InstrumentSystem instrumentsystem = new InstrumentSystem();

    // Creating all the different SparkMaxes for driving motors
    private final SparkMax rightMotorA = new SparkMax(1, SparkMax.MotorType.kBrushed);
    private final SparkMax rightMotorB = new SparkMax(2, SparkMax.MotorType.kBrushed);
    private final SparkMax leftMotorA = new SparkMax(3, SparkMax.MotorType.kBrushed);
    private final SparkMax leftMotorB = new SparkMax(4, SparkMax.MotorType.kBrushed);
    
    @SuppressWarnings("removal")
    public void driveSystemInit() {
        SparkMaxConfig rightLeaderConfig = new SparkMaxConfig();
        rightLeaderConfig.inverted(true);
        rightMotorA.configure(rightLeaderConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    
        /* CONFIGURING THE FOLLOWER MOTORS */
        // On right side, motor B follows motor A
        SparkMaxConfig followerConfigRight = new SparkMaxConfig();
        followerConfigRight.follow(rightMotorA.getDeviceId(), false);
        rightMotorB.configure(followerConfigRight, ResetMode.kResetSafeParameters, PersistMode.kNoPersistParameters);
        
        // On left side, motor B follows motor A
        SparkMaxConfig followerConfigLeft = new SparkMaxConfig();
        followerConfigLeft.follow(leftMotorA.getDeviceId(), false); 
        leftMotorB.configure(followerConfigLeft, ResetMode.kResetSafeParameters, PersistMode.kNoPersistParameters);
    
        /* SETTING UP THE DRIVE TRAIN */
        // Setting up what motors are going to be used in 'drive' control system
        robotDrive = new DifferentialDrive(leftMotorA::set, rightMotorA::set); 
    
    }
    
    public Command drive(double speedInput, double turnInput) {

        return run(() -> {

            double trueSpeed = speedInput * DriveSystemConfig.SpeedDivisor;
            double trueTurn  = turnInput  * DriveSystemConfig.TurnDivisor;

            robotDrive.arcadeDrive(-trueSpeed, trueTurn);

        }).finallyDo(interrupted -> {
            robotDrive.arcadeDrive(0, 0);
        });
    }
     
        
    public Command forward(double metresTarget) {

        double time = (metresTarget + 0.66) / 0.565;
        double kp = 1;

        return run(() -> {

            double yaw = instrumentsystem.gyro.getYaw();
            double correction = kp * -yaw / 180;

            robotDrive.arcadeDrive(0.5, correction);

        }).withTimeout(time)
          .finallyDo(interrupted -> {
              robotDrive.arcadeDrive(0, 0);
          });
    }

    
    public Command turn(double targetDegrees) {

        double kP = 0.01; // you will tune this

        return run(() -> {

            double currentYaw = instrumentsystem.gyro.getYaw();
            double error = targetDegrees - currentYaw;

            double turnSpeed = kP * error;

            // Optional clamp so it doesn’t spin too fast
            turnSpeed = Math.max(-0.6, Math.min(0.6, turnSpeed));

            robotDrive.arcadeDrive(0, turnSpeed);

        })
        .until(() -> 
            Math.abs(targetDegrees - instrumentsystem.gyro.getYaw()) < 2
        )
        .finallyDo(interrupted -> {
            robotDrive.arcadeDrive(0, 0);
        });
}


}
