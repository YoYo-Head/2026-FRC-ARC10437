package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Systems.IntakeOutakeSystem;
import frc.robot.Configs.IntakeOutakeSystemConfig;

public class Intake extends Command {
    private IntakeOutakeSystemConfig IOSC = new IntakeOutakeSystemConfig();
    IntakeOutakeSystem fuelSubSystem;

    public Intake(IntakeOutakeSystem fuelSystem) {
        this.fuelSubSystem = fuelSystem;
    }

    @Override
    public void initialize() {
        fuelSubSystem.setIntakeSpeed(IOSC.IntakeIntakeVoltage);
        fuelSubSystem.setFeederSpeed(IOSC.IntakeFeederVoltage);
    }

    @Override
    public void execute() {
        
    }

    @Override
    public void end(boolean interrupted) {
        fuelSubSystem.setIntakeSpeed(0.0);
        fuelSubSystem.setFeederSpeed(0.0);
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}