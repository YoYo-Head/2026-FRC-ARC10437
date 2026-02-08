package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Systems.CameraSystem;

public class Camera extends Command {
    CameraSystem cameraSubSystem;

    public Camera(CameraSystem cameraSystem) {
        this.cameraSubSystem = cameraSystem;
    }

    @Override
    public void initialize() {
        cameraSubSystem.cameraSystemInit();
    }

    @Override
    public void execute() {
        
    }

    @Override
    public void end(boolean interrupted) {

    }

    @Override
    public boolean isFinished() {
        return false;
    }
    
}
