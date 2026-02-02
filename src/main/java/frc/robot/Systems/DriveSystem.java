package frc.robot.Systems;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;

import java.frc.robot.Configs.DriveSystemConfig;

public class DriveSystem {
    /* CREATING VARIABLES FOR DIFFERENT THINGS */
    // Creating 'drive'
    private DifferentialDrive drive;
    
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
        drive = new DifferentialDrive(leftMotorA::set, rightMotorA::set); 
    


    }
    
}
