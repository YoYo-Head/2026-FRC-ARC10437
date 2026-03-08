package frc.robot;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

import frc.robot.AutonomousPrograms.AutoDrive;
import frc.robot.AutonomousPrograms.ExampleAuto;
import frc.robot.Commands.Drive;
import frc.robot.Commands.Camera;
import frc.robot.Commands.Eject;
import frc.robot.Commands.LaunchSequence;
import frc.robot.Commands.Telemetry;
import frc.robot.Commands.Intake;
import frc.robot.Systems.CameraSystem;
import frc.robot.Systems.IntakeOutakeSystem;
import frc.robot.Systems.DriveSystem;
import frc.robot.Systems.InstrumentSystem;

@SuppressWarnings("unused")
public class RobotContainer {
    private final SendableChooser<Command> autoChooser = new SendableChooser<>();

    private final DriveSystem driveSubSystem = new DriveSystem();
    private final IntakeOutakeSystem fuelSubSystem = new IntakeOutakeSystem();
    private final CameraSystem cameraSubSystem = new CameraSystem();
    private final InstrumentSystem instrumentSubSystem = new InstrumentSystem();

    private final CommandXboxController controller = new CommandXboxController(0);

    public RobotContainer() {
        configureBindings();

        autoChooser.addOption("Gyro Drive", new AutoDrive(driveSubSystem, instrumentSubSystem));
        autoChooser.addOption("Shoot Program", new ExampleAuto(driveSubSystem, fuelSubSystem));

        SmartDashboard.putData("Auto Choices", autoChooser);

    }

    private void configureBindings() {
        controller.leftBumper().whileTrue(new Intake(fuelSubSystem));
        controller.rightBumper().whileTrue(new LaunchSequence(fuelSubSystem));
        controller.a().whileTrue(new Eject(fuelSubSystem));

        driveSubSystem.setDefaultCommand(new Drive(driveSubSystem, controller));
        //cameraSubSystem.setDefaultCommand(new Camera(cameraSubSystem));
        instrumentSubSystem.setDefaultCommand(new Telemetry(instrumentSubSystem));
        fuelSubSystem.setDefaultCommand(fuelSubSystem.run(() -> fuelSubSystem.stop()));

    }

    public Command getAutonomousCommand() {
        return autoChooser.getSelected();

    }
    
}
