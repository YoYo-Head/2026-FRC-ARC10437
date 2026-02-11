package frc.robot.Systems;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.cscore.UsbCamera;
import frc.robot.Configs.CameraSystemConfig;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class CameraSystem extends SubsystemBase{

    private UsbCamera camera;

    public void cameraSystemInit() {
        camera = CameraServer.startAutomaticCapture();

        camera.setFPS(CameraSystemConfig.cameraFPS);
        camera.setResolution(CameraSystemConfig.cameraResWidth, CameraSystemConfig.cameraResHeight);

    }


    
}
