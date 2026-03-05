package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Systems.InstrumentSystem;
import frc.robot.Systems.DriveSystem;

public class Turn extends Command {
    InstrumentSystem instrumentSubSystem;
    DriveSystem driveSubSystem;

    double degree;

    public Turn(DriveSystem driveSystem, InstrumentSystem instrumentSystem, double degreeTarget) {
        this.driveSubSystem = driveSystem;
        this.instrumentSubSystem = instrumentSystem;

        this.degree = degreeTarget;

        addRequirements(driveSubSystem);
        addRequirements(instrumentSubSystem);

    }

    @Override
    public void initialize() {
        
    }

    @Override
    public void execute() {
        driveSubSystem.turn(degree, instrumentSubSystem);
        
    }

    @Override
    public void end(boolean interrupted) {
        
    }

    @Override
    public boolean isFinished() {
        return true;
    }
}