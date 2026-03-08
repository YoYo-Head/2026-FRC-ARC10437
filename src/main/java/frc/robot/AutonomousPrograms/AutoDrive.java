package frc.robot.AutonomousPrograms;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

import frc.robot.Systems.DriveSystem;
import frc.robot.Systems.InstrumentSystem;

public class AutoDrive extends SequentialCommandGroup {

    public AutoDrive(DriveSystem driveSubsystem, InstrumentSystem instrumentSubSystem) {

        addRequirements(driveSubsystem, instrumentSubSystem);

        addCommands(
            driveSubsystem.forward(1, instrumentSubSystem),
            driveSubsystem.turn(45, instrumentSubSystem),
            driveSubsystem.forward(2, instrumentSubSystem),
            driveSubsystem.turn(180, instrumentSubSystem)
            
        );
    }
}

