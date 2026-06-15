package frc.robot.Systems;

import com.revrobotics.PersistMode;
import com.revrobotics.ResetMode;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkMaxConfig;

import frc.robot.Configs.ClimberSystemConfig;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ClimberSystem extends SubsystemBase{
    private final ClimberSystemConfig CSC = new ClimberSystemConfig();
    private final SparkMax CLMBMotor = new SparkMax(CSC.CMBMotorID, SparkMax.MotorType.kBrushed);

    public ClimberSystem() {
        SparkMaxConfig globalConfig = new SparkMaxConfig();

        globalConfig
            .smartCurrentLimit(CSC.GlobalSCM);

        CLMBMotor.configure(globalConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    
    }

    public void setClimbVoltage(double volts) {
        CLMBMotor.setVoltage(volts);

    }

    public void stop() {
        CLMBMotor.setVoltage(0);

    }
    
}
