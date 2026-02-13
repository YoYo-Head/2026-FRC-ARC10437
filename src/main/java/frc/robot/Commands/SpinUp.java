package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Systems.IntakeOutakeSystem;
import frc.robot.Configs.IntakeOutakeSystemConfig;

public class SpinUp extends Command {
    private IntakeOutakeSystemConfig IOSC = new IntakeOutakeSystemConfig();
    IntakeOutakeSystem fuelSubSystem;

    public SpinUp(IntakeOutakeSystem fuelSystem) {
        this.fuelSubSystem = fuelSystem;
    }

    @Override
    public void initialize() {
        fuelSubSystem.setIntakeSpeed(IOSC.SpinUpIntakeVoltage);
        fuelSubSystem.setFeederSpeed(IOSC.SpinUpFeederVoltage);
    }

    @Override
    public void execute() {
        
    }

    @Override
    public void end(boolean interrupted) {
       
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}