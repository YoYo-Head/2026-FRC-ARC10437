package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Systems.IntakeOutakeSystem;

public class SpinUp extends Command {
    IntakeOutakeSystem fuelSubSystem;

    public SpinUp(IntakeOutakeSystem fuelSystem) {
        this.fuelSubSystem = fuelSystem;
    }

    @Override
    public void initialize() {
        fuelSubSystem.setIntakeSpeed(10.6);
        fuelSubSystem.setFeederSpeed(-6.0);
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