package frc.robot.AutonomousPrograms;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Systems.DriveSystem;

public class AutoDrive extends SequentialCommandGroup {

    public AutoDrive(DriveSystem driveSubsystem) {

        addCommands(
            driveSubsystem.forward(2),
            driveSubsystem.turn(45),
            driveSubsystem.forward(5),
            driveSubsystem.turn(180)
        );
    }
}

