package frc.robot.AutonomousPrograms;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

import frc.robot.Systems.DriveSystem;
import frc.robot.Systems.InstrumentSystem;

public class AutoDrive extends SequentialCommandGroup {

    public AutoDrive(DriveSystem driveSubsystem, InstrumentSystem instrumentSubSystem) {

        addRequirements(driveSubsystem, instrumentSubSystem);

        addCommands(
            driveSubsystem.back(3, instrumentSubSystem)
            
            
        );
    }
}

