package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;

import frc.robot.AutonomousPrograms.AutoDrive;
import frc.robot.Commands.Camera;
import frc.robot.Commands.Eject;
import frc.robot.Commands.LaunchSequence;
import frc.robot.Commands.Intake;
import frc.robot.Systems.CameraSystem;
import frc.robot.Systems.IntakeOutakeSystem;
import frc.robot.Systems.DriveSystem;
import frc.robot.Systems.InstrumentSystem;
import frc.robot.Configs.ControlConfig;

public class RobotContainer {
    private final DriveSystem driveSubSystem = new DriveSystem();
    private final IntakeOutakeSystem fuelSubSystem = new IntakeOutakeSystem();
    private final CameraSystem cameraSubSystem = new CameraSystem();
    private final InstrumentSystem instrumentSubSystem = new InstrumentSystem();

    private final AutoDrive autoDrive = new AutoDrive(); 

    private final CommandXboxController controller = new CommandXboxController(0);

    public RobotContainer() {
        configureBindings();

    }

    private void configureBindings() {
        controller.leftBumper().whileTrue(new Intake(fuelSubSystem));
        controller.rightBumper().whileTrue(new LaunchSequence(fuelSubSystem));
        controller.a().whileTrue(new Eject(fuelSubSystem));

    }

    public void getAutonomousCommand() {
        autoDrive.beginPathway();
    }
    
}
