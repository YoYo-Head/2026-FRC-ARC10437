package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Systems.IntakeOutakeSystem;

public class Intake extends Command {
    IntakeOutakeSystem fuelSubSystem;

    public Intake(IntakeOutakeSystem fuelSystem) {
        this.fuelSubSystem = fuelSystem;
    }

    @Override
    public void initialize() {
        fuelSubSystem.setIntakeSpeed(10.0);
        fuelSubSystem.setFeederSpeed(9.0);
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