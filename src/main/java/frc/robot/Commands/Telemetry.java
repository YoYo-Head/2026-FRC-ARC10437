package frc.robot.Commands;

import frc.robot.Systems.InstrumentSystem;
import edu.wpi.first.wpilibj2.command.Command;

public class Telemetry extends Command {

    private InstrumentSystem instrumentSubSystem = new InstrumentSystem();

    public Telemetry(InstrumentSystem instrumentSystem) {
        this.instrumentSubSystem = instrumentSystem;
        addRequirements(instrumentSubSystem);
    }

    @Override
    public void initialize() {
        
    }

    @Override
    public void execute() {
        instrumentSubSystem.pushGyroInfo(instrumentSubSystem);

    }

    @Override
    public void end(boolean interrupted) {

    }
}
