package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Systems.ClimberSystem;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

public class Extend extends Command {
    ClimberSystem climberSubSystem;
    CommandXboxController DriveController;

    public Extend(ClimberSystem climberSystem) {
        this.climberSubSystem = climberSystem;

        addRequirements(climberSubSystem);
       
    }

    @Override
    public void initialize() {
        climberSubSystem.setClimbVoltage(-8);
        
    }

    @Override
    public void execute() {
        
    }

    @Override
    public void end(boolean interrupted) {
        climberSubSystem.stop();
    

    }

    @Override
    public boolean isFinished() {
        return false;
    }
}