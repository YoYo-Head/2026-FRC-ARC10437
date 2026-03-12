package frc.robot.Systems;

import com.revrobotics.PersistMode;
import com.revrobotics.ResetMode;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkMaxConfig;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ClimberSystem extends SubsystemBase{
    private final SparkMax CLMBMotor = new SparkMax(7, SparkMax.MotorType.kBrushed);

    public ClimberSystem() {
        SparkMaxConfig globalConfig = new SparkMaxConfig();

        globalConfig
            .smartCurrentLimit(5000);

        CLMBMotor.configure(globalConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    
    }

    public void setClimbVoltage(double volts) {
        CLMBMotor.setVoltage(volts);

    }

    public void stop() {
        CLMBMotor.setVoltage(0);

    }
    
}
