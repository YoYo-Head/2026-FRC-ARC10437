package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Systems.IntakeOutakeSystem;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.RepeatCommand;

public class LaunchSequence extends SequentialCommandGroup {


    public LaunchSequence(IntakeOutakeSystem fuelSubSystem) {
        addCommands(
            new SpinUp(fuelSubSystem).withTimeout(1),
            new Launch(fuelSubSystem)
        );
    }
    
}
