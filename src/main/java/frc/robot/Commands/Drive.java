package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Systems.DriveSystem;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

public class Drive extends Command {
    DriveSystem driveSubSystem;
    CommandXboxController DriveController;

    public Drive(DriveSystem driveSystem, CommandXboxController controller) {
        this.driveSubSystem = driveSystem;
        DriveController = controller;
    }

    @Override
    public void initialize() {
        driveSubSystem.driveSystemInit();
    }

    @Override
    public void execute() {
        driveSubSystem.drive(DriveController.getLeftY(), DriveController.getRightX());
        
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