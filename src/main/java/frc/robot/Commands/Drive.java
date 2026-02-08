package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Systems.DriveSystem;
import frc.robot.Configs.ControlConfig;

public class Drive extends Command {
    DriveSystem driveSubSystem;

    public Drive(DriveSystem driveSystem) {
        this.driveSubSystem = driveSystem;
    }

    @Override
    public void initialize() {
        
    }

    @Override
    public void execute() {
        driveSubSystem.drive(ControlConfig.SpeedJoystick, ControlConfig.TurnJoystick);
        
    }

    @Override
    public void end(boolean interrupted) {
        driveSubSystem.drive(0, 0);

    }

    @Override
    public boolean isFinished() {
        return false;
    }
}