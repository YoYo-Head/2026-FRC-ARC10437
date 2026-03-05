package frc.robot.AutonomousPrograms;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

import frc.robot.Systems.DriveSystem;
import frc.robot.Systems.InstrumentSystem;

import frc.robot.Commands.Turn;
import frc.robot.Commands.Forward;

public class AutoDrive extends SequentialCommandGroup {

    public AutoDrive(DriveSystem driveSubsystem, InstrumentSystem instrumentSubSystem) {

        addCommands(
            new Forward(driveSubsystem, instrumentSubSystem, 2),
            new Turn(driveSubsystem, instrumentSubSystem, 45),
            new Forward(driveSubsystem, instrumentSubSystem, 5),
            new Turn(driveSubsystem, instrumentSubSystem, 180)
            
        );
    }
}

