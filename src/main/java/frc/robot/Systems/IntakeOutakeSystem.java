package frc.robot.Systems;

import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.SparkMax;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakeOutakeSystem extends SubsystemBase {
    private final SparkMax feederRoller = new SparkMax(5, MotorType.kBrushed);
    private final SparkMax intakeLauncherRoller = new SparkMax(6, MotorType.kBrushed);

    @SuppressWarnings("removal")
    public void intakeOutakeSystemInit() {
        SparkMaxConfig feederConfig = new SparkMaxConfig();
        //feederConfig.smartCurrentLimit(1000);
        feederRoller.configure(feederConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);

        SparkMaxConfig launcherConfig = new SparkMaxConfig();
        launcherConfig.inverted(true);
        //launcherConfig.smartCurrentLimit(1000);
        intakeLauncherRoller.configure(launcherConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    }

    public void setIntakeSpeed(double voltage) {
        intakeLauncherRoller.setVoltage(voltage);

    }

    public void setFeederSpeed(double voltage) {
        feederRoller.setVoltage(voltage);

    }

    public void stop() {
        intakeLauncherRoller.setVoltage(0);
        feederRoller.setVoltage(0);
    }
    
}