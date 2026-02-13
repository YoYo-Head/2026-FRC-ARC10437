package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Systems.IntakeOutakeSystem;
import frc.robot.Configs.IntakeOutakeSystemConfig;

public class Eject extends Command {
    private IntakeOutakeSystemConfig IOSC = new IntakeOutakeSystemConfig();
    IntakeOutakeSystem fuelSubSystem;

    public Eject(IntakeOutakeSystem fuelSystem) {
        this.fuelSubSystem = fuelSystem;
    }

    @Override
    public void initialize() {
        fuelSubSystem.setIntakeSpeed(IOSC.EjectIntakeVoltage);
        fuelSubSystem.setFeederSpeed(IOSC.EjectFeederVoltage);
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