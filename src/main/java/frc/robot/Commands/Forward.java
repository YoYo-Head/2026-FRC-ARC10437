package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Systems.InstrumentSystem;
import frc.robot.Systems.DriveSystem;

public class Forward extends Command {
    InstrumentSystem instrumentSubSystem;
    DriveSystem driveSubSystem;

    double metre;

    public Forward(DriveSystem driveSystem, InstrumentSystem instrumentSystem, double metresTarget) {
        this.driveSubSystem = driveSystem;
        this.instrumentSubSystem = instrumentSystem;

        this.metre = metresTarget;

        addRequirements(driveSubSystem);
        addRequirements(instrumentSubSystem);

    }

    @Override
    public void initialize() {
        
    }

    @Override
    public void execute() {
        driveSubSystem.forward(metre, instrumentSubSystem);
        
    }

    @Override
    public void end(boolean interrupted) {
        
    }

    @Override
    public boolean isFinished() {
        return true;
    }
}