package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Systems.IntakeOutakeSystem;

public class LaunchSequence extends SequentialCommandGroup {
    public LaunchSequence(IntakeOutakeSystem fuelSubSystem) {
        addCommands(
            new SpinUp(fuelSubSystem),
            new Launch(fuelSubSystem)
        );
    }
    
}
